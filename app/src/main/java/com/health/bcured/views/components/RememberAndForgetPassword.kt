package com.health.bcured.views.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.health.bcured.ui.theme.BlueColor


@Composable
fun RememberAndForgetPassword(
    isChecked: Boolean,
    onCheckChange: (Boolean) -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row (
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked ->
                    onCheckChange(isChecked)
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = BlueColor
                ),
            )
            Text(
                text = "Remember info",
                color = Color.Gray
            )
        }

        TextButton(
            onClick = { /*TODO*/ },
        ) {
            Text(
                text = "Forgot Password ?",
                color = BlueColor
            )
        }
    }
}