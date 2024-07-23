package com.health.bcured.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.autoSaver
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.health.bcured.viewmodel.AuthViewModel
import com.health.bcured.views.navigation.Routes

@Composable
fun HomeScreen(
    authViewModel: AuthViewModel,
    navHostController: NavHostController
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(
            onClick = {
                authViewModel.logOut()
                navHostController.navigate(Routes.Login.name) {
                    popUpTo(Routes.Home.name) { inclusive = true }
                }
        }
        ) {
            Text(text = "Log Out")
        }
    }
}