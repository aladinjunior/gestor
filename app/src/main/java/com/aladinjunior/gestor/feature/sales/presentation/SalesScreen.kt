package com.aladinjunior.gestor.feature.sales.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aladinjunior.gestor.commom.components.GenericButton
import com.aladinjunior.gestor.commom.components.GenericTopAppBar
import com.aladinjunior.gestor.feature.sales.components.PeriodSelectionContainer
import com.aladinjunior.gestor.feature.sales.components.SaleDateRangePicker
import com.aladinjunior.gestor.ui.theme.GestorTheme


private val buttonPadding = 18.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalesScreen(
    selectedDates: (Pair<String, String>) -> Unit
) {

    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedOption by remember {
        mutableStateOf("")
    }

    Column {

        GenericTopAppBar(onBackPressed = { /*TODO*/ }, currentScreenTitle = "Vendas")

        PeriodSelectionContainer(onOptionSelected = { selectedOption = it })
        Spacer(modifier = Modifier.weight(1f))
        GenericButton(modifier = Modifier.padding(buttonPadding), buttonText = "Selecionar") {
            if (selectedOption == "Selecionar periodo") showBottomSheet = true
        }

        if (showBottomSheet) {


            val dateRangePickerState = rememberDateRangePickerState()
            SaleDateRangePicker(
                dateRangePickerState = dateRangePickerState,
                onDismiss = { showBottomSheet = false },
                selectedDates = selectedDates
            )
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
                selectedDates = {}
            )
        }
    }
}