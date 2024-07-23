package com.health.bcured.views.extras

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

val emailLabel = buildAnnotatedString {
    withStyle(style = SpanStyle(color = Color.Black)) {
        append("Email")
        append("*")
    }
}
val passwordLabel = buildAnnotatedString {
    withStyle(style = SpanStyle(color = Color.Black)) {
        append("Password")
        append("*")
    }
}
val confirmPasswordLabel = buildAnnotatedString {
    withStyle(style = SpanStyle(color = Color.Black)) {
        append("Confirm Password")
        append("*")
    }
}
val nameLabel = buildAnnotatedString {
    withStyle(style = SpanStyle(color = Color.Black)) {
        append("Name")
        append("*")
    }
}