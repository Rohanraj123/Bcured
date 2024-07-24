package com.health.bcured.data.repositories

import com.google.firebase.auth.AuthResult
import com.health.bcured.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Repository to provide authentication services
 */
interface AuthRepository {

    /**
     * Method to login the user
     *
     * @param email Email of the user
     * @param password Password of the user
     * @return AuthResult Response in form of state with data
     */
    fun login(email: String, password: String) : Flow<Resource<AuthResult>>

    /**
     * Method to register the user
     *
     * @param email Email of the user
     * @param password Password of the user
     * @return AuthResult Response in form of state with data
     */
    fun register(email: String, password: String) : Flow<Resource<AuthResult>>

    /**
     * Method to logout the user
     */
    suspend fun logOut()
}
