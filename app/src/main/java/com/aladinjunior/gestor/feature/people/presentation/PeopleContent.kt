package com.aladinjunior.gestor.feature.people.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aladinjunior.gestor.commom.components.GenericInfoText
import com.aladinjunior.gestor.feature.people.Person
import com.aladinjunior.gestor.feature.people.data.local.PeopleFakeLocalDataSource.fakePeople2
import com.aladinjunior.gestor.ui.theme.GestorTheme

private val personNameSize = 14.sp
private val verticalSpaceArrangementSize = 9.dp

@Composable
fun PeopleContent(
    modifier: Modifier = Modifier,
    people: List<Person> = fakePeople2,

    ) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(verticalSpaceArrangementSize),
        modifier = modifier
    ) {


        items(people.size) {
            Row {
                GenericInfoText(
                    text = people[it].name,
                    textSize = personNameSize,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                    contentDescription = "personDetails"
                )
            }

            HorizontalDivider()
        }


    }

}

@Preview
@Composable
private fun PeopleContentPreview() {

    GestorTheme {
        Box(modifier = Modifier.fillMaxSize())
        PeopleContent()
    }
}
