package com.aladinjunior.gestor.feature.sales.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aladinjunior.gestor.commom.components.GenericInfoText
import com.aladinjunior.gestor.ui.theme.GestorTheme


private val checkboxTextSize = 16.sp

@Composable
fun PeriodRadioButton(
    isRadioSelected: Boolean,
    label: String,
    onClick: () -> Unit,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        RadioButton(selected = isRadioSelected, onClick = onClick)
        GenericInfoText(text = label, textSize = checkboxTextSize)
    }

}

@Preview(showBackground = true)
@Composable
private fun TextCustomCheckboxPreview() {
    GestorTheme {
        PeriodRadioButton(isRadioSelected = false, "Test") {}
    }
}