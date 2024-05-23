package com.example.bcured.Presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bcured.Presentation.Screens.HomeScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        startDestination = "home_screen",
        navController = navController
    ) {
        composable("home_screen") {
            HomeScreen()
        }
    }
}