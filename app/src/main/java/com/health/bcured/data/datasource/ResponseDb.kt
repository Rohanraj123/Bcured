package com.health.bcured.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.health.bcured.data.modal.GeminiResponse

/**
 * Room Database configuration
 */
@Database(entities = [GeminiResponse::class], version = 1, exportSchema = false)
abstract class ResponseDb : RoomDatabase() {

    /** Instance of ResponseDao.*/
    abstract val responseDao : ResponseDao
}