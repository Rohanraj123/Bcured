package com.example.bcured.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bcured.presentation.screens.login_screen.LoginScreen
import com.example.bcured.presentation.screens.otp_screen.OTPBox
import com.example.bcured.presentation.screens.otp_screen.OTPScreen
import com.example.bcured.presentation.screens.welcome_screen.WelcomeScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        startDestination = "otp_screen",
        navController = navController
    ) {
        composable("login_screen") { LoginScreen(navController) }
        composable("welcome_screen") { WelcomeScreen(navController) }
        composable("otp_screen") { OTPScreen(navController) }
    }
}