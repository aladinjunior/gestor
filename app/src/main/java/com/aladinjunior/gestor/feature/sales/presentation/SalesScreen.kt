package com.aladinjunior.gestor.feature.sales.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aladinjunior.gestor.commom.components.GenericButton
import com.aladinjunior.gestor.commom.components.GenericInfoText
import com.aladinjunior.gestor.commom.components.GenericTopAppBar
import com.aladinjunior.gestor.feature.sales.components.PeriodSelectionContainer
import com.aladinjunior.gestor.feature.sales.components.SaleDateRangePicker
import com.aladinjunior.gestor.feature.sales.components.SaleDetails
import com.aladinjunior.gestor.feature.sales.domain.model.Product
import com.aladinjunior.gestor.feature.sales.domain.model.Sale
import com.aladinjunior.gestor.feature.sales.presentation.Sales.saleList
import com.aladinjunior.gestor.ui.theme.GestorTheme
import java.time.LocalDateTime


private val componentsHorizontalPadding = 12.dp
private val buttonPadding = 18.dp
private val salesIconSize = 30.dp
private val salesLabelTextSize = 22.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalesScreen(
    selectedDates: (Pair<String, String>) -> Unit,
    sales: List<Sale>
) {

    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedOption by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.padding(horizontal = componentsHorizontalPadding)
    ) {

        GenericTopAppBar(onBackPressed = { /*TODO*/ }, currentScreenTitle = "Vendas")

        PeriodSelectionContainer(
            onOptionSelected = { selectedOption = it })
        GenericButton(buttonText = "Selecionar") {
            if (selectedOption == "Selecionar periodo") showBottomSheet = true
        }
        Spacer(modifier = Modifier.size(18.dp))
        SalesLabelRow(label = "Sales")
        Spacer(modifier = Modifier.size(20.dp))
        Surface(

            color = MaterialTheme.colorScheme.primaryContainer

        ) {
            LazyColumn {
                items(sales.size) {
                    SaleDetails()
                }
            }
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

@Composable
fun SalesLabelRow(
    label: String
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(
            8.dp
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(salesIconSize),
            imageVector = Icons.Rounded.Menu,
            contentDescription = "Sales Label"
        )
        GenericInfoText(text = label, textSize = salesLabelTextSize,
            fontWeight = FontWeight.SemiBold)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
private fun SalesScreenPreview() {
    GestorTheme {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            SalesScreen(
                selectedDates = {},
                sales = saleList
            )
        }
    }
}

object Sales {
    private val Products = List(5) {
        Product(
            id = it.toLong(),
            productName ="Product $it",
            amount = it * 5
        )
    }
    @RequiresApi(Build.VERSION_CODES.O)
    val saleList = List(10) {
        Sale(
            id = it.toLong(),
            products = Products,
            "Seller $it",
            LocalDateTime.now().toString()
        )
    }
}