package com.aladinjunior.gestor.people.data.repository

import com.aladinjunior.gestor.network.GestorNetworkDataSource
import com.aladinjunior.gestor.people.domain.model.Person
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

private const val TAG = "TAG"

class DefaultPeopleRepository @Inject constructor(
    private val networkDataSource: GestorNetworkDataSource
) : PeopleRepository {
    override val people: List<Person>
        get() = TODO("Not yet implemented")

    override suspend fun getPeopleByFirstName(firstName: String): Flow<List<Person>> {


        return flow {
            try {
                val people = networkDataSource.getPeopleByFirstName(firstName)
                emit(people)
            } catch (e: Exception) {
              emit(emptyList())
            }
        }
    }
}