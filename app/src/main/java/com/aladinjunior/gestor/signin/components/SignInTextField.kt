package com.aladinjunior.gestor.signin.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.aladinjunior.gestor.signin.PasswordState
import com.aladinjunior.gestor.signin.UserState
import com.aladinjunior.gestor.ui.theme.GestorTheme
import com.aladinjunior.gestor.util.TextFieldState

@Composable
fun SignInTextField(
    modifier: Modifier = Modifier,
    fieldLabelText: String,
    isPasswordField: Boolean = false,
    state: TextFieldState = if (!isPasswordField) remember {UserState()} else remember {PasswordState()}


) {

    var currentFieldValue by remember { mutableStateOf("") }


    Column(modifier) {
        Text(
            text = fieldLabelText, style = MaterialTheme.typography.labelLarge.copy(

                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.text,
            onValueChange = {
                state.text = it
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Gray,
                focusedIndicatorColor = Color.Gray,
                cursorColor = Color.Black
            ),
            visualTransformation = if (!isPasswordField) VisualTransformation.None else PasswordVisualTransformation()
        )


    }
}

@Preview(showBackground = true, heightDp = 200, widthDp = 320)
@Composable
private fun LoginTextFieldPreview() {
    GestorTheme {
        SignInTextField(fieldLabelText = "Usuário", isPasswordField = true)
    }
}