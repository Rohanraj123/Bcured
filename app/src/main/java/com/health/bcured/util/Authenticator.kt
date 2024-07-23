package com.health.bcured.util

import android.util.Log
import com.health.bcured.viewmodel.AuthViewModel
import kotlinx.coroutines.flow.collectLatest

object Authenticator {

    suspend fun onRegisterButtonClicked(
        authViewModel: AuthViewModel,
        emailText: String,
        passwordText: String,
        onSuccess: () -> Unit
    ) {
        authViewModel.register(emailText, passwordText)
        authViewModel.registerState.collectLatest { result ->
            if (result is Resource.Success) {
                onSuccess()
            }
        }
    }

    fun onLoginButtonClicked(
        authViewModel: AuthViewModel,
        emailText: String,
        passwordText: String
    ) {
        authViewModel.login(emailText, passwordText)
    }
}