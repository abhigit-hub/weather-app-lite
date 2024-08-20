package com.compose.weatherapplite.utils

import com.compose.weatherapplite.utils.WeatherAppConstants.CITY_NAME_DELIMITER
import com.compose.weatherapplite.utils.WeatherAppConstants.CITY_NAME_LIST_SIZE_MAX
import com.compose.weatherapplite.utils.WeatherAppConstants.CITY_NAME_LIST_SIZE_MIN
import com.compose.weatherapplite.utils.WeatherAppConstants.KEY_ANTE_MERIDIEM
import com.compose.weatherapplite.utils.WeatherAppConstants.KEY_POST_MERIDIEM
import com.compose.weatherapplite.utils.WeatherAppConstants.PATTERN_FOR_LOCAL_DATE_TIME
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
    val ampm = if (hour >= TIME_12_HOUR_FORMAT) KEY_POST_MERIDIEM else KEY_ANTE_MERIDIEM
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
    val formatter = DateTimeFormatter.ofPattern(PATTERN_FOR_LOCAL_DATE_TIME)
    return LocalDateTime.parse(this, formatter)
}

fun LocalDate.toDayOfWeek(): String {
    return if (this.isEqual(LocalDate.now())) {
        WeatherAppConstants.DAY_OF_WEEK_TODAY
    } else {
        dayOfWeek.toString().lowercase().capitalize()
    }
}

fun String.toShortenedCityName(): String {
    val stringInProcess = this.split(CITY_NAME_DELIMITER)

    return when (stringInProcess.size) {
        CITY_NAME_LIST_SIZE_MAX -> "${stringInProcess[0].trim()}, ${stringInProcess[2].trim()}"
        CITY_NAME_LIST_SIZE_MIN -> stringInProcess[0].trim()
        else -> this
    }
}

fun LocalDate.checkIfDateRangeMatches(
    filterDate1: LocalDate,
    filterDate2: LocalDate
): Boolean {
    return this.isAfter(filterDate1) && this.isBefore(filterDate2)
}

fun LocalDate.checkIfDateMatches(filterDate: LocalDate): Boolean {
    return this.isEqual(filterDate)
}
