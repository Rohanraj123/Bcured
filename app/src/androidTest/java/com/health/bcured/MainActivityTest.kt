package com.health.bcured

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.health.bcured.data.repositories.AuthRepository
import com.health.bcured.data.repositoryimpl.AuthRepositoryImpl
import com.health.bcured.di.AuthModule
import com.health.bcured.viewmodel.AuthViewModel
import com.health.bcured.views.authscreens.LoginScreen
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import dagger.hilt.components.SingletonComponent
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Singleton

@UninstallModules(AuthModule::class)
@HiltAndroidTest
class MainActivityTest {
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeRule = createComposeRule()

    @Inject
    lateinit var firebaseAuth: FirebaseAuth

    @Inject
    lateinit var authRepository: AuthRepository

    private lateinit var authViewModel: AuthViewModel

    @Before
    fun setup() {
        hiltRule.inject()
        authViewModel = AuthViewModel(authRepository, firebaseAuth)
    }

    @Test
    fun test() {
        composeRule.setContent {
            val navController = rememberNavController()
            LoginScreen(navController = navController, authViewModel = authViewModel)
        }
    }
}