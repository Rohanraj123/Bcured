package com.health.bcured.data.repositories

import com.health.bcured.data.modal.GeminiResponse
import kotlinx.coroutines.flow.Flow

/**
 * Repository to provide response management services
 */
interface ResponseRepository {

    /**
     * Save the gemini response to room database
     *
     * @param geminiResponse Response generated after processing text
     */
    suspend fun saveResponse(geminiResponse: GeminiResponse)

    /**
     * Fetch the list of gemini responses saved in room database
     *
     * @return List<GeminiResponse> List of gemini response saved into database
     */
    fun getResponses() : Flow<List<GeminiResponse>>

    /**
     * Fetch the gemini response by ID, saved in room database
     *
     * @param responseId Response ID, saved into database
     * @return List<GeminiResponse> List of gemini response saved into database
     */
    suspend fun getResponseById(responseId: Long) : GeminiResponse
}
