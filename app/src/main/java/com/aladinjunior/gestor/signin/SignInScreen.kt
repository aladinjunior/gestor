package com.aladinjunior.gestor.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aladinjunior.gestor.R
import com.aladinjunior.gestor.signin.components.LoginFieldContainer
import com.aladinjunior.gestor.signin.components.TopRoundedBackground
import com.aladinjunior.gestor.ui.theme.GestorTheme


@Composable
fun LoginScreen() {


    TopRoundedBackground(height = 300)
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 60.dp),
        horizontalArrangement = Arrangement.Center) {
        Text(text = stringResource(id = R.string.type_your_credentials),
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                color = MaterialTheme.colorScheme.onPrimary
                ))
    }
    Column {
        Spacer(modifier = Modifier.size(160.dp))
        LoginFieldContainer(
            modifier = Modifier.padding(horizontal = 20.dp)
        )

    }


}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    GestorTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            LoginScreen()
        }
    }
}