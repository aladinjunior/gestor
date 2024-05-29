package com.aladinjunior.gestor

import com.aladinjunior.gestor.feature.people.data.local.PeopleFakeLocalDataSource
import com.aladinjunior.gestor.feature.people.data.repository.FakePeopleRepository
import com.aladinjunior.gestor.feature.people.Person
import com.aladinjunior.gestor.feature.people.presentation.PeopleViewModel
import com.aladinjunior.gestor.rule.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class PeopleViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val repository = FakePeopleRepository(PeopleFakeLocalDataSource)

    private lateinit var viewModel: PeopleViewModel

    @Before
    fun setup() {
        viewModel = PeopleViewModel(repository)
    }

    @Test
    fun peopleNameIsReturned_withMatchingQuery() = runTest {

        val job = launch {
            viewModel.people.collect()
        }

        viewModel.onSearchTextChange("person 1")

        advanceUntilIdle()

        val expectedPeople = listOf(
            Person(id = 0, "Person 1"),
            Person(id = 0, "Person 10"),
            Person(id = 0, "Person 11"),
            Person(id = 0, "Person 12"),
            Person(id = 0, "Person 13"),
            Person(id = 0, "Person 14"),
            Person(id = 0, "Person 15"),
            Person(id = 0, "Person 16"),
            Person(id = 0, "Person 17"),
            Person(id = 0, "Person 18"),
            Person(id = 0, "Person 19"),
        )

        assertEquals(expectedPeople, viewModel.people.value)

        job.cancel()
    }



}