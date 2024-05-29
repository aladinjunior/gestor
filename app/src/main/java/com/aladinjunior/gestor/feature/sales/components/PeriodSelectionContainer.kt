package com.aladinjunior.gestor.feature.sales.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aladinjunior.gestor.feature.sales.components.PeriodConstants.SELECT_PERIOD
import com.aladinjunior.gestor.feature.sales.components.PeriodConstants.periods
import com.aladinjunior.gestor.feature.sales.presentation.SalesLabelRow


private val componentsStartPadding = 15.dp
private val dropDownArrowSize = 30.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PeriodSelectionContainer(
    modifier: Modifier = Modifier,
    periodOptions: List<String> = periods,
    showBottomSheet: () -> Unit
) {

    var selectedOption by remember { mutableStateOf(periods[0]) }
    var expanded by remember { mutableStateOf(false) }


    Column(
        modifier = modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )

    ) {

        SalesLabelRow(label = "Sales", expanded = expanded) {
            expanded = !expanded
        }
        if (expanded) {

            FlowRow {
                periodOptions.forEach { option ->
                    PeriodRadioButton(
                        isRadioSelected = option == selectedOption,
                        label = option
                    ) {
                        selectedOption = option
                    }
                }

            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    if (selectedOption == SELECT_PERIOD) showBottomSheet()
                }) {
                Text(text = "Confirm")
            }
        }
    }


}


object PeriodConstants {

    private const val TODAY = "Today"
    private const val SEVEN_DAYS = "7 days"
    private const val FIFTEEN_DAYS = "15 days"
    private const val THIRTY_DAYS = "30 days"
    const val SELECT_PERIOD = "Select the period"

    val periods = listOf(
        TODAY, SEVEN_DAYS, FIFTEEN_DAYS, THIRTY_DAYS, SELECT_PERIOD
    )
}



