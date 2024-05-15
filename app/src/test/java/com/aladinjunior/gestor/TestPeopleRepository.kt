package com.aladinjunior.gestor

import com.aladinjunior.gestor.people.data.repository.PeopleRepository
import com.aladinjunior.gestor.people.domain.model.Person
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
            people.filter { it.nome.contains(firstName, ignoreCase = true) }
        }
    }

    fun sendPeople(people: List<Person>){
        peopleFlow.tryEmit(people)
    }
}