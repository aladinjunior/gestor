package com.aladinjunior.gestor.feature.dashboard.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aladinjunior.gestor.feature.dashboard.Actions
import com.aladinjunior.gestor.ui.theme.GestorTheme


private val actions: List<String> = List(5) {
    "Item $it"
}


@Composable
fun ActionsRow(
    modifier: Modifier = Modifier,
    actions: List<String> = Actions.actions,
    actionClicked: (itemClicked: String) -> Unit,
) {

    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        actions.forEach { action ->

            Row(
                modifier = Modifier
                    .clickable(
                        indication = null,
                        interactionSource = interactionSource
                    ) {
                        actionClicked(action)
                    }


            ) {
                Text(
                    text = action,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "next",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            HorizontalDivider()
        }
    }

}

@Preview
@Composable
private fun ActionsRowPreview() {
    GestorTheme {
        ActionsRow(actions = actions) {}
    }
}