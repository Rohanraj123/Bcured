package com.health.bcured.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.health.bcured.ui.theme.BlueColor

@Composable
fun CircularButton(
    onClick: () -> Unit,
    title: String
) {
    Box(modifier = Modifier
        .background(color = BlueColor, shape = CircleShape)
        .clickable { onClick() }
        .size(50.dp)
        .clip(CircleShape),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = title, fontSize = 30.sp)
    }
}