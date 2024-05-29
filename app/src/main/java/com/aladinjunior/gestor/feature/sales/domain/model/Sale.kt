package com.aladinjunior.gestor.feature.sales.domain.model

data class Sale(
    val id: Long,
    val products: List<Product>,
    val seller: String,
    val hour: String,
    val value: Double,
) {
    class SaleBuilder(
        var id: Long = 0,
        var products: List<Product> = emptyList(),
        var seller: String = "",
        var hour: String = "",
        var value: Double = 0.0
    ) {
        fun build(): Sale =
            Sale(
                id = id,
                products = products,
                seller = seller,
                hour = hour,
                value = value
            )

    }
}

fun sale(block: Sale.SaleBuilder.() -> Unit) = Sale.SaleBuilder().apply(block).build()
