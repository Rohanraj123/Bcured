package com.example.bcured.presentation.screens.login_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.bcured.R
import com.example.bcured.ui.theme.NumberOptionsContainerColor1


@Composable
fun PreviousNumberOption(
    profileUrl: String,
    phoneNumber: Long
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp, vertical = 8.dp)
    ){

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(
                    color = NumberOptionsContainerColor1,
                    shape = RoundedCornerShape(
                        topStart = 25.dp,
                        topEnd = 25.dp,
                        bottomEnd = 25.dp,
                        bottomStart = 25.dp
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .matchParentSize()
            ) {

                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .padding(4.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(
                                topEnd = 50.dp,
                                topStart = 50.dp,
                                bottomStart = 50.dp,
                                bottomEnd = 50.dp,
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.AccountCircle, contentDescription = null, tint = Color.Gray)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "+91 $phoneNumber",
                            fontWeight = FontWeight.SemiBold,
                            color = Color.DarkGray,
                        )
                        Text(
                            text = stringResource(id = R.string.use_phone_number),
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .padding(4.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(
                                    topEnd = 50.dp,
                                    topStart = 50.dp,
                                    bottomStart = 50.dp,
                                    bottomEnd = 50.dp,
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.KeyboardArrowRight,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}