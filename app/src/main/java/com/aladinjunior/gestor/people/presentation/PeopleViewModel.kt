@file:OptIn(FlowPreview::class)

package com.aladinjunior.gestor.people.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.aladinjunior.gestor.network.RetrofitGestorNetwork
import com.aladinjunior.gestor.people.data.repository.DefaultPeopleRepository
import com.aladinjunior.gestor.people.data.repository.PeopleRepository
import com.aladinjunior.gestor.people.domain.model.Person
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.stateIn


class PeopleViewModel(
    private val peopleRepository: PeopleRepository
) : ViewModel() {


    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()


    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }


    private val _people = MutableStateFlow(listOf<Person>())
    val people = searchText
        .debounce(1000L)
        .combine(_people) { text, people ->
            if (text.isBlank()) {
                people
            } else {
                peopleRepository.getPeopleByFirstName(text).filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )



    class PeopleViewModelFactory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PeopleViewModel::class.java)) {
                return PeopleViewModel(DefaultPeopleRepository(RetrofitGestorNetwork())) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}

