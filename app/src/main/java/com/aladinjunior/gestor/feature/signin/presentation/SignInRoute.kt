package com.aladinjunior.gestor.feature.signin.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.aladinjunior.gestor.feature.signin.model.UserAccount

@Composable
fun SignInRoute(
    onSignInComplete: (loggedInUserId: Int) -> Unit,
    onSignInFailure: () -> Unit,
) {

    val signInViewModel: SignInViewModel = hiltViewModel()
    SignInScreen(
        onSignInSubmit = { user, password ->
            signInViewModel.signIn(
                UserAccount(user, password),
                onSignInComplete,
                onSignInFailure
            )

        }
    )

}