package com.health.bcured.data.repositoryimpl

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.health.bcured.data.repositories.AuthRepository
import com.health.bcured.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

/**
 * AuthRepository implementation to implement services
 */
class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {

    /**
     * Method to login the user
     *
     * @param email Email of the user
     * @param password Password of the user
     * @return AuthResult Response in form of state with data
     */
    override fun login(email: String, password: String): Flow<Resource<AuthResult>> {
        return flow {
            emit(value = Resource.Loading())
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            emit(value = Resource.Success(data = result))
        }.catch {
            emit(value = Resource.Error(it.message.toString()))
        }
    }

    /**
     * Method to register the user
     *
     * @param email Email of the user
     * @param password Password of the user
     * @return AuthResult Response in form of state with data
     */
    override fun register(email: String, password: String): Flow<Resource<AuthResult>> {
        return flow {
            emit(value = Resource.Loading())
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            emit(value = Resource.Success(data = result))
        }.catch {
            emit(value = Resource.Error(it.message.toString()))
        }
    }

    /**
     * Method to logout the user
     */
    override suspend fun logOut() = firebaseAuth.signOut()
}
