package com.aladinjunior.gestor.feature.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aladinjunior.gestor.feature.dashboard.components.DashboardContent
import com.aladinjunior.gestor.commom.components.TopRoundedBackground

@Composable
fun DashboardScreen(
    userImage: Int,
    userName: String,
    address: String,
    companyName: String,
    actionClicked: (action: String) -> Unit

) {
    TopRoundedBackground(height = 250)
    Column {
        Spacer(modifier = Modifier.size(70.dp))
        DashboardContent(
            userImage = userImage,
            userName = userName,
            address = address,
            companyName = companyName,
            modifier = Modifier.padding(horizontal = 30.dp),
            actionClicked = actionClicked
        )
    }


}

