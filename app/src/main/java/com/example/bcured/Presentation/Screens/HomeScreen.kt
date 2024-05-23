package com.example.bcured.Presentation.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bcured.Presentation.Components.AskForPicture
import com.example.bcured.Presentation.Components.BackButton
import com.example.bcured.Presentation.Components.CustomFloatingButton
import com.example.bcured.Presentation.Components.WelcomeText
import com.example.bcured.util.calculateCurrentWidth

@Composable
fun HomeScreen(

) {
    val context = LocalContext.current
    val paddingStart = calculateCurrentWidth(context).dp

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            BackButton {/* OnClick */ }
            Spacer(modifier = Modifier.width(30.dp))
            WelcomeText()
        }
        Row(
            modifier = Modifier.padding(horizontal = paddingStart / 14)
        ) {
            AskForPicture()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomFloatingButton(
                text = "C",
                onClick = {},
                modifier = Modifier
            )
            Spacer(modifier = Modifier.width(30.dp))
            CustomFloatingButton(
                text = "G",
                onClick = {},
                modifier = Modifier
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

