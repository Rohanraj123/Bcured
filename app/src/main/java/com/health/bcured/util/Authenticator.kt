package com.health.bcured.util

import android.util.Log
import com.health.bcured.viewmodel.AuthViewModel
import kotlinx.coroutines.flow.collectLatest

object Authenticator {

    suspend fun onRegisterButtonClicked(
        authViewModel: AuthViewModel,
        emailText: String,
        passwordText: String,
    ) {
        authViewModel.register(emailText, passwordText)
    }

    fun onLoginButtonClicked(
        authViewModel: AuthViewModel,
        emailText: String,
        passwordText: String
    ) {
        authViewModel.login(emailText, passwordText)
    }
}