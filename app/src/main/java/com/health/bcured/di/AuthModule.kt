package com.health.bcured.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthProvider
import com.google.firebase.ktx.Firebase
import com.health.bcured.data.repositories.AuthRepository
import com.health.bcured.data.repositoryimpl.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AuthModule {

    @Provides
    @Singleton
    fun providesFirebaseInstance() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun providesAuthRepository(firebaseAuth: FirebaseAuth) : AuthRepository {
        return AuthRepositoryImpl(firebaseAuth = firebaseAuth)
    }
}