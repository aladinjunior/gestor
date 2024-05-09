package com.aladinjunior.gestor.people.domain.model

data class Person(
    val id: Long,
    val name: String,
) {
     class Builder(
        var id: Long = 0,
        var name: String = ""
    ) {
        fun build() = Person(id, name)
    }


}



