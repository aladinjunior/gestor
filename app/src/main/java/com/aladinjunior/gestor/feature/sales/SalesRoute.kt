package com.aladinjunior.gestor.feature.sales

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.aladinjunior.gestor.feature.sales.presentation.SalesScreen
import com.aladinjunior.gestor.feature.sales.presentation.SalesViewModel

@Composable
fun SalesRoute() {
    val viewModel: SalesViewModel = hiltViewModel()


    SalesScreen(
        onOptionSelected = {},
        selectedDates = {
        }
    )
}