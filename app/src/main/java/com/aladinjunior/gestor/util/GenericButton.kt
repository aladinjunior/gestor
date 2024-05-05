package com.aladinjunior.gestor.util

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.aladinjunior.gestor.ui.theme.GestorTheme

@Composable
fun GenericButton(
    buttonText: String,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth(

        ),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
      Text(
          text = buttonText,
          style = MaterialTheme.typography.titleLarge.copy(
              fontWeight = FontWeight.SemiBold
          )
      )
    }
}

@Preview
@Composable
private fun LoginButtonPreview() {
    GestorTheme {
        GenericButton("Login", onClick = {})
    }
}