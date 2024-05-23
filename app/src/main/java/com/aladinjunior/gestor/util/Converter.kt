package com.aladinjunior.gestor.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone


fun convertMillisToDateString(dateInMillis: Long) : String {

    val date = Date(dateInMillis)

    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    formatter.timeZone = TimeZone.getTimeZone("UTC")

    return formatter.format(date)
}