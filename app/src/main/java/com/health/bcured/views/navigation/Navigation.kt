package com.health.bcured.views.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.health.bcured.viewmodel.AuthViewModel
import com.health.bcured.views.HomeScreen
import com.health.bcured.views.LoginScreen
import com.health.bcured.views.SignUpScreen

/**
 * Navigation graph setup.
 */
@Composable
fun Navigation(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {

    val currentUser by authViewModel.currentUser.collectAsState()

    val initialRoute = if (currentUser != null) Routes.Home.name else Routes.Login.name

    NavHost(
        navController = navController,
        startDestination = initialRoute
    ) {
        composable(route = Routes.Login.name) { LoginScreen(navController, authViewModel) }
        composable(route = Routes.Register.name) { SignUpScreen(navController, authViewModel) }
        composable(route = Routes.Home.name) { HomeScreen(authViewModel, navController) }
    }
}