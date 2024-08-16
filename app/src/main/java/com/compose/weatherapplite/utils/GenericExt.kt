package com.compose.weatherapplite.utils

import com.compose.weatherapplite.utils.WeatherAppConstants.CITY_NAME_DELIMITER
import com.compose.weatherapplite.utils.WeatherAppConstants.CITY_NAME_LIST_SIZE_MAX
import com.compose.weatherapplite.utils.WeatherAppConstants.CITY_NAME_LIST_SIZE_MIN
import com.compose.weatherapplite.utils.WeatherAppConstants.TIME_12_HOUR_FORMAT
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
    val ampm = if (hour >= TIME_12_HOUR_FORMAT) "pm" else "am"
    val finalTime = if (hour > TIME_12_HOUR_FORMAT) {
        hour - TIME_12_HOUR_FORMAT
    } else if (hour == 0) {
        TIME_12_HOUR_FORMAT
    } else {
        hour
    }

    return "$finalTime $ampm"
}

fun String.toLocalDate(): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    return LocalDateTime.parse(this, formatter)
}

fun LocalDate.toDayOfWeek(): String {
    return if (this.isEqual(LocalDate.now())) {
        "Today"
    } else {
        dayOfWeek.toString().lowercase().capitalize()
    }
}

fun String.toShortenedCityName(): String {
    val stringInProcess = this.split(CITY_NAME_DELIMITER)

    return when (stringInProcess.size) {
        CITY_NAME_LIST_SIZE_MAX -> "${stringInProcess[0]}, ${stringInProcess[2]}"
        CITY_NAME_LIST_SIZE_MIN -> stringInProcess[0]
        else -> this
    }
}
