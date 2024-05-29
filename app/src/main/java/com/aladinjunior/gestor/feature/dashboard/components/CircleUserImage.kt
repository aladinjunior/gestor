package com.aladinjunior.gestor.feature.dashboard.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.aladinjunior.gestor.R
import com.aladinjunior.gestor.ui.theme.GestorTheme


private val borderWidth = 3.dp
private val imageSize = 80.dp

@Composable
fun CircleUserImage(
    @DrawableRes userImage: Int
) {
    Image(
        painter = painterResource(id = userImage), contentDescription = "userCircleImage",
        modifier = Modifier
            .size(imageSize)
            .clip(CircleShape)
            .border(borderWidth, MaterialTheme.colorScheme.primary, CircleShape),
        contentScale = ContentScale.Crop

    )
}

@Composable
fun NoBorderCircleUserImage(
    @DrawableRes userImage: Int,
    imageSize: Dp,
) {
    Card(
        shape = RoundedCornerShape(50),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 8.dp
        )
    ) {

        Image(
            painter = painterResource(id = userImage), contentDescription = "userCircleImage",
            modifier = Modifier
                .size(imageSize)
                .clip(CircleShape),
            contentScale = ContentScale.Crop

        )
    }
}

@Preview
@Composable
private fun CircleUserImagePreview() {

    GestorTheme {
        NoBorderCircleUserImage(R.drawable.ic_launcher_foreground, 100.dp)
    }
}