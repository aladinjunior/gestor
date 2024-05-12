package com.aladinjunior.gestor.people.data.repository

import android.util.Log
import com.aladinjunior.gestor.network.GestorNetworkDataSource
import com.aladinjunior.gestor.people.domain.model.Person

private const val TAG = "TAG"

class DefaultPeopleRepository(
    private val networkDataSource: GestorNetworkDataSource
) : PeopleRepository {
    override val people: List<Person>
        get() = TODO("Not yet implemented")

    override suspend fun getPeopleByFirstName(firstName: String): List<Person> {

        return try {
            networkDataSource.getPeopleByFirstName(firstName)
        } catch (e: Exception){
            Log.d(TAG, "error: ${e.message}")
            emptyList()
        }
    }
}