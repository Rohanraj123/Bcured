package com.example.bcured.presentation.screens.login_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bcured.R
import com.example.bcured.presentation.screens.login_screen.components.LogInText
import com.example.bcured.presentation.commons.NumberTextField
import com.example.bcured.presentation.screens.login_screen.components.PreviousNumberOption
import com.example.bcured.ui.theme.BackgroundColor1
import com.example.bcured.ui.theme.BackgroundColor2

@Composable
fun LoginScreen(
    navController: NavHostController
) {
    val colors = listOf(BackgroundColor1, BackgroundColor2)
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush
                    .linearGradient(
                        colors = colors,
                        start = Offset.Zero,
                        end = Offset.Infinite,
                        tileMode = TileMode.Mirror
                    )
            )
    ) {
        Column {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 50.sp
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    Icons.Default.Face,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(300.dp)
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp
                    )
                )
                .align(Alignment.BottomCenter),
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    LogInText()
                }
                PreviousNumberOption(profileUrl = "", phoneNumber = 8838883747L)
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 100.dp),
                    thickness = 1.dp,
                    color = Color.Black
                )
                NumberTextField({navController.navigate("welcome_screen")}, "")
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 150.dp, vertical = 8.dp),
                    thickness = 1.dp,
                    color = Color.Black
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen(

) {
    val navController = rememberNavController()
    LoginScreen(navController)
}