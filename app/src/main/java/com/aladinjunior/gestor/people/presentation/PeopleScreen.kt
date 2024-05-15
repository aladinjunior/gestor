package com.aladinjunior.gestor.people.presentation

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
import com.aladinjunior.gestor.commom.components.GenericTopAppBar
import com.aladinjunior.gestor.people.components.GestorSearchBar
import com.aladinjunior.gestor.people.domain.model.Person
import com.aladinjunior.gestor.ui.theme.GestorTheme
import com.aladinjunior.gestor.util.GenericInfoText

private val screenComponentsPadding = 12.dp
private val peopleContentPadding = 24.dp


@Composable
fun PeopleScreen(
    searchText: String,
    onSearchTextChange: (text: String) -> Unit,
    people: List<Person>

) {
    Column {
        GenericTopAppBar(modifier = Modifier.padding(vertical = screenComponentsPadding),onBackPressed = { /*TODO*/ }, currentScreenTitle = "Pessoas")
        GestorSearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(screenComponentsPadding),
            hint = "Nome",
            searchText = searchText,
            onSearchTextChange = onSearchTextChange,
            )
        Spacer(modifier = Modifier.size(20.dp))

        GenericInfoText(text = "Pessoas", textSize = 18.sp, modifier = Modifier.padding(start = peopleContentPadding), textColor = MaterialTheme.colorScheme.secondary)
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

