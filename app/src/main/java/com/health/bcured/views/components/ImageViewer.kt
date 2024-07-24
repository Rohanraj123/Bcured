package com.health.bcured.views.components

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
        .width(100.dp)
        .height(100.dp)
        .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(10.dp))
        .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        if (uri != null) AsyncImage(model = uri.toString(), contentDescription = null)
        else Icon(Icons.Default.Add, contentDescription = null)
    }
}