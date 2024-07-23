package com.health.bcured.views.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(35.dp)
            .background(
                color = Color.Transparent
            )
            .border(
                BorderStroke(1.dp, Color.Black),
                shape = RoundedCornerShape(10.dp)
            )
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .then(modifier)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BackButtonPreview() {
    BackButton(onClick = { /*TODO*/ })
}
