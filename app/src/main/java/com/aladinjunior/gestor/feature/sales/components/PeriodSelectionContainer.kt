package com.aladinjunior.gestor.feature.sales.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aladinjunior.gestor.commom.components.GenericInfoText
import com.aladinjunior.gestor.feature.sales.components.PeriodConstants.periods
import com.aladinjunior.gestor.ui.theme.GestorTheme


private val componentsHorizontalPadding = 12.dp
private val componentsStartPadding = 15.dp
private val dropDownArrowSize = 30.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PeriodSelectionContainer(
    periodOptions: List<String> = periods,
    onOptionSelected: (String) -> Unit,
) {

    var selectedOption by remember { mutableStateOf(periods[0]) }
    var expanded by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier.padding(horizontal = componentsHorizontalPadding)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    delayMillis = 50,
                    easing = LinearOutSlowInEasing
                )
            )

    ) {

        PeriodSelectionBar(expanded = expanded) {
            expanded = !expanded
        }
        if (expanded)
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

@Composable
fun PeriodSelectionBar(
    expanded: Boolean = true,
    onArrowClick: () -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }

    val rotationState by animateFloatAsState(
        targetValue =
        if (expanded) 180f else 0f,
        label = "rotatioState"
    )

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        GenericInfoText(
            modifier = Modifier.padding(start = componentsStartPadding),
            text = "Selecione o periodo das vendas",
            textSize = 20.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            modifier = Modifier
                .size(dropDownArrowSize)
                .rotate(rotationState)
                .clickable(
                    indication = null,
                    interactionSource = interactionSource
                ) { onArrowClick() },
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "Drop-Down Arrow"
        )

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



