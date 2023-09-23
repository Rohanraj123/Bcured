package com.example.bcured

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bcured.ui.theme.BcuredTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BcuredTheme {
                //code from here for this activity.



            }
        }
    }
}

@Composable
fun Greeting() {
    val modifier = Modifier.fillMaxSize(1f)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting()
}