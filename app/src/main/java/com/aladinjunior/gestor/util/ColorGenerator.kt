package com.aladinjunior.gestor.util

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

val random = Random
fun getRandomColor() = Color(
    alpha = 255,
    red = random.nextInt(256),
    blue = random.nextInt(256),
    green = random.nextInt(256)
)



