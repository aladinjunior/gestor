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
import androidx.compose.material.icons.outlined.AutoGraph
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import com.aladinjunior.gestor.commom.components.DropDownArrow
import com.aladinjunior.gestor.commom.components.GenericTopAppBar
import com.aladinjunior.gestor.feature.sales.components.PeriodSelectionContainer
import com.aladinjunior.gestor.feature.sales.components.SaleDateRangePicker
import com.aladinjunior.gestor.feature.sales.components.SaleDetails
import com.aladinjunior.gestor.feature.sales.domain.model.Product
import com.aladinjunior.gestor.feature.sales.domain.model.Sale
import com.aladinjunior.gestor.feature.sales.presentation.Sales.saleList
import com.aladinjunior.gestor.ui.theme.GestorTheme
import java.time.LocalDateTime


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalesScreen(
    selectedDates: (Pair<String, String>) -> Unit,
    sales: List<Sale>,
) {


    var showBottomSheet by remember { mutableStateOf(false) }

    Column {

        SalesScreenHeader(
            modifier = Modifier.padding(horizontal = 10.dp),
            showBottomSheet = {
                showBottomSheet = true
            }
        )

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f)
        ) {

            LazyColumn {
                items(sales.size) {

                    SaleDetails(
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
                    )
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
fun SalesScreenHeader(
    modifier: Modifier = Modifier,
    showBottomSheet: () -> Unit

) {
    GenericTopAppBar(modifier = modifier, onBackPressed = { /*TODO*/ }, currentScreenTitle = "Sales")

    Spacer(modifier = Modifier.size(18.dp))

    PeriodSelectionContainer(
        modifier = modifier,
        showBottomSheet = showBottomSheet
    )

    Spacer(modifier = Modifier.size(20.dp))

}

@Composable
fun SalesLabelRow(
    modifier: Modifier = Modifier,
    label: String,
    expanded: Boolean = true,
    onArrowClick: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Icon(
            modifier = Modifier.size(26.dp),
            imageVector = Icons.Outlined.AutoGraph,
            contentDescription = "Sales Label"
        )

        Text(
            text = label, fontSize = 19.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Period", style = MaterialTheme.typography.titleMedium)
        DropDownArrow (onArrowClick = onArrowClick, expanded = expanded)
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
                sales = saleList,

            )
        }
    }
}

object Sales {
    private val Products = List(5) {
        Product(
            id = it.toLong(),
            productName = "Product $it",
            amount = it * 5
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    val saleList = List(10) {
        Sale(
            id = it.toLong(),
            products = Products,
            "Seller $it",
            LocalDateTime.now().toString(),
            it
        )
    }
}