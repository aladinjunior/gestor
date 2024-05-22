package com.aladinjunior.gestor.feature.signin

import com.aladinjunior.gestor.commom.components.TextFieldState
import com.aladinjunior.gestor.commom.components.textFieldStateSaver

class UserState(
    user: String? = null
) : TextFieldState(validator = ::isUserValid){

    init {
        user?.let {
            text = it
        }
    }

}

private fun isUserValid(user: String) : Boolean {
    return user.isNotEmpty()
}


val UserStateSaver = textFieldStateSaver(UserState())







