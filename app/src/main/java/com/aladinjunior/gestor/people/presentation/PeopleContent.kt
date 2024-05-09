package com.aladinjunior.gestor.people.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aladinjunior.gestor.people.data.local.PeopleFakeLocalDataSource.fakePeople
import com.aladinjunior.gestor.people.domain.model.Person
import com.aladinjunior.gestor.ui.theme.GestorTheme
import com.aladinjunior.gestor.util.GenericInfoText

private val horizontalStartPadding = 24.dp
private val personNameSize = 14.sp
private val verticalSpaceArrangementSize = 9.dp

@Composable
fun PeopleContent(
    modifier: Modifier = Modifier,
    people: List<Person> = fakePeople,

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
