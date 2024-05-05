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
import com.aladinjunior.gestor.ui.theme.GestorTheme

@Composable
fun LoginTextField(
    modifier: Modifier = Modifier,
    fieldLabelText: String,
    isPasswordField: Boolean = false
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
            value = currentFieldValue, onValueChange = {
                currentFieldValue = it
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
        LoginTextField(fieldLabelText = "Usuário", isPasswordField = true)
    }
}