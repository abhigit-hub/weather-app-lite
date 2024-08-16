package com.compose.weatherapplite.presentation.mapper

import com.compose.weatherapplite.domain.model.HourlyInfo
import com.compose.weatherapplite.domain.model.WeatherInfo
import com.compose.weatherapplite.presentation.model.CurrentWeatherState
import com.compose.weatherapplite.presentation.model.LocationState
import com.compose.weatherapplite.presentation.model.WeatherDetailsItemMetaState
import com.compose.weatherapplite.presentation.model.WeatherItemMetaState
import com.compose.weatherapplite.presentation.model.WeatherMenuSelectorType
import com.compose.weatherapplite.presentation.model.WeatherState
import com.compose.weatherapplite.presentation.model.WeatherType
import com.compose.weatherapplite.utils.convertToWeatherAppLiteDate
import java.time.LocalDate
import java.time.LocalDateTime

fun WeatherInfo.toWeatherState(): WeatherState {
    return WeatherState(
        locationState = this.toLocationState(),
        currentWeatherState = this.toCurrentWeatherState(),
        tomorrowWeatherItemListState = this.hourly.toWeatherItemListState(
            WeatherMenuSelectorType.WeatherMenuSelectorTypeTomorrow
        ),
        nextTenDaysWeatherItemListState = this.hourly.toWeatherItemListState(
            WeatherMenuSelectorType.WeatherMenuSelectorTypeNextTenDays
        ),
        nextTenDaysWeatherDetailsItemListState = this.hourly.toWeatherDetailsItemListState()
    )
}

fun WeatherInfo.toLocationState(): LocationState {
    return LocationState(
        latitude = latitude,
        longitude = longitude,

        cityName = "Berlin, Germany"
    )
}

fun WeatherInfo.toCurrentWeatherState(): CurrentWeatherState {
    return CurrentWeatherState(
        date = LocalDate.now().convertToWeatherAppLiteDate(),
        weatherType = current.weatherCode.toWeatherType(),
        temperature = "${current.temperature}${currentUnit.temperature}",
        wind = "${current.windspeed} ${currentUnit.windspeed}",
        humidity = "${hourly.humidity[0]}%",
        rain = "${current.weatherCode.toRainLevel()}%",
        todaysWeatherItemListState = hourly.toWeatherItemListState(
            WeatherMenuSelectorType.WeatherMenuSelectorTypeToday
        )
    )
}

fun HourlyInfo.toWeatherDetailsItemListState(): List<WeatherDetailsItemMetaState> {
    val weatherDetailsItemMetaStateList = mutableListOf<WeatherDetailsItemMetaState>()

    var lastKnownWeatherDetailsItemMetaState: WeatherDetailsItemMetaState? = null
    var lastKnownMinTemperature: Double = -1.0
    var lastKnownMaxTemperature: Double = -1.0

    time.forEachIndexed { index, localDateTime ->
        if (lastKnownWeatherDetailsItemMetaState == null) {
            lastKnownWeatherDetailsItemMetaState = WeatherDetailsItemMetaState(
                time = time[index].toLocalDate(),
                weatherCode = weatherCodes[index].toWeatherType(),
                minTemperature = "0",
                maxTemperature = "0"
            )
            return@forEachIndexed
        }

        if (time[index].toLocalDate().equals(lastKnownWeatherDetailsItemMetaState?.time)) {
            if (temperature[index] < lastKnownMinTemperature || lastKnownMinTemperature == -1.0) {
                lastKnownMinTemperature = temperature[index]
            }
            if (temperature[index] > lastKnownMaxTemperature || lastKnownMaxTemperature == -1.0) {
                lastKnownMaxTemperature = temperature[index]
            }
            if ((index % 12) == 0 && (index / 12) % 2 == 1) {
                lastKnownWeatherDetailsItemMetaState!!.weatherCode =
                    weatherCodes[index].toWeatherType()
            }

            if (index != time.size - 1) return@forEachIndexed
        }

        lastKnownWeatherDetailsItemMetaState!!.minTemperature = "$lastKnownMinTemperature°"
        lastKnownWeatherDetailsItemMetaState!!.maxTemperature = "$lastKnownMaxTemperature°"
        weatherDetailsItemMetaStateList.add(lastKnownWeatherDetailsItemMetaState!!)

        lastKnownWeatherDetailsItemMetaState = null
        lastKnownMinTemperature = -1.0
        lastKnownMaxTemperature = -1.0
    }

    return weatherDetailsItemMetaStateList
}

fun HourlyInfo.toWeatherItemListState(
    weatherMenuSelectorType: WeatherMenuSelectorType
): List<WeatherItemMetaState> {
    val weatherItemList = mutableListOf<WeatherItemMetaState>()

    time.forEachIndexed { index, dateToBeChecked ->
        if (checkDates(weatherMenuSelectorType, dateToBeChecked)) {
            weatherItemList.add(
                WeatherItemMetaState(
                    time = time[index],
                    temperature = temperature[index].toString(),
                    weatherCode = weatherCodes[index].toWeatherType()
                )
            )
        }
    }

    return weatherItemList
}

private fun checkDates(
    weatherMenuSelectorType: WeatherMenuSelectorType,
    dateToBeChecked: LocalDateTime
): Boolean {
    val filterDate: LocalDate = when (weatherMenuSelectorType) {
        WeatherMenuSelectorType.WeatherMenuSelectorTypeToday -> {
            LocalDate.now()
        }

        WeatherMenuSelectorType.WeatherMenuSelectorTypeTomorrow -> {
            LocalDate.now().plusDays(1)
        }

        WeatherMenuSelectorType.WeatherMenuSelectorTypeNextTenDays -> {
            LocalDate.now().plusDays(10)
        }
    }

    return when (weatherMenuSelectorType) {
        WeatherMenuSelectorType.WeatherMenuSelectorTypeToday,
        WeatherMenuSelectorType.WeatherMenuSelectorTypeTomorrow -> {
            checkIfDateMatches(localDate = dateToBeChecked.toLocalDate(), filterDate = filterDate)
        }

        WeatherMenuSelectorType.WeatherMenuSelectorTypeNextTenDays -> {
            checkIfDateRangeMatches(
                localDate = dateToBeChecked.toLocalDate(),
                filterDate1 = LocalDate.now(),
                filterDate2 = filterDate
            )
        }
    }
}

private fun checkIfDateMatches(localDate: LocalDate, filterDate: LocalDate): Boolean {
    return localDate.isEqual(filterDate)
}

private fun checkIfDateRangeMatches(
    localDate: LocalDate,
    filterDate1: LocalDate,
    filterDate2: LocalDate
): Boolean {
    return localDate.isAfter(filterDate1) && localDate.isBefore(filterDate2)
}

fun Int.toWeatherType(): WeatherType {
    return when (this) {
        0 -> WeatherType.ClearSky
        1, 2, 3 -> WeatherType.Overcast
        45, 48 -> WeatherType.Foggy
        51, 53, 55, 56, 57 -> WeatherType.Drizzle
        61, 63, 65 -> WeatherType.Rain
        66, 67 -> WeatherType.HeavyRain
        71, 73, 75 -> WeatherType.SnowFall
        95, 96, 99 -> WeatherType.Thunderstorm
        else -> WeatherType.ClearSky
    }
}

fun Int.toRainLevel(): Int {
    return when (this) {
        0 -> 0
        1, 2, 3 -> 10
        45, 48 -> 0
        51, 53, 55, 56, 57 -> 30
        61, 63, 65 -> 60
        66, 67 -> 100
        71, 73, 75 -> 10
        95, 96, 99 -> 80
        else -> 0
    }
}
