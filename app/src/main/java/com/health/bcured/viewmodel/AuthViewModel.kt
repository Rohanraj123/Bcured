package com.health.bcured.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.health.bcured.data.repositories.AuthRepository
import com.health.bcured.util.Resource
import com.health.bcured.util.Resource.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/** Hilt ViewModel for Authenticator related work.*/
@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    firebaseAuth: FirebaseAuth
) : ViewModel() {

    /** State management for login status.*/
    private val _loginState = MutableStateFlow<Resource<AuthResult>>(Loading())
    val loginState: StateFlow<Resource<AuthResult>> = _loginState

    /** State management for register status.*/
    private val _registerState = MutableStateFlow<Resource<AuthResult>>(Loading())
    val registerState: StateFlow<Resource<AuthResult>> = _registerState

    /** State management for logout status.*/
    private val _currentUser = MutableStateFlow<FirebaseUser?>(null)
    val currentUser: StateFlow<FirebaseUser?> = _currentUser

    /** Method to login the user.*/
    fun login(email: String, password: String) = viewModelScope.launch {
        _loginState.value = Loading()
        authRepository.login(email, password).collectLatest { result ->
            when (result) {
                is Loading -> {
                    _loginState.value = Loading()
                }
                is Success -> {
                    _loginState.value = Success(data = result.data)
                }
                is Error -> {
                    _loginState.value = Error(message = result.message ?: "Unknown Error")
                }
            }
        }
    }

    /** Method to register the user.*/
    fun register(email: String, password: String) = viewModelScope.launch {
        _registerState.value = Loading()
        authRepository.register(email, password).collectLatest { result ->
            when (result) {
                is Loading -> {
                    _registerState.value = Loading()
                }
                is Success -> {
                    _registerState.value = Success(data = result.data)
                }
                is Error -> {
                    _registerState.value = Error(message = result.message ?: "Unknown Error")
                }
            }
        }
    }

    /** Pre initialisation of current user for status update.*/
    init { _currentUser.value = firebaseAuth.currentUser }

    /** Method to logout the user.*/
    fun logOut() {
        viewModelScope.launch {
            try {
                authRepository.logOut()
                _currentUser.value = null
            } catch (e: Exception) {
                throw e
            }
        }
    }
}
