package com.example.bcured.presentation.screens.login_screen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bcured.R


@Composable
fun LogInText() {
    Text(
        text = stringResource(id = R.string.login_text),
        modifier = Modifier
            .padding(start = 14.dp, end = 14.dp, top = 50.dp, bottom = 8.dp),
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 30.sp
    )
}