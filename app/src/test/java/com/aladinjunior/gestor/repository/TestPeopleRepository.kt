package com.aladinjunior.gestor.repository

import com.aladinjunior.gestor.feature.people.data.repository.PeopleRepository
import com.aladinjunior.gestor.feature.people.Person
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.map

class TestPeopleRepository : PeopleRepository {

    private val peopleFlow = MutableSharedFlow<List<Person>>(
        replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    override val people: List<Person>
        get() = TODO("Not yet implemented")

    override suspend fun getPeopleByFirstName(firstName: String): Flow<List<Person>> {
        return peopleFlow.map { people ->
            people.filter { it.name.contains(firstName, ignoreCase = true) }
        }
    }

    fun sendPeople(people: List<Person>){
        peopleFlow.tryEmit(people)
    }
}