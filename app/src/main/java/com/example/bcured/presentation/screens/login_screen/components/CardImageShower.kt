package com.example.bcured.presentation.screens.login_screen.components

import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

@Composable
fun CardImageShower(
    url: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(4.dp)
            )
    ) {
        Column {
            
           LoadImageWithPicasso(
               imageUrl = url ,
               modifier = Modifier
                   .fillMaxWidth()
                   .height(200.dp)
                   .clip(RoundedCornerShape(30.dp))
           )
            HorizontalDivider(
                thickness = 2.dp,
            )
        }
    }
}

@Composable
fun LoadImageWithPicasso(imageUrl: String, modifier: Modifier = Modifier) {
    AndroidView(
        factory = { context ->
            ImageView(context).apply {
                scaleType = ImageView.ScaleType.CENTER_CROP
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
        },
        update = { imageView ->
            Picasso.get()
                .load(imageUrl)
                .into(imageView, object : Callback {
                    override fun onSuccess() {
                    }

                    override fun onError(e: Exception?) {

                        Log.e("Picasso", "Image loading failed: ${e?.message}", e)
                    }
                })
        },
        modifier = modifier
    )
}
