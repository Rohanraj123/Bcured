package com.health.bcured.util

import com.health.bcured.data.modal.GeminiResponse

data class ResponseUiState(
    val responseList: List<GeminiResponse> = listOf()
)