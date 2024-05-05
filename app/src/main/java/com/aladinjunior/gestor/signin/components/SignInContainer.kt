package com.aladinjunior.gestor.signin.components

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType.Companion.Email
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aladinjunior.gestor.signin.PasswordState
import com.aladinjunior.gestor.signin.UserState
import com.aladinjunior.gestor.signin.UserStateSaver
import com.aladinjunior.gestor.ui.theme.GestorTheme
import com.aladinjunior.gestor.util.GenericButton

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
    Card(modifier = modifier.size(cardSize)) {
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
                fieldLabelText = "Usuário",
                modifier = Modifier.padding(textFieldPadding),
                state = userState
            )
            Spacer(modifier = Modifier.size(textFieldSpace))
            SignInTextField(
                fieldLabelText = "Senha", isPasswordField = true, modifier = Modifier.padding(
                    textFieldPadding
                ),
                state = passwordState
            )
            Spacer(modifier = Modifier.weight(1f))


            val onSubmit = {
                if (userState.isValid && passwordState.isValid) {
                    onSignInSubmit(userState.text, passwordState.text)
                }
            }


            GenericButton(buttonText = "Login", onClick = { onSubmit() })


        }
    }

}

@Preview
@Composable
private fun LoginFieldContainerPreview() {
    GestorTheme {
        SignInContainer(onSignInSubmit = { x, y ->

        })
    }
}