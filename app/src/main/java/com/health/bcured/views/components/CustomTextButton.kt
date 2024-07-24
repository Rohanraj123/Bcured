package com.health.bcured.views.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.health.bcured.ui.theme.BlueColor

@Composable
fun CustomTextButton(
    onClick: () -> Unit,
    title: String
) {
    TextButton(onClick = { onClick() }) {
        Text(text = title, color = BlueColor)
    }
}
