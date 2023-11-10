package com.compose.weatherapplite.utils

import java.lang.StringBuilder
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun LocalDate.convertToWeatherAppLiteDate(): String {
    val sb = StringBuilder()
    sb.append("${this.dayOfMonth} ${this.month}, ${this.dayOfWeek}")

    return sb.toString()
}

fun LocalDateTime.toTimeInTheDay(): String {
    val ampm = if (hour >= 12) "pm" else "am"
    val finalTime = if (hour > 12) hour - 12 else if (hour == 0) 12 else hour

    return "$finalTime $ampm"
}

fun String.toLocalDate(): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    return LocalDateTime.parse(this, formatter)
}

fun LocalDate.toDayOfWeek(): String {
    return if (this.isEqual(LocalDate.now())) "Today"
    else dayOfWeek.toString().lowercase().capitalize()
}

fun String.toShortenedCityName(): String {
    val stringInProcess = this.split(",")


    return when (stringInProcess.size) {
        3 -> "${stringInProcess[0]}, ${stringInProcess[2]}"
        1 -> stringInProcess[0]
        else -> this
    }
}