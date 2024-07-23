package com.health.bcured.views.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.health.bcured.viewmodel.AuthViewModel
import com.health.bcured.views.HomeScreen
import com.health.bcured.views.LoginScreen
import com.health.bcured.views.SignUpScreen

@Composable
fun Navigation(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Login.name
    ) {
        composable(route = Routes.Login.name) { LoginScreen(navController, authViewModel) }
        composable(route = Routes.Register.name) { SignUpScreen(navController, authViewModel) }
        composable(route = Routes.Home.name) { HomeScreen() }
    }
}