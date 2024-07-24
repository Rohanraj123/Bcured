package com.health.bcured.data.modal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity class with different attributes
 */
@Entity(tableName = "responses")
data class GeminiResponse(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "reportName") val reportName: String,
    @ColumnInfo(name = "content") val content: String
)
