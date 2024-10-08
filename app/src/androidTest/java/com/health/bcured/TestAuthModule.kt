package com.health.bcured

import com.google.firebase.auth.FirebaseAuth
import com.health.bcured.data.repositories.AuthRepository
import com.health.bcured.data.repositoryimpl.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TestAuthModule {

    /** Provides FirebaseAuth instance for authentication purposes.*/
    @Provides
    @Singleton
    fun providesFirebaseInstance() = FirebaseAuth.getInstance()

    /** Provides AuthRepository instance authentication services.*/
    @Provides
    @Singleton
    fun providesAuthRepository(firebaseAuth: FirebaseAuth) : AuthRepository {
        return AuthRepositoryImpl(firebaseAuth = firebaseAuth)
    }
}