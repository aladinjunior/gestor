package com.aladinjunior.gestor.feature.people

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.aladinjunior.gestor.feature.people.presentation.PeopleScreen
import com.aladinjunior.gestor.feature.people.presentation.PeopleViewModel

@Composable
fun PeopleRoute(
) {
    val viewModel: PeopleViewModel = hiltViewModel()

    val searchText by viewModel.searchText.collectAsState()
    val people by viewModel.people.collectAsState()

    PeopleScreen(
        searchText,
        onSearchTextChange = viewModel::onSearchTextChange,
        people = people
    )


}

@Preview
@Composable
private fun PeopleRoutePreview() {
    PeopleRoute()
}

