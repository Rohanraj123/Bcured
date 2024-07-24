package com.health.bcured.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizer
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import com.health.bcured.data.datasource.ResponseDao
import com.health.bcured.data.datasource.ResponseDb
import com.health.bcured.data.repositories.ResponseRepository
import com.health.bcured.data.repositoryimpl.ResponseRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Machine learning Module to provide dependencies
 * related to Firebase ML kits.
 */
@Module
@InstallIn(SingletonComponent::class)
class MLModule {

    /** Provides TextRecognizer instance for text extraction purpose.*/
    @Provides
    @Singleton
    fun providesTextRecognizer() : TextRecognizer {
        return TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
    }

    /** Provides Context for general purpose.*/
    @Provides
    @Singleton
    fun providesContext(@ApplicationContext context: Context) : Context {
        return context
    }

    /** Provides Room DB instance for CRUD ops.*/
    @Provides
    @Singleton
    fun providesResponseDatabase(application: Application) : ResponseDb {
        return Room.databaseBuilder(
            application.applicationContext,
            ResponseDb::class.java,
            "new_response_db"
        ).build()
    }

    /** Provides ResponseDao instance for DB ops.*/
    @Provides
    @Singleton
    fun providesResponseDao(responseDb: ResponseDb): ResponseDao {
        return responseDb.responseDao
    }

    /** Provides ResponseRepository instance for repository implementation.*/
    @Provides
    @Singleton
    fun providesResponseRepository(responseDao: ResponseDao) : ResponseRepository {
        return ResponseRepositoryImpl(responseDao)
    }
}
