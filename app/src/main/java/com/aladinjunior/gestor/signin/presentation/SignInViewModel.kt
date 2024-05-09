package com.aladinjunior.gestor.signin.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aladinjunior.gestor.signin.data.repository.FakeUserRepository
import com.aladinjunior.gestor.signin.data.local.FakeLocalDataSource
import com.aladinjunior.gestor.signin.data.repository.UserRepository
import com.aladinjunior.gestor.signin.data.repository.UserState
import com.aladinjunior.gestor.signin.model.UserAccount

class SignInViewModel(
    private val userRepository: UserRepository
) : ViewModel() {


    fun signIn(
        userAccountSubmitted: UserAccount,
        onSignInComplete: (loggedInUserId: Int) -> Unit,
        onSignInFailure: () -> Unit,
    ) {
        userRepository.signIn(userAccountSubmitted)

        when (val userState = userRepository.user) {
            is UserState.LoggedInUser -> onSignInComplete(userState.loggedInUserId)
            is UserState.NoUserLoggedIn -> onSignInFailure()
        }

    }

    class SignInViewModelFactory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SignInViewModel::class.java)) {
                return SignInViewModel(FakeUserRepository(FakeLocalDataSource)) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }


}