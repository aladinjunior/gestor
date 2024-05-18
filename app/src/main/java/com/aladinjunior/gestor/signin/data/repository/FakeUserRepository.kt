package com.aladinjunior.gestor.signin.data.repository

import com.aladinjunior.gestor.signin.data.local.SignInFakeLocalDataSource
import com.aladinjunior.gestor.signin.model.UserAccount
import javax.inject.Inject


class FakeUserRepository @Inject constructor (
    private val fakeLocalDataSource: SignInFakeLocalDataSource
) : UserRepository {


    private var _user: UserState = UserState.NoUserLoggedIn
    override val user: UserState get() = _user

    override fun signIn(userAccountSubmitted: UserAccount) {

        if (fakeLocalDataSource.existentUserAccounts.contains(userAccountSubmitted)) {

            val loggedInUser = fakeLocalDataSource.accounts[userAccountSubmitted.hashCode()]!!
            _user = UserState.LoggedInUser(loggedInUser.id)
        }


    }


}