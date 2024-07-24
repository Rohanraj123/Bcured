package com.health.bcured.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ImageSelectionViewModel : ViewModel() {

    private val _imageResult = MutableStateFlow<Uri?>(null)
    val imageResult: StateFlow<Uri?> = _imageResult

    fun onGalleryResult(uri: Uri?) {
        viewModelScope.launch {
            _imageResult.value = uri
        }
    }
}