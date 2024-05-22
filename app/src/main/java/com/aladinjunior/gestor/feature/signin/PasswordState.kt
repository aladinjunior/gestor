package com.aladinjunior.gestor.feature.signin

import com.aladinjunior.gestor.commom.components.TextFieldState
import com.aladinjunior.gestor.commom.components.textFieldStateSaver

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