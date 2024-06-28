package com.example.bcured.presentation.screens.otp_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bcured.R
import com.example.bcured.presentation.commons.NumberTextField
import com.example.bcured.ui.theme.BackgroundColor1
import com.example.bcured.ui.theme.BackgroundColor2

@Composable
fun OTPScreen(
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
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.enter_otp),
                        modifier = Modifier
                            .padding(start = 14.dp, end = 14.dp, top = 50.dp, bottom = 8.dp),
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal,
                        fontSize = 30.sp
                    )
                }
                Text(
                    text = stringResource(id = R.string.enter_otp_text1),
                    color = Color.DarkGray,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(4.dp)
                )
                Text(
                    text = stringResource(id = R.string.enter_otp_text12),
                    color = Color.DarkGray,
                    fontWeight = FontWeight.SemiBold
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 50.dp, end = 50.dp, top = 25.dp, bottom = 55.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    OTPBox()
                    OTPBox()
                    OTPBox()
                    OTPBox()
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 50.dp, end = 50.dp, bottom = 250.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string.resend_otp_in) + " 23",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(4.dp)
                    )
                    Row {
                        Text(
                            text = stringResource(id = R.string.Call),
                            color = Color.Green,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(4.dp)
                        )
                        VerticalDivider(
                            modifier = Modifier.height(20.dp)
                        )
                        Text(
                            text = stringResource(id = R.string.SMS),
                            color = Color.Green,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                }
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
fun PreviewOTPScreen() {
    val navController = rememberNavController()
    OTPScreen(navController)
}