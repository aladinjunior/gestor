package com.aladinjunior.gestor.feature.sales.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aladinjunior.gestor.commom.components.GenericTopAppBar
import com.aladinjunior.gestor.feature.sales.components.SaleDetails
import com.aladinjunior.gestor.ui.theme.GestorTheme

@Composable
fun SaleDetailsScreen() {
    Column {
        GenericTopAppBar(modifier = Modifier.padding(start = 14.dp), onBackPressed = { /*TODO*/ }, currentScreenTitle = "Sale Details")
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)),
        ) {
            SaleDetails(
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun SaleDetailsScreenPreview() {
    GestorTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            SaleDetailsScreen()

        }
    }
}