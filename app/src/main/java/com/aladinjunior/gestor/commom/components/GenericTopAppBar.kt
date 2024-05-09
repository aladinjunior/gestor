package com.aladinjunior.gestor.commom.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aladinjunior.gestor.ui.theme.GestorTheme
import com.aladinjunior.gestor.util.GenericInfoText

private val currentScreenTitleStartPadding = 50.dp
private val topBarTextSize = 16.sp

@Composable
fun GenericTopAppBar(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    backText: String = "Voltar",
    currentScreenTitle: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {


        GoBackExtentedButton(color = MaterialTheme.colorScheme.secondary, text = backText, textSize = topBarTextSize)
        Spacer(modifier = Modifier.weight(1f))
        GenericInfoText(text = currentScreenTitle, textSize = topBarTextSize, textColor = MaterialTheme.colorScheme.primary,)
        Spacer(modifier = Modifier.weight(1.8f))

    }
}

@Composable
fun GoBackExtentedButton(color: Color, text: String, textSize: TextUnit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "goBack", tint = color)
        GenericInfoText(text = text, textSize = textSize, textColor = color)

    }
    
}

@Preview
@Composable
private fun GenericTopAppBarPreview() {
    GestorTheme {
        GenericTopAppBar(onBackPressed = {}, currentScreenTitle = "Pessoas")
    }
}
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun GenericTopAppBarPreviewDark() {
    GestorTheme {
        GenericTopAppBar(onBackPressed = {}, currentScreenTitle = "Pessoas")
    }
}