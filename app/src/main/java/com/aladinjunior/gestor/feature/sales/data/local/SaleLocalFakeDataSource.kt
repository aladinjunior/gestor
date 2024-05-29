package com.aladinjunior.gestor.feature.sales.data.local

import com.aladinjunior.gestor.feature.people.data.local.PeopleFakeLocalDataSource.fakePeople2
import com.aladinjunior.gestor.feature.sales.domain.model.Product
import com.aladinjunior.gestor.feature.sales.domain.model.sale
import com.aladinjunior.gestor.util.random

object SaleLocalFakeDataSource {

    private val fakeProducts = List(size = random.nextInt(1,7)) {
        Product(
            id = it.toLong(),
            productName = "Product ${random.nextInt()}",
            amount = random.nextInt(),
            value = random.nextDouble()
        )
    }

    val sales = List(size = 20) {
        sale {
            id = random.nextLong()
            products = fakeProducts
            seller = fakePeople2[random.nextInt(0, 8)].name
            hour = "10h:30"
            value = random.nextDouble()

        }
    }


}