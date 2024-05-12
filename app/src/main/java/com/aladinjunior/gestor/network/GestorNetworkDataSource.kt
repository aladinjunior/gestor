package com.aladinjunior.gestor.network

import com.aladinjunior.gestor.people.domain.model.Person

interface GestorNetworkDataSource {

    suspend fun getPeopleByFirstName(
        firstName: String? = null
    ) : List<Person>

}