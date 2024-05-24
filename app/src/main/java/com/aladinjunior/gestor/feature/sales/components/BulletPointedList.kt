package com.aladinjunior.gestor.feature.sales.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BulletPointedList(items: List<String>) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        items.forEach {  item ->
            BulletListItem {
                Text(text = item)
            }
        }
    }
}

@Composable
fun BulletListItem(
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        BulletPoint()
        Spacer(modifier = Modifier.width(8.dp))
        content()
    }
}


@Composable
fun BulletPoint() {
    Canvas(modifier = Modifier.size(3.dp)) {
        drawCircle(
            color = Color.Black,
            radius = size.minDimension / 2
        )
    }
}