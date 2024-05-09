package com.aladinjunior.gestor.signin.data.repository

import com.aladinjunior.gestor.signin.model.UserAccount

interface UserRepository {

    val user: UserState

    fun signIn(userAccountSubmitted: UserAccount)

}

sealed class UserState {
    data class LoggedInUser(val loggedInUserId: Int) : UserState()
    data object NoUserLoggedIn : UserState()
}