package com.compose.weatherapplite.utils

import java.lang.StringBuilder
import java.time.LocalDate

fun LocalDate.convertToWeatherAppLiteDate(): String {
    val sb = StringBuilder()
    sb.append("${this.dayOfMonth} ${this.month}, ${this.dayOfWeek}")

    return sb.toString()
}

fun String.toTimeInTheDay(): String {
    val processedString = this.dropLast(3).takeLast(2)
    val time = processedString.toInt()
    val ampm = if (time >= 12) "pm" else "am"

    val finalTime = if (time > 12) time - 12 else if (time == 0) 12 else time

    return "$finalTime $ampm"
}