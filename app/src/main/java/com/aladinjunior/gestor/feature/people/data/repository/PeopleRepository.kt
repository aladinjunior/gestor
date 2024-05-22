package com.aladinjunior.gestor.feature.people.data.repository

import com.aladinjunior.gestor.feature.people.Person
import kotlinx.coroutines.flow.Flow

interface PeopleRepository {

    val people: List<Person>

    /**
     * Get the list of people that has the name started by [firstName].
     */
    suspend fun getPeopleByFirstName(firstName: String) : Flow<List<Person>>
}