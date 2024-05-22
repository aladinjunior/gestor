package com.aladinjunior.gestor.feature.people.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.aladinjunior.gestor.feature.people.data.local.PeopleFakeLocalDataSource
import com.aladinjunior.gestor.feature.people.data.repository.FakePeopleRepository
import com.aladinjunior.gestor.feature.people.data.repository.PeopleRepository
import com.aladinjunior.gestor.feature.people.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val peopleRepository: PeopleRepository,
) : ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    private val _people = MutableStateFlow(listOf<Person>())
    val people = searchText
        .debounce(1000L)
        .flatMapLatest { text ->
            if (text.isBlank()) {
                flowOf(_people.value)
            } else {
                peopleRepository.getPeopleByFirstName(text)
            }
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            _people.value
        )

    init {
        viewModelScope.launch {
            _people.value = emptyList()
        }
    }

    class PeopleViewModelFactory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PeopleViewModel::class.java)) {
                return PeopleViewModel(FakePeopleRepository(PeopleFakeLocalDataSource)) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}



