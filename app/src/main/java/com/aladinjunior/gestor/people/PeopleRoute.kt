package com.aladinjunior.gestor.people

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.aladinjunior.gestor.people.presentation.PeopleViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aladinjunior.gestor.people.presentation.PeopleScreen

@Composable
fun PeopleRoute(
) {
    val viewModel: PeopleViewModel = viewModel(factory = PeopleViewModel.PeopleViewModelFactory())

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

