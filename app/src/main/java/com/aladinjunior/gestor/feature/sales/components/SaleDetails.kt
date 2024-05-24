package com.aladinjunior.gestor.feature.sales.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PointOfSale
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aladinjunior.gestor.commom.components.DropDownArrow
import com.aladinjunior.gestor.ui.theme.GestorTheme

val items = List(5) { "Item $it" }


@Composable
fun SaleDetails(

    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier.height(150.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp)

        ) {
            FilledTonalIconButton(modifier = Modifier.padding(10.dp).size(60.dp),
                onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.PointOfSale, contentDescription = "Point of Sale")
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "R$ 100,00", style = MaterialTheme.typography.titleLarge)
                Text(text = "User", style = MaterialTheme.typography.bodyLarge)
                Text(text = "12:59", style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f)
                ))
                Spacer(modifier = Modifier.size(12.dp))

            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Details", style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier.padding(horizontal = 10.dp)
            )


        }
    }
}

@Composable
fun SaleDetailLabelRow(
    label: String,
    expanded: Boolean,
    onArrowClick: () -> Unit,
) {
    Row {
        Text(text = label, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.weight(1f))
        DropDownArrow(expanded = expanded, onArrowClick = onArrowClick)

    }
}


@Preview
@Composable
private fun SaleCardPreview() {
    GestorTheme {
        SaleDetails(

        )
    }
}

