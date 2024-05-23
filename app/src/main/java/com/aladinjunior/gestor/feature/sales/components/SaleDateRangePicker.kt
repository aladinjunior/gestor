package com.aladinjunior.gestor.feature.sales.components

import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DateRangePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.aladinjunior.gestor.util.convertMillisToDateString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaleDateRangePicker(
    dateRangePickerState: DateRangePickerState,
    onDismiss: () -> Unit,
    selectedDates: (Pair<String, String>) -> Unit

) {

    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState
    ) {
        DateRangePicker(
            state = dateRangePickerState,
            modifier = Modifier,
            dateFormatter = DatePickerDefaults.dateFormatter()
        )

        LaunchedEffect(
            key1 = dateRangePickerState.selectedStartDateMillis,
            key2 = dateRangePickerState.selectedEndDateMillis
        ) {
            if (dateRangePickerState.selectedStartDateMillis != null && dateRangePickerState.selectedEndDateMillis != null) {
                val selectedStartDate =
                    dateRangePickerState.selectedStartDateMillis?.let { (convertMillisToDateString(it)) }!!

                val selectedEndDate =
                    dateRangePickerState.selectedEndDateMillis?.let { convertMillisToDateString(it) }!!
                selectedDates(
                    Pair(
                        first = selectedStartDate,
                        second = selectedEndDate
                    )
                )
                sheetState.hide()
                onDismiss()

            }


        }


    }


}
