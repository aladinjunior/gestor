package com.aladinjunior.gestor.signin.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aladinjunior.gestor.signin.data.UserRepository
import com.aladinjunior.gestor.signin.data.UserState
import com.aladinjunior.gestor.signin.data.local.FakeLocalDataSource
import com.aladinjunior.gestor.signin.model.User

class SignInViewModel(
    private val userRepository: UserRepository
) : ViewModel() {


    fun signIn(
        userSubmitted: User,
        onSignInComplete: () -> Unit,
        onSignInFailure: () -> Unit,
    ) {
        userRepository.signIn(userSubmitted)

        when (userRepository.user) {
            is UserState.LoggedInUser -> onSignInComplete()
            is UserState.NoUserLoggedIn -> onSignInFailure()
        }

    }

    class SignInViewModelFactory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SignInViewModel::class.java)) {
                return SignInViewModel(UserRepository(FakeLocalDataSource)) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }


}