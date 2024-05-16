package com.aladinjunior.gestor.people.data.local

import com.aladinjunior.gestor.people.domain.model.Person

object PeopleFakeLocalDataSource {


    //builds a person object
    private fun person(block: Person.Builder.() -> Unit) = Person.Builder().apply(block).build()


    val fakePeople: List<Person> = List(21) { index -> person { name = "Person $index" } }

    val fakePeople2 = listOf(
        person {
            name = "Aladin Junior"
        },
        person {
            name = "Bento Smith"
        },
        person {
            name = "Junior Jones"
        },
        person {
            name = "Mark Zuckerberg"
        },
        person {
            name = "Steve Jobs"
        },
        person {
            name = "Steve Seagal"
        },
        person {
            name = "Bill Gates"
        },
        person {
            name = "Jeff Bezzos"
        },
        person {
            name = "Jefferson Sean"
        },


    )
    fun getPeopleByFirstName(firstName: String) : List<Person> {
        return fakePeople2.filter {
            it.nome.contains(firstName, ignoreCase = true)
        }
    }





}