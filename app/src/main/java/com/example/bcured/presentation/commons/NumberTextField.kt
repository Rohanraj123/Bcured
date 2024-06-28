package com.example.bcured.presentation.commons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumberTextField(
    onValueChange: () -> Unit,
    value: String
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp, end = 50.dp, bottom = 50.dp, top = 8.dp),
    ) {
        Box (
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth()
                .padding(8.dp)
                .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(8.dp))
        ){
            Row (
                modifier = Modifier
                    .matchParentSize(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "+91",
                    modifier = Modifier.padding(horizontal = 4.dp),

                    )
                VerticalDivider(color = Color.Black, modifier = Modifier.padding(vertical = 8.dp))
                TextField(
                    value = value,
                    modifier = Modifier
                        .fillMaxWidth(),
                    onValueChange = { onValueChange() },
                    placeholder = { Text(
                        text = "Enter you phone number",
                        fontSize = 13.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        cursorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType =  KeyboardType.Number
                    )
                )
            }
        }
    }

}