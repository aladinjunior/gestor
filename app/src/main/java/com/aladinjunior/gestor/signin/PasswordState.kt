package com.aladinjunior.gestor.signin

import com.aladinjunior.gestor.util.TextFieldState
import com.aladinjunior.gestor.util.textFieldStateSaver

class PasswordState (password: String? = null) : TextFieldState(
    validator = ::isPassowordValid
) {

    init {
        password?.let {
            text = it
        }
    }

}

val PasswordStateSaver = textFieldStateSaver(PasswordState())

private fun isPassowordValid(password: String) : Boolean {
    return password.isNotEmpty() && password.length > 3
}