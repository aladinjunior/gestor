package com.aladinjunior.gestor.feature.sales.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aladinjunior.gestor.commom.components.GenericInfoText
import com.aladinjunior.gestor.feature.sales.components.PeriodConstants.periods
import com.aladinjunior.gestor.ui.theme.GestorTheme


private val componentsHorizontalPadding = 12.dp
private val componentsStartPadding = 15.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PeriodSelectionContainer(
    periodOptions: List<String> = periods,
    onOptionSelected: (String) -> Unit,
) {

    var selectedOption by remember { mutableStateOf(periods[0]) }

    Column(
        modifier = Modifier.padding(horizontal = componentsHorizontalPadding)
    ) {
        GenericInfoText(modifier = Modifier.padding(start = componentsStartPadding),text = "Selecione o periodo das vendas", textSize = 20.sp)
        FlowRow {
            periodOptions.forEach { option ->
                PeriodRadioButton(
                    isRadioSelected = option == selectedOption,
                    label = option
                ) {
                    selectedOption = option
                    onOptionSelected(selectedOption)
                }
            }

        }
    }



}

@Preview(showBackground = true)
@Composable
private fun PeriodSelectionContainerPreview() {
    GestorTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            PeriodSelectionContainer {

            }

        }
    }
}


object PeriodConstants {
    val periods = listOf(
        "Hoje", "7 dias", "15 dias", "30 dias", "Selecionar periodo"
    )
}



