package com.aladinjunior.gestor.people.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.aladinjunior.gestor.TestConfig
import com.aladinjunior.gestor.network.RetrofitGestorNetwork
import com.aladinjunior.gestor.people.data.local.PeopleFakeLocalDataSource
import com.aladinjunior.gestor.people.data.local.PeopleFakeLocalDataSource.fakePeople
import com.aladinjunior.gestor.people.data.repository.DefaultPeopleRepository
import com.aladinjunior.gestor.people.data.repository.FakePeopleRepository
import com.aladinjunior.gestor.people.data.repository.PeopleRepository
import com.aladinjunior.gestor.people.domain.model.Person
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

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
class PeopleViewModel(
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
            if (text.isBlank()){
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
            _people.value = fakePeople
        }
    }



    class PeopleViewModelFactory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PeopleViewModel::class.java)) {
                return if (TestConfig.isTest) {
                    PeopleViewModel(FakePeopleRepository(PeopleFakeLocalDataSource)) as T

                } else {
                    PeopleViewModel(DefaultPeopleRepository(RetrofitGestorNetwork())) as T
                }
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}



