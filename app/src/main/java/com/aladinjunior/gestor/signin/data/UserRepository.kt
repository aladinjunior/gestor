package com.aladinjunior.gestor.signin.data
import com.aladinjunior.gestor.signin.data.local.FakeLocalDataSource
import com.aladinjunior.gestor.signin.model.User

sealed class UserState {
    data object LoggedInUser : UserState()
    data object NoUserLoggedIn : UserState()
}

class UserRepository(
    private val fakeLocalDataSource: FakeLocalDataSource
) {

    private var _user: UserState = UserState.NoUserLoggedIn
    val user: UserState get() = _user

    fun signIn(userSubmitted: User) {

        if (fakeLocalDataSource.existentUsers.contains(userSubmitted)) {
            _user = UserState.LoggedInUser
        }



    }



}