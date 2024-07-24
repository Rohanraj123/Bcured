package com.health.bcured.data.repositoryimpl

import com.health.bcured.data.datasource.ResponseDao
import com.health.bcured.data.modal.GeminiResponse
import com.health.bcured.data.repositories.ResponseRepository
import kotlinx.coroutines.flow.Flow

/**
 * ResponseRepository implementation to implement services
 */
class ResponseRepositoryImpl(
    private val responseDao: ResponseDao
) : ResponseRepository {

    /**
     * Save the gemini response to room database
     *
     * @param geminiResponse Response generated after processing text
     */
    override suspend fun saveResponse(geminiResponse: GeminiResponse) {
        responseDao.saveResponse(geminiResponse)
    }

    /**
     * Fetch the list of gemini responses saved in room database
     *
     * @return List<GeminiResponse> List of gemini response saved into database
     */
    override fun getResponses(): Flow<List<GeminiResponse>> {
        return responseDao.getResponses()
    }

    /**
     * Fetch the gemini response by ID, saved in room database
     *
     * @param responseId Response ID, saved into database
     * @return List<GeminiResponse> List of gemini response saved into database
     */
    override suspend fun getResponseById(responseId: Long): GeminiResponse {
        return responseDao.getResponseById(responseId)
    }
}