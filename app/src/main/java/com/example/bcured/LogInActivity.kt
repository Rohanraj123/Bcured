package com.example.bcured

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.res.ResourcesCompat
import com.example.bcured.ui.theme.BcuredTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BcuredTheme {
                // Call the LoginScreen composable to display the login UI
                LoginScreen()
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val view = LocalView.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Email Section
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = stringResource(id = R.string.email_hint)) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = stringResource(id = R.string.password_hint)) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Password Section
        PasswordSection(
            password = password,
            onPasswordChange = { password = it },
            onImeAction = {
                // Handle keyboard "Done" button click here
                keyboardController?.hide()
            }
        )

        // Login Button
        Button(
            onClick = {
                // Implement your login logic here
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.login_button))
        }

        // Sign Up Text
        Text(
            text = stringResource(id = R.string.sign_up_text),
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Forgot Password Text
        Text(
            text = stringResource(id = R.string.forgot_password_text),
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Google Authentication Button
        GoogleAuthButton(
            onClick = {
                // Handle Google authentication here
            }
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PasswordSection(
    password: String,
    onPasswordChange: (String) -> Unit,
    onImeAction: () -> Unit
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BasicTextField(
            value = password,
            onValueChange = { onPasswordChange(it) },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    onImeAction()
                }
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textStyle = LocalTextStyle.current.copy(
                color = Color.Black,
                fontFamily = FontFamily.Default
            )
        )

        IconButton(
            onClick = { isPasswordVisible = !isPasswordVisible },
            modifier = Modifier
                .size(48.dp)
                .padding(bottom = 16.dp)
        ) {
            Icon(
                imageVector = if (isPasswordVisible) {
                    Icons.Filled.Clear
                } else Icons.Filled.Create,
                contentDescription = null
            )
        }
    }
}
@Composable
fun GoogleAuthButton(onClick: () -> Unit) {
    val density = LocalDensity.current.density
    val buttonHeight = 48.dp
    val buttonPadding = 16.dp
    val topCornerRadius = 8.dp
    val bottomCornerRadius = 0.dp // Adjust this value as needed

    // Define a custom shape
    val buttonShape = RoundedCornerShape(
        topStart = topCornerRadius,
        topEnd = topCornerRadius,
        bottomStart = bottomCornerRadius,
        bottomEnd = bottomCornerRadius
    )

    val buttonModifier = Modifier
        .fillMaxWidth()
        .height(buttonHeight)
        .padding(buttonPadding)

    Button(
        onClick = onClick,
        modifier = buttonModifier.then(Modifier.background(MaterialTheme.colorScheme.primary)),
        shape = buttonShape,
        contentPadding = PaddingValues(
            start = (48 * density).dp,
            end = (16 * density).dp
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Google Icon
            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 8.dp)
            )

            // Text
            Text(
                text = stringResource(id = R.string.google_auth_button),
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    BcuredTheme {
        LoginScreen()
    }
}