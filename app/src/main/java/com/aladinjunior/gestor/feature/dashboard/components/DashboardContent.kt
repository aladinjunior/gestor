package com.aladinjunior.gestor.feature.dashboard.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aladinjunior.gestor.R
import com.aladinjunior.gestor.commom.components.GenericInfoText
import com.aladinjunior.gestor.ui.theme.GestorTheme

private val cardContentHeight = 600.dp
private val cardContentTopSpace = 40.dp
private val userNameTextSize = 30.sp
private val addressTextSize = 16.sp
private val dividerPadding = 25.dp
private val dividerPaddingDouble = 50.dp
private val companyLabelTextSize = 18.sp
private val companyTextSize = 36.sp
private val verticalDividerSpace = 16.dp

const val COMPANY = "Empresa"

@Composable
fun DashboardContent(
    modifier: Modifier = Modifier,
    @DrawableRes userImage: Int,
    userName: String,
    address: String,
    companyName: String,
    actionClicked: (action: String) -> Unit

) {

    Box(modifier = modifier) {

//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .size(height = cardContentHeight, width = 0.dp)
//                .padding(top = cardContentTopSpace)
//        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
               horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.size(cardContentTopSpace))
                GenericInfoText(text = userName, textSize = userNameTextSize, fontWeight = FontWeight.Bold)
                GenericInfoText(text = address, textSize = addressTextSize, fontWeight = FontWeight.Normal, textColor = MaterialTheme.colorScheme.onSurfaceVariant)
                HorizontalDivider(modifier = Modifier.padding(horizontal = dividerPaddingDouble))
                Spacer(modifier = Modifier.size(verticalDividerSpace))
                GenericInfoText(text = COMPANY, textSize = companyLabelTextSize, fontWeight = FontWeight.Bold)
                GenericInfoText(text = companyName, textSize = companyTextSize, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.size(verticalDividerSpace))
                HorizontalDivider(modifier = Modifier.padding(horizontal = dividerPadding))
                Spacer(modifier = Modifier.size(verticalDividerSpace))
                ActionsRow(modifier = Modifier.padding(horizontal = dividerPadding), actionClicked = actionClicked)



            }

//        }
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.Center
//        ) {
//            NoBorderCircleUserImage(imageSize = 100.dp, userImage = userImage)
//        }


    }


}

@Preview(showBackground = true)
@Composable
private fun DashboardContentPreview() {
    GestorTheme {
        Box(modifier = Modifier.fillMaxSize()) {

            DashboardContent(userImage = R.drawable.ic_launcher_background,
                userName = "LOREM", address = "Brazil", companyName = "IPSUM", actionClicked = {})
        }
    }
}