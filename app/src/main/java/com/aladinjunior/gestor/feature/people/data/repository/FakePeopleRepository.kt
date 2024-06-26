package com.aladinjunior.gestor.feature.people.data.repository

import com.aladinjunior.gestor.feature.people.data.local.PeopleFakeLocalDataSource
import com.aladinjunior.gestor.feature.people.Person
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class FakePeopleRepository @Inject constructor(
    private val peopleFakeLocalDataSource: PeopleFakeLocalDataSource
) : PeopleRepository {

    override val people: List<Person> = peopleFakeLocalDataSource.fakePeople2
    override suspend fun getPeopleByFirstName(firstName: String): Flow<List<Person>> {
        return flowOf(peopleFakeLocalDataSource.getPeopleByFirstName(firstName))

    }
}