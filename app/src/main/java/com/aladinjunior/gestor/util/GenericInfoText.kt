package com.aladinjunior.gestor.util

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.aladinjunior.gestor.ui.theme.GestorTheme

@Composable
fun GenericInfoText(
    modifier : Modifier = Modifier,
    text: String,
    textSize: TextUnit,
    fontWeight: FontWeight = FontWeight.Normal,
    textColor: Color = Color.Black
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.titleLarge.
        copy(fontSize = textSize, fontWeight = fontWeight, color = textColor)
    )
}

@Preview
@Composable
private fun GenericTextPreview() {
    GestorTheme {
        Box(modifier = Modifier.fillMaxSize())
        GenericInfoText(text = "Hello, world", textSize = 30.sp)
    }
}