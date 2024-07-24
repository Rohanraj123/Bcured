package com.health.bcured.viewmodel

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import com.health.bcured.R
import com.health.bcured.data.modal.GeminiResponse
import com.health.bcured.data.repositories.ResponseRepository
import com.health.bcured.util.ResponseUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Hilt view model provided for text processing ops
 */
@HiltViewModel
class TextAnalysisViewModel @Inject constructor(
     context: Context,
    private val responseRepository: ResponseRepository
) : ViewModel() {

    /** Instance of generative model of gemini.*/
    private val generativeModel = GenerativeModel(
        modelName = context.getString(R.string.modal_name),
        apiKey = context.getString(R.string.apikey)
    )

    /** State management for extracted text from image.*/
    private var _imageTextContent = MutableStateFlow<String?>(null)
    val imageTextContent: StateFlow<String?> = _imageTextContent

    /** State management for prompt response.*/
    private var _promptResponse = MutableStateFlow("")
    val promptResponse: StateFlow<String> = _promptResponse

    /** State management for concurrent list of reports.*/
    val responsesListUiState : StateFlow<ResponseUiState> =
        responseRepository.getResponses().map { ResponseUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ResponseUiState()
            )

    /** Constant for concurrency time out.*/
    companion object { private const val TIMEOUT_MILLIS = 5_000L }

    /** Re-initialisation of context because, context was not accessible in fun body.*/
    private val appContext = context

    /** Async extraction of text from Image using URI.*/
    fun extractImageText(imageUri: Uri) {
        viewModelScope.launch {
            try {
                val recogniser = TextRecognition.getClient(
                    TextRecognizerOptions.DEFAULT_OPTIONS
                )
                val image = InputImage.fromFilePath(
                    appContext,
                    imageUri
                )

                recogniser.process(image)
                    .addOnSuccessListener { visionText ->
                        _imageTextContent.value = visionText.text
                    }
                    .addOnFailureListener {
                        _promptResponse.value = appContext.getString(R.string.prompt_response_onfailure)
                    }

            } catch (e: Exception) {
                _promptResponse.value = "Error processing the image ${e.message}"
            }
        }
    }

    /** Async prompt generation only after text extraction completed.*/
    fun makePrompt(reportName: String) {
        viewModelScope.launch {
            val prompt = appContext.getString(R.string.prompt).trimIndent()
            val response = generativeModel.generateContent(prompt)
            _promptResponse.value = response.text.toString()
            if (response.text != null) saveResponse(GeminiResponse(0, response.text.toString(), reportName))
        }
    }

    /** Save the response generated when invoked.*/
    private fun saveResponse(geminiResponse: GeminiResponse) {
        viewModelScope.launch {
            responseRepository.saveResponse(geminiResponse)
        }
    }
}
