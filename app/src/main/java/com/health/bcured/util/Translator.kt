package com.health.bcured.util

import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.tasks.await

/**
 * Translator object to translate text from English to Hindi
 */
object Translator {

    /** Options provider.*/
    private val options = TranslatorOptions.Builder()
        .setSourceLanguage(TranslateLanguage.ENGLISH)
        .setTargetLanguage(TranslateLanguage.HINDI)
        .build()

    /** Translator instance.*/
    private val englishHindiTranslator = Translation.getClient(options)

    /** Method to convert text to hindi.*/
    suspend fun convertToHindi(content: String) : String {
        val deferred = CompletableDeferred<String>()
        val conditions = DownloadConditions.Builder()
            .requireWifi()
            .build()

        try {
            englishHindiTranslator.downloadModelIfNeeded(conditions).await()
            val translatedText = englishHindiTranslator.translate(content).await()
            deferred.complete(translatedText)
        } catch (e : Exception) {
            e.printStackTrace()
            deferred.complete("")
        }

        return deferred.await()
    }
}