package com.aladinjunior.gestor.feature.people

import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val codigo: Long,
    val nome: String,
) {
    class Builder(
        var id: Long = 0,
        var name: String = ""
    ) {
        fun build() = Person(id, name)
    }

    fun doesMatchSearchQuery(query: String) : Boolean
    {
        val matchingCombinations = listOf(nome, "${nome.first()}")

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }

}



