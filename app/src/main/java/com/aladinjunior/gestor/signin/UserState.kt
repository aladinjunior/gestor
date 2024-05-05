package com.aladinjunior.gestor.signin

import android.util.Log
import com.aladinjunior.gestor.util.TextFieldState
import com.aladinjunior.gestor.util.textFieldStateSaver

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







