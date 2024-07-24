package com.health.bcured.util

import com.health.bcured.viewmodel.AuthViewModel

/**
 * Authenticator object to provide onClickListener methods
 */
object Authenticator {

    /** On RegisterButtonClickListener.*/
    fun onRegisterButtonClicked(
        authViewModel: AuthViewModel,
        emailText: String,
        passwordText: String,
    ) {
        authViewModel.register(emailText, passwordText)
    }

    /** On LoginButtonClickListener.*/
    fun onLoginButtonClicked(
        authViewModel: AuthViewModel,
        emailText: String,
        passwordText: String
    ) {
        authViewModel.login(emailText, passwordText)
    }
}
