package com.aladinjunior.gestor.feature.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aladinjunior.gestor.R
import com.aladinjunior.gestor.feature.dashboard.components.ActionsRow
import com.aladinjunior.gestor.feature.dashboard.components.NoBorderCircleUserImage
import com.aladinjunior.gestor.ui.theme.GestorTheme

@Composable
fun DashboardScreen(
    userImage: Int,
    userName: String,
    address: String,
    companyName: String,
    actionClicked: (action: String) -> Unit

) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
//        Spacer(modifier = Modifier.size(70.dp))
//        DashboardContent(
//            userImage = userImage,
//            userName = userName,
//            address = address,
//            companyName = companyName,
//            modifier = Modifier.padding(horizontal = 30.dp),
//            actionClicked = actionClicked
//        )
        Spacer(modifier = Modifier.size(30.dp))
        Text(
            text = userName,
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.ExtraBold)
        )
        NoBorderCircleUserImage(userImage = userImage, imageSize = 100.dp)

        Spacer(modifier = Modifier.size(50.dp))
        ActionsRow(
            modifier = Modifier.padding(horizontal = 44.dp),
            actionClicked = actionClicked
        )
    }


}

@Preview
@Composable
private fun DashboardScreenPreview() {
    GestorTheme {

        Box(modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize()) {

            DashboardScreen(
                userImage = R.drawable.frog_sample,
                userName = "Aladin",
                address = "Vitória de Santo Antão",
                companyName = "Bento Enterprise"
            ) {

            }
        }
    }
}

