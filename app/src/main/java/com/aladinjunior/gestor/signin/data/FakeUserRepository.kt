package com.aladinjunior.gestor.signin.data
import android.util.Log
import com.aladinjunior.gestor.signin.data.local.FakeLocalDataSource
import com.aladinjunior.gestor.signin.model.UserAccount

sealed class UserState {
    data class LoggedInUser(val loggedInUserId: Int) : UserState()
    data object NoUserLoggedIn : UserState()
}

class FakeUserRepository(
    private val fakeLocalDataSource: FakeLocalDataSource
) {

    private var _user: UserState = UserState.NoUserLoggedIn
    val user: UserState get() = _user

    fun signIn(userAccountSubmitted: UserAccount) {

        if (fakeLocalDataSource.existentUserAccounts.contains(userAccountSubmitted)) {

            val loggedInUser = fakeLocalDataSource.accounts[userAccountSubmitted.hashCode()]!!
            _user = UserState.LoggedInUser(loggedInUser.id)
        }


    }



}