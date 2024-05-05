package com.aladinjunior.gestor.signin.presentation

import androidx.compose.runtime.Composable

@Composable
fun SignInRoute() {
    SignInScreen(
        onSignInSubmit = { user, password ->
            println("$user and $password")
        }
    )
}