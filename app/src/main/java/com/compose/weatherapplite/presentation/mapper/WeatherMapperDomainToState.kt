package com.compose.weatherapplite.presentation.mapper

import com.compose.weatherapplite.domain.model.WeatherInfo
import com.compose.weatherapplite.presentation.model.CurrentWeatherState
import com.compose.weatherapplite.presentation.model.LocationState
import com.compose.weatherapplite.presentation.model.PastDatedWeatherState
import com.compose.weatherapplite.presentation.model.PastDatedWeatherStateComplete
import com.compose.weatherapplite.presentation.model.WeatherState
import com.compose.weatherapplite.presentation.model.WeatherType
import com.compose.weatherapplite.utils.convertToWeatherAppLiteDate
import java.time.LocalDate

fun WeatherInfo.toWeatherState(): WeatherState {
    return WeatherState(
        locationState = this.toLocationState(),
        currentWeatherState = this.toCurrentWeatherState(),
        pastDatedWeatherListState = this.toPastDatedWeatherListState(),
        pastDatedWeatherStateComplete = this.toPastDatedWeatherState()
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
        rain = "${current.weatherCode.toRainLevel()}%"
    )
}

fun WeatherInfo.toPastDatedWeatherState(): PastDatedWeatherStateComplete {
    return PastDatedWeatherStateComplete(
        time = hourly.time,
        temperature = hourly.temperature,
        humidity = hourly.humidity,
        windspeed = hourly.windspeed,
        weatherCodes = hourly.weatherCodes.toWeatherTypeList()
    )
}

fun WeatherInfo.toPastDatedWeatherListState(): List<PastDatedWeatherState> {
    val pastDatedWeatherListState = mutableListOf<PastDatedWeatherState>()

    for (index in 0..hourly.weatherCodes.size - 1) {
        val pastDatedWeatherState = PastDatedWeatherState(
            time = hourly.time[index],
            temperature = hourly.temperature[index].toString(),
            weatherCode = hourly.weatherCodes[index].toWeatherType(),
        )
        pastDatedWeatherListState.add(pastDatedWeatherState)
    }

    return pastDatedWeatherListState
}

fun Int.toWeatherType(): WeatherType {
    return when (this) {
        0 -> WeatherType.ClearSky
        1,2,3 -> WeatherType.Overcast
        45,48 -> WeatherType.Foggy
        51,53,55,56,57 -> WeatherType.Drizzle
        61,63,65 -> WeatherType.Rain
        66,67 -> WeatherType.HeavyRain
        71,73,75 -> WeatherType.SnowFall
        95,96,99 -> WeatherType.Thunderstorm
        else -> WeatherType.ClearSky
    }
}

fun Int.toRainLevel(): Int {
    return when (this) {
        0 -> 0
        1,2,3 -> 10
        45,48 -> 0
        51,53,55,56,57 -> 30
        61,63,65 -> 60
        66,67 -> 100
        71,73,75 -> 10
        95,96,99 -> 80
        else -> 0
    }
}

fun List<Int>.toWeatherTypeList(): List<WeatherType> {
    return this.map { it.toWeatherType() }
}