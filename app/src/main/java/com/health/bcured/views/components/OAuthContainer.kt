package com.health.bcured.views.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.health.bcured.R

@Composable
fun OAuthContainer(
    image: Painter,
    title: String,
    onClick: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidthPx = configuration.screenWidthDp

    val density = LocalDensity.current.density
    val screenWidthInPx = screenWidthPx * density

    val boxWidth = (screenWidthInPx / 4.5).dp
    val boxHeight = (screenWidthInPx / 13).dp

    val shape = RoundedCornerShape(15.dp)

    Box(
        modifier = Modifier
            .border(
                BorderStroke(1.dp, Color.Black),
                shape = shape
            )
            .width(boxWidth)
            .height(boxHeight)
            .clip(shape)
    ) {
        Box(
            modifier = Modifier
                .clickable { onClick() }
                .fillMaxSize()
                .background(Color.White, shape)
                .border(
                    BorderStroke(1.dp, Color.Black),
                    shape = shape
                )
                .wrapContentSize(Alignment.Center)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Divider(
                    modifier = Modifier
                        .width(0.5.dp)
                        .height(20.dp),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    fontSize = 13.sp
                )
            }
        }
    }
}
