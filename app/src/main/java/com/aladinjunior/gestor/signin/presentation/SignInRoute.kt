package com.aladinjunior.gestor.signin.presentation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aladinjunior.gestor.commom.User
import com.aladinjunior.gestor.signin.model.UserAccount

@Composable
fun SignInRoute(
    onSignInComplete: (loggedInUserId: Int) -> Unit,
    onSignInFailure: () -> Unit,
) {

    val signInViewModel: SignInViewModel = viewModel(factory = SignInViewModel.SignInViewModelFactory())
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