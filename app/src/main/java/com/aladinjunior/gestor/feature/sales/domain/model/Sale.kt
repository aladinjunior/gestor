package com.aladinjunior.gestor.feature.sales.domain.model

data class Sale(
    val id: Long,
    val products: List<Product>,
    val seller: String,
    val hour: String,
    val value: Int,
)
