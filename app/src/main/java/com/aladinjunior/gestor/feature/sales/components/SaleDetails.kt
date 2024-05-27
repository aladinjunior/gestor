package com.aladinjunior.gestor.feature.sales.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aladinjunior.gestor.feature.sales.domain.model.Product
import com.aladinjunior.gestor.ui.theme.GestorTheme


val product = Product(
    0,
    "Product 1",
    10,
    10.0
)

@Composable
fun SaleDetails(
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(0f),
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        LazyColumn {
            items(3) {
                SaleDetailsListItem(modifier = Modifier.padding(10.dp),product = product, hour = "09:30")
                Spacer(modifier = Modifier.size(14.dp))
            }
        }
    }
}


@Composable
fun SaleDetailsListItem(
    modifier: Modifier = Modifier,
    product: Product,
    hour: String
) {

    var amountText = "${product.amount} Item"
    if (product.amount > 1) amountText = "${product.amount} Items"

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = product.productName, style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.SemiBold
            ))
            Text(text = amountText)
            Text(text = hour)
        }
        Spacer(modifier = Modifier.weight(1f))
        val styledValueText = buildAnnotatedString {
            withStyle(style = SpanStyle(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 22.sp
            )) {
                append("R$")
            }
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            ) {
                append("${product.value}")
            }

        }
        Text(text = styledValueText)
    }

}

@Preview
@Composable
private fun SaleDetailsPreview() {
    GestorTheme {
        SaleDetails()
    }
}