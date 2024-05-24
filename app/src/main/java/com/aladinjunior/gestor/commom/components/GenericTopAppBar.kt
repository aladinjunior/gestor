package com.aladinjunior.gestor.commom.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aladinjunior.gestor.ui.theme.GestorTheme

private val screenComponentsPadding = 12.dp
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
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = screenComponentsPadding)
    ) {


//        GoBackExtentedButton(
//            color = MaterialTheme.colorScheme.secondary,
//            text = backText,
//            textSize = topBarTextSize
//        )
        GoBackArrow()
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = currentScreenTitle, style = MaterialTheme.typography.headlineSmall.copy(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.weight(1.2f))

    }
}

@Composable
fun GoBackExtentedButton(color: Color, text: String, textSize: TextUnit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Icon(
            modifier = Modifier.size(40.dp),
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = "goBack",
            tint = color
        )
        Text(
            text = text, style = MaterialTheme.typography.headlineSmall.copy(
                color = color,
                fontWeight = FontWeight.Bold
            )
        )

    }

}

@Composable
fun GoBackArrow(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(30.dp)
            .clip(RoundedCornerShape(8f))
            .background(
            color = MaterialTheme.colorScheme.surfaceVariant),
        contentAlignment = Alignment.Center,

    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = "goBack",
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
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