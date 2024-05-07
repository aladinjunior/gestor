package com.aladinjunior.gestor.signin.presentation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aladinjunior.gestor.signin.model.User

@Composable
fun SignInRoute(
    onSignInComplete: () -> Unit,
    onSignInFailure: () -> Unit,
) {

    val signInViewModel: SignInViewModel = viewModel(factory = SignInViewModel.SignInViewModelFactory())
    SignInScreen(
        onSignInSubmit = { user, password ->
            signInViewModel.signIn(
                User(user, password),
                onSignInComplete,
                onSignInFailure
            )

        }
    )

}