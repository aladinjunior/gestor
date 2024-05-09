package com.aladinjunior.gestor.signin.data.repository

import android.util.Log
import com.aladinjunior.gestor.signin.data.local.FakeLocalDataSource
import com.aladinjunior.gestor.signin.data.repository.UserRepository
import com.aladinjunior.gestor.signin.data.repository.UserState
import com.aladinjunior.gestor.signin.model.UserAccount


class FakeUserRepository(
    private val fakeLocalDataSource: FakeLocalDataSource
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