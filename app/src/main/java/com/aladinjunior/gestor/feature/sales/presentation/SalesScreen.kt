package com.aladinjunior.gestor.feature.sales.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aladinjunior.gestor.commom.components.GenericButton
import com.aladinjunior.gestor.commom.components.GenericTopAppBar
import com.aladinjunior.gestor.feature.sales.components.PeriodSelectionContainer
import com.aladinjunior.gestor.ui.theme.GestorTheme


private val buttonPadding = 18.dp

@Composable
fun SalesScreen(
    onOptionSelected: (String) -> Unit
) {

    Column {

        GenericTopAppBar(onBackPressed = { /*TODO*/ }, currentScreenTitle = "Vendas")

        PeriodSelectionContainer(onOptionSelected = onOptionSelected)

        Spacer(modifier = Modifier.weight(1f))
        GenericButton(modifier = Modifier.padding(buttonPadding),buttonText = "Selecionar") {
            
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun SalesScreenPreview() {
    GestorTheme {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            SalesScreen(
                onOptionSelected = {},

            )
        }
    }
}