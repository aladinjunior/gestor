package com.aladinjunior.gestor.feature.signin.data.repository

import com.aladinjunior.gestor.feature.signin.model.UserAccount

interface UserRepository {

    val user: UserState

    fun signIn(userAccountSubmitted: UserAccount)

}

sealed class UserState {
    data class LoggedInUser(val loggedInUserId: Int) : UserState()
    data object NoUserLoggedIn : UserState()
}