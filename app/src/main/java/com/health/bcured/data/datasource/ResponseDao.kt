package com.health.bcured.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.health.bcured.data.modal.GeminiResponse
import kotlinx.coroutines.flow.Flow

/**
 * Data access object for database operations
 * of generated responses by LLM
 */
@Dao
interface ResponseDao {
    /**
     * suspending fun to save the responses
     *
     * @param geminiResponse Response of current extracted medical text
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveResponse(geminiResponse: GeminiResponse)

    /**
     * fun to fetch all the responses
     *
     * @return List<GeminiResponse> List of responses saved in the Database
     */
    @Query("SELECT * FROM responses")
    fun getResponses() : Flow<List<GeminiResponse>>

    /**
     * suspending fun to fetch the response by ID
     *
     * @param responseId Response of current extracted medical text
     * @return GeminiResponse Response saved in the Database
     */
    @Query("SELECT * FROM responses WHERE id = :responseId")
    suspend fun getResponseById(responseId: Long) : GeminiResponse
}
