package com.aladinjunior.gestor.feature.sales.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aladinjunior.gestor.commom.components.DropDownArrow
import com.aladinjunior.gestor.ui.theme.GestorTheme

val items = List(5) { "Item $it" }


@Composable
fun SaleDetails(

) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(14.dp)

    ) {
        Box(
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
        ) {
            //TODO: some image here?
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.animateContentSize(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = LinearOutSlowInEasing
                )
            )
        ) {
            SaleDetailLabelRow(label = "Lorem", expanded = expanded) {
                expanded = !expanded
            }
            if (expanded) BulletPointedList(items = items)
            Text(text = "Ipsum", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.size(6.dp))
            HorizontalDivider()
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

