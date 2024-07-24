package com.health.bcured.views.components

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ImageViewer(
    uri: Uri?,
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(400.dp)
        .border(BorderStroke(1.dp, Color.Black))
        .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        if (uri != null) AsyncImage(model = uri.toString(), contentDescription = null)
        else Text(text = "Click/Select Image in Vertical View", fontSize = 30.sp, fontWeight = FontWeight.Bold)
    }
}