package com.aladinjunior.gestor.commom

import androidx.annotation.DrawableRes
import com.aladinjunior.gestor.R

data class User(
    val id: Int,
    val name: String,
    val address: String,
    val company: String,
    @DrawableRes val image: Int,

    )  {
    class Builder(
        var id: Int = 0,
         var name: String = "",
         var address: String = "",
         var company: String = "",
        @DrawableRes  var image: Int = R.drawable.ic_launcher_background
    ) {

        fun build() = User(id, name, address, company, image)

    }


}





