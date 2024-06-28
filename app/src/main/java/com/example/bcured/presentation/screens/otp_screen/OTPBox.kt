package com.example.bcured.presentation.screens.otp_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OTPBox(

) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .border(BorderStroke(1.dp, Color.Black))
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.size(50.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                cursorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewOTPBox() {
    OTPBox()
}