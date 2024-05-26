package com.example.bcured.Presentation.Navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bcured.Presentation.Screens.HomeScreen
import com.example.bcured.ViewModel.ImageSelectionViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    imageSelectionViewModel: ImageSelectionViewModel,
    onCameraButtonClicked: () -> Unit,
    onImageButtonClicked: () -> Unit,
    activity: Activity
) {
    NavHost(
        startDestination = "home_screen",
        navController = navController
    ) {
        composable("home_screen") {
            HomeScreen(
                imageSelectionViewModel,
                onCameraButtonClicked,
                onImageButtonClicked,
                activity
            )
        }
    }
}