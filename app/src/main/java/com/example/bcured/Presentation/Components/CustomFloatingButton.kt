package com.example.bcured.Presentation.Components

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun CustomFloatingButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FloatingActionButton(
        onClick = { onClick() },
        modifier = modifier
    ) {
        Text(
            text = text,
            fontSize = 30.sp
        )
    }
}