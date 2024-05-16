package com.aladinjunior.gestor.signin.data.local

import com.aladinjunior.gestor.R
import com.aladinjunior.gestor.commom.User
import com.aladinjunior.gestor.signin.model.UserAccount

object FakeLocalDataSource {


    //user builder
    fun user(block: User.Builder.() -> Unit): User = User.Builder().apply(block).build()


    private const val USER_A_USERNAME = "aladin"
    private const val USER_A_PASSWORD = "outubro13"
    private val userAccountA = UserAccount(USER_A_USERNAME, USER_A_PASSWORD)

    private const val USER_B_USERNAME = "jurandi"
    private const val USER_B_PASSWORD = "240195"
    private val userAccountB = UserAccount(USER_B_USERNAME, USER_B_PASSWORD)

    private const val USER_C_USERNAME = "user"
    private const val USER_C_PASSWORD = "12345"
    private val userAccountC = UserAccount(USER_C_USERNAME, USER_C_PASSWORD)


    val existentUserAccounts = listOf(userAccountA, userAccountB, userAccountC)


    val accounts: HashMap<Int, User> = hashMapOf(
        userAccountA.hashCode() to user {
            id = userAccountA.hashCode()
            name = "ALADIN"
            address = "Vitória de Santo Antão"
            company = "BENTO ENTERPRISE"
            image = R.drawable.ic_launcher_background
        },

        userAccountB.hashCode() to user {
            id = userAccountB.hashCode()
            name = "JURANDI"
            address = "Petrolina"
            company = "SOFTUNI"
            image = R.drawable.ic_launcher_foreground

        } ,

        userAccountC.hashCode() to user {
            id = userAccountC.hashCode()
            name = "USER"
            address = "Location"
            company = "ENTERPRISE"
            image = R.drawable.ic_launcher_foreground

        }
    )



}