package com.health.bcured.views.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.health.bcured.ui.theme.BlueColor

@Composable
fun BlueButton (
    title : String,
    onClick : () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = BlueColor
        )
    ) {
        Text(text = title)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBlueButton() {
    BlueButton(title = "Login", onClick = { /*TODO*/ })
}
