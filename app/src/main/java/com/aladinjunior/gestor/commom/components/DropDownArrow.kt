package com.aladinjunior.gestor.commom.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun DropDownArrow(
    dropDownArrowSize: Dp = 30.dp,
    expanded: Boolean = true,
    onArrowClick: () -> Unit,
) {

    val rotationState by animateFloatAsState(
        targetValue =
        if (expanded) 180f else 0f,
        label = "rotatioState"
    )

    val interactionSource = remember { MutableInteractionSource() }

    Icon(
        modifier = Modifier
            .size(dropDownArrowSize)
            .rotate(rotationState)
            .clickable(
                indication = null,
                interactionSource = interactionSource
            ) { onArrowClick() },
        imageVector = Icons.Default.KeyboardArrowDown,
        contentDescription = "Drop-Down Arrow"
    )
}