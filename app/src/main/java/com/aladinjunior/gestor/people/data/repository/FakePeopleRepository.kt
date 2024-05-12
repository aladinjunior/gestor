package com.aladinjunior.gestor.people.data.repository

import com.aladinjunior.gestor.people.data.local.PeopleFakeLocalDataSource
import com.aladinjunior.gestor.people.domain.model.Person

class FakePeopleRepository(
    peopleFakeLocalDataSource: PeopleFakeLocalDataSource
) : PeopleRepository {

    override val people: List<Person> = peopleFakeLocalDataSource.fakePeople

    override suspend fun getPeopleByFirstName(firstName: String): List<Person> {
        TODO("Not yet implemented")
    }
}