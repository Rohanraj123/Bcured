package com.health.bcured

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.health.bcured.ui.theme.BcuredTheme
import com.health.bcured.viewmodel.AuthViewModel
import com.health.bcured.views.Navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BcuredTheme {
                val navController = rememberNavController()
                val authViewModel = hiltViewModel<AuthViewModel>()

                Navigation(navController = navController, authViewModel = authViewModel)

            }
        }
    }
}
