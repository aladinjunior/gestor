package com.aladinjunior.gestor.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.aladinjunior.gestor.R
import com.aladinjunior.gestor.commom.User


@Composable
fun DashboardRoute(
    loggedInUser: User
) {

    DashboardScreen(
        userImage = loggedInUser.image,
        userName = loggedInUser.name,
        address = loggedInUser.address,
        companyName = loggedInUser.company
    )
}

