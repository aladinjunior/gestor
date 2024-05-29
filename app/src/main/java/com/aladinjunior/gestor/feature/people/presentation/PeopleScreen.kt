package com.aladinjunior.gestor.feature.people.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aladinjunior.gestor.commom.components.GenericInfoText
import com.aladinjunior.gestor.commom.components.GenericTopAppBar
import com.aladinjunior.gestor.feature.people.Person
import com.aladinjunior.gestor.feature.people.components.GestorSearchBar
import com.aladinjunior.gestor.ui.theme.GestorTheme

private val screenComponentsPadding = 12.dp
private val peopleContentPadding = 24.dp


@Composable
fun PeopleScreen(
    searchText: String,
    onSearchTextChange: (text: String) -> Unit,
    people: List<Person>

) {
    Column {
        GenericTopAppBar(modifier = Modifier.padding(start = screenComponentsPadding), onBackPressed = { /*TODO*/ }, currentScreenTitle = "People")
        GestorSearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(screenComponentsPadding),
            hint = "Name",
            searchText = searchText,
            onSearchTextChange = onSearchTextChange,
            )
        Spacer(modifier = Modifier.size(20.dp))

        GenericInfoText(text = "People", textSize = 18.sp, modifier = Modifier.padding(start = peopleContentPadding), textColor = MaterialTheme.colorScheme.secondary)
        if (people.isNotEmpty()){
            Card(modifier = Modifier.padding(horizontal = screenComponentsPadding), shape = RoundedCornerShape(topStart = screenComponentsPadding, topEnd = screenComponentsPadding)) {
                PeopleContent(modifier = Modifier.padding(peopleContentPadding), people = people)

            }
        }


    }

}

@Preview(showBackground = true)
@Composable
private fun PeopleScreenPreview() {

    GestorTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            PeopleScreen("",  onSearchTextChange = {}, people = emptyList())
        }
    }
}

