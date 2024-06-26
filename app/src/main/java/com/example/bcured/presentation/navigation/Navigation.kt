package com.example.bcured.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        startDestination = "home_screen",
        navController = navController
    ) {

    }
}