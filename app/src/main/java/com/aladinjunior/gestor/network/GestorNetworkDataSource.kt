package com.aladinjunior.gestor.network

import com.aladinjunior.gestor.people.domain.model.Person

/**
 * Interface representing network calls to the backend, which is a database
 */
interface GestorNetworkDataSource {

    suspend fun getPeopleByFirstName(
        firstName: String? = null
    ) : List<Person>

}