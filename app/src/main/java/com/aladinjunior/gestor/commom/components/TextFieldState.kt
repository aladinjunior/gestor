package com.aladinjunior.gestor.commom.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.setValue

open class TextFieldState(
    private val validator: (String) -> Boolean = { true },
    private val errorFor: (String) -> String = { "" }
) {

    var text by mutableStateOf("")


    open val isValid: Boolean
        get() = validator(text)


}

fun textFieldStateSaver(
    state: TextFieldState
) = listSaver<TextFieldState, Any>(
    save = { listOf(it.text) },
    restore = {
        state.apply {
            text = it[0] as String
        }
    }
)