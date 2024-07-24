package com.health.bcured.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel to help the process of gallery result
 * registration process.
 * Extra viewmodel provided because hilt viewmodel can't
 * be initialised before activity started.
 */
class ImageSelectionViewModel : ViewModel() {

    /** State management for gallery result status.*/
    private val _imageResult = MutableStateFlow<Uri?>(null)
    val imageResult: StateFlow<Uri?> = _imageResult

    /** Method to hold the gallery result e.g. URI.*/
    fun onGalleryResult(uri: Uri?) {
        viewModelScope.launch {
            _imageResult.value = uri
        }
    }
}
