package com.aladinjunior.gestor.people.data.local

import com.aladinjunior.gestor.people.domain.model.Person

object PeopleFakeLocalDataSource {


    //builds a person object
    private fun person(block: Person.Builder.() -> Unit) = Person.Builder().apply(block).build()


    val fakePeople: List<Person> = List(21) { index -> person { name = "Person $index" } }

    fun getPeopleByFirstName(firstName: String) : List<Person> {
        return fakePeople.filter {
            it.nome.contains(firstName, ignoreCase = true)
        }
    }





}