package com.aladinjunior.gestor.feature.signin.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aladinjunior.gestor.feature.signin.components.SignInContainer
import com.aladinjunior.gestor.ui.theme.GestorTheme


private val containerTopSpace = 160.dp
private val containerPadding = 20.dp

@Composable
fun SignInScreen(
    onSignInSubmit: (user: String, password: String) -> Unit
) {


    Column {
        Spacer(modifier = Modifier.size(containerTopSpace))
        Text(modifier = Modifier.padding(horizontal = containerPadding), text = "Sign In", style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.ExtraBold))
        SignInContainer(
            modifier = Modifier.padding(horizontal = containerPadding),
            onSignInSubmit = onSignInSubmit
        )

    }

}

@Preview(showBackground = true)
@Composable
private fun SignInScreenPreview() {
    GestorTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            SignInScreen{ _, _ ->}
        }
    }
}