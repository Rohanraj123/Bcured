package com.health.bcured.data.repositories

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.health.bcured.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun login(email: String, password: String) : Flow<Resource<AuthResult>>
    fun register(email: String, password: String) : Flow<Resource<AuthResult>>
    fun getCurrentUser() : FirebaseUser?
}