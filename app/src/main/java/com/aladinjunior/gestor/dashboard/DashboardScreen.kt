package com.aladinjunior.gestor.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aladinjunior.gestor.R
import com.aladinjunior.gestor.dashboard.components.DashboardContent
import com.aladinjunior.gestor.ui.theme.GestorTheme
import com.aladinjunior.gestor.util.TopRoundedBackground

@Composable
fun DashboardScreen(
    userImage: Int,
    userName: String,
    address: String,
    companyName: String,

) {
    TopRoundedBackground(height = 250)
    Column {
        Spacer(modifier = Modifier.size(70.dp))
        DashboardContent(
            userImage = userImage,
            userName = userName,
            address = address,
            companyName = companyName,
            modifier = Modifier.padding(horizontal = 30.dp)
        )
    }


}

@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    GestorTheme {
        Box(modifier = Modifier.fillMaxSize()) {

        }
    }
}