package com.health.bcured.views


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.health.bcured.R
import com.health.bcured.util.Authenticator.onLoginButtonClicked
import com.health.bcured.util.Resource
import com.health.bcured.viewmodel.AuthViewModel
import com.health.bcured.views.navigation.Routes
import com.health.bcured.views.components.BackButton
import com.health.bcured.views.components.BlueButton
import com.health.bcured.views.components.CustomTextButton
import com.health.bcured.views.components.CustomTextField
import com.health.bcured.views.components.OAuthContainer
import com.health.bcured.views.components.RememberAndForgetPassword
import com.health.bcured.views.extras.emailLabel
import com.health.bcured.views.extras.passwordLabel

/**
 * Composable for login screen.
 * contains UI elements
 * contains State elements
 * contains business login little bit
 */
@Composable
fun LoginScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {

    val loginState by authViewModel.loginState.collectAsState()

    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }

    val context = LocalContext.current

    when (loginState) {
        is Resource.Loading -> {}
        is Resource.Success -> { navController.navigate(Routes.Home.name) }
        else -> { Toast.makeText(context, "Fill correct credentials !!", Toast.LENGTH_LONG).show() }
    }

    // background surface
    Surface (
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            // back button
            Row (
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                BackButton( onClick = { /*TODO*/ } )
                Spacer(modifier = Modifier.width(20.dp))
                LoginText()
            }

            Column {

                // login options text
                Text(
                    text = "Log in with one of the following",
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                    fontWeight = FontWeight.SemiBold
                )

                // Google and Apple containers
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OAuthContainer(
                        image = painterResource(id = R.drawable.googlelogo),
                        title = "With Google",
                        onClick = {

                        }
                    )
                    OAuthContainer(
                        image = painterResource(id = R.drawable.applelogo),
                        title = "With Apple",
                        onClick = {

                        }
                    )
                }
            }

            // Email TextField
            Column {
                // text fields
                Text(
                    text = emailLabel,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 5.dp)
                )

                CustomTextField(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                    value = emailText,
                    onValueChange = { newText -> emailText = newText }
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = passwordLabel,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 5.dp)
                )

                CustomTextField(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                    value = passwordText,
                    onValueChange = { newText -> passwordText = newText }
                )

                // Remember me and forgot password
                RememberAndForgetPassword( isChecked = true, onCheckChange = {} )
            }

            // login button
            BlueButton( title = "Log In", onClick = { onLoginButtonClicked(authViewModel, emailText, passwordText) } )

            // first time sign up here
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "First time here?")
                CustomTextButton( onClick = { navController.navigate(Routes.Register.name) }, title = "Sign up for free" )
            }
        }
    }
}


@Composable
fun LoginText() {
    Text(text = "Log in", fontSize = 30.sp, fontWeight = FontWeight.SemiBold)
}

