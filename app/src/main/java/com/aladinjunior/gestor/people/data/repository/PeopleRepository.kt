package com.aladinjunior.gestor.people.data.repository

import com.aladinjunior.gestor.people.domain.model.Person

interface PeopleRepository {

    val people: List<Person>

    suspend fun getPeopleByFirstName(firstName: String) : List<Person>
}