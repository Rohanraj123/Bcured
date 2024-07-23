package com.health.bcured.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthResult
import com.health.bcured.data.repositories.AuthRepository
import com.health.bcured.util.Resource
import com.health.bcured.util.Resource.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _loginState = MutableStateFlow<Resource<AuthResult>>(Loading())
    val loginState: StateFlow<Resource<AuthResult>> = _loginState

    private val _registerState = MutableStateFlow<Resource<AuthResult>>(Loading())
    val registerState: StateFlow<Resource<AuthResult>> = _registerState

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
}
