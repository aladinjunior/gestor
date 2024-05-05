package com.aladinjunior.gestor.signin.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aladinjunior.gestor.ui.theme.GestorTheme
import com.aladinjunior.gestor.util.LoginButton

private val headlineSpace = 8.dp
private val textFieldSpace = 10.dp
private val textFieldPadding = 12.dp
private val containerComponentsPadding = 18.dp
private val cardSize = 390.dp


@Composable
fun LoginFieldContainer(
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.size(cardSize)) {
        Column(
            modifier = Modifier
                .padding(containerComponentsPadding)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(headlineSpace))
            LoginTextField(
                fieldLabelText = "Usuário",
                modifier = Modifier.padding(textFieldPadding)
            )
            Spacer(modifier = Modifier.size(textFieldSpace))
            LoginTextField(
                fieldLabelText = "Senha", isPasswordField = true, modifier = Modifier.padding(
                    textFieldPadding
                )
            )
            Spacer(modifier = Modifier.weight(1f))


            LoginButton(buttonText = "Login")

        }
    }

}

@Preview
@Composable
private fun LoginFieldContainerPreview() {
    GestorTheme {
        LoginFieldContainer()
    }
}