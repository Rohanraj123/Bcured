package com.example.bcured.util

import android.content.Context
import android.util.DisplayMetrics

fun calculateCurrentWidth(
    context: Context
): Int {
    val displayMetrics: DisplayMetrics = context.resources.displayMetrics
    return displayMetrics.widthPixels
}