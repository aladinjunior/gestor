package com.aladinjunior.gestor.feature.sales.components

import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DateRangePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaleDateRangePicker(
    dateRangePickerState: DateRangePickerState,
    onDismiss: () -> Unit,
    selectedDates: (Pair<Long, Long>) -> Unit

) {

    val sheetState = rememberModalBottomSheetState()

        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = sheetState
        ) {
            DateRangePicker(
                state = dateRangePickerState,
                modifier = Modifier,
            )

            LaunchedEffect(
                key1 = dateRangePickerState.selectedStartDateMillis,
                key2 = dateRangePickerState.selectedEndDateMillis
            ) {
                if (dateRangePickerState.selectedStartDateMillis != null
                    && dateRangePickerState.selectedEndDateMillis != null
                ) {
                    selectedDates(
                        Pair(
                            first = dateRangePickerState.selectedStartDateMillis!!,
                            second = dateRangePickerState.selectedEndDateMillis!!
                        )
                    )

                    onDismiss()
                    sheetState.hide()

                }


            }


        }



}
