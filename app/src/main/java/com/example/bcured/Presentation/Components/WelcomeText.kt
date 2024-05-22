package com.example.bcured.Presentation.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeText() {

    Row {
        Text(
            text = "Welcome to ",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            text = "BCURED",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}
