package com.example.bcured.Presentation.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun AskForPicture() {
    Column {
        Text(
            text = "Click picture or select",
            modifier = Modifier,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        )
        Text(
            text = "From gallery to get the",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        )
        Text(
            text = "desired result of the ",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        )
        Text(
            text = "report",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        )
    }
}