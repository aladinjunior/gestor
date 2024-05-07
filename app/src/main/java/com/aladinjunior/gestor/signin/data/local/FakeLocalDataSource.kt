package com.aladinjunior.gestor.signin.data.local

import com.aladinjunior.gestor.signin.model.User

object FakeLocalDataSource {

    private const val userAUsername = "userA"
    private const val userAPassword = "userAPassword"
    private val userA = User(userAUsername, userAPassword)

    private const val userBUsername = "userB"
    private const val userBPassword = "userBPassword"
    private val userB = User(userBUsername, userBPassword)

    val existentUsers = listOf(userA, userB)

}