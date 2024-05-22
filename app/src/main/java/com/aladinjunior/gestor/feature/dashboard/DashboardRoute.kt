package com.aladinjunior.gestor.feature.dashboard

import androidx.compose.runtime.Composable
import com.aladinjunior.gestor.commom.User


@Composable
fun DashboardRoute(
    onActionClicked: (action: String) -> Unit,
    loggedInUser: User
) {
    DashboardScreen(
        userImage = loggedInUser.image,
        userName = loggedInUser.name,
        address = loggedInUser.address,
        companyName = loggedInUser.company,
        actionClicked = onActionClicked
    )
}

