package com.aladinjunior.gestor.feature.signin.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aladinjunior.gestor.commom.components.GenericButton
import com.aladinjunior.gestor.feature.signin.PasswordState
import com.aladinjunior.gestor.feature.signin.UserState
import com.aladinjunior.gestor.feature.signin.UserStateSaver
import com.aladinjunior.gestor.ui.theme.GestorTheme

private val headlineSpace = 8.dp
private val textFieldSpace = 10.dp
private val textFieldPadding = 12.dp
private val containerComponentsPadding = 18.dp
private val cardSize = 390.dp


@Composable
fun SignInContainer(
    modifier: Modifier = Modifier,
    onSignInSubmit: (user: String, password: String) -> Unit
) {

    Column(
        modifier = Modifier
            .padding(containerComponentsPadding)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val userState by rememberSaveable(stateSaver = UserStateSaver) {
            mutableStateOf(
                UserState()
            )
        }

        val passwordState by remember { mutableStateOf(PasswordState()) }

        Spacer(modifier = Modifier.size(headlineSpace))
        SignInTextField(
            fieldLabelText = "Username",
            modifier = Modifier.padding(textFieldPadding),
            state = userState
        )
        Spacer(modifier = Modifier.size(textFieldSpace))
        SignInTextField(
            fieldLabelText = "Password", isPasswordField = true, modifier = Modifier.padding(
                textFieldPadding
            ),
            state = passwordState
        )
        Spacer(modifier = Modifier.size(30.dp))


        val onSubmit = {
            if (userState.isValid && passwordState.isValid) {
                onSignInSubmit(userState.text, passwordState.text)
            }
        }


        GenericButton(buttonText = "Login", onClick = { onSubmit() })


    }


}

@Preview
@Composable
private fun LoginFieldContainerPreview() {
    GestorTheme {
        SignInContainer(onSignInSubmit = { _, _ ->

        })
    }
}