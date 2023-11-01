package com.compose.weatherapplite.presentation.weather

import com.compose.weatherapplite.domain.model.CurrentInfo
import com.compose.weatherapplite.domain.model.CurrentUnitInfo
import com.compose.weatherapplite.domain.model.HourlyInfo
import com.compose.weatherapplite.domain.model.HourlyUnitInfo
import com.compose.weatherapplite.domain.model.WeatherInfo

fun WeatherInfo.toWeatherState(): WeatherState {
    return WeatherState(
        latitude = latitude,
        longitude = longitude,
        current = current.toCurrent(),
        currentUnit = currentUnit.toCurrentUnit(),
        hourly = hourly.toHourly(),
        hourlyUnit = hourlyUnit.toHourlyUnit()
    )
}

fun CurrentInfo.toCurrent(): CurrentState {
    return CurrentState(
        time = time,
        interval = interval,
        temperature = temperature,
        windspeed = windspeed
    )
}

fun CurrentUnitInfo.toCurrentUnit(): CurrentUnitState {
    return CurrentUnitState(
        time = time,
        interval = interval,
        temperature = temperature,
        windspeed = windspeed
    )
}

fun HourlyInfo.toHourly(): HourlyState {
    return HourlyState(
        time = time,
        temperature = temperature,
        humidity = humidity,
        windspeed = windspeed
    )
}

fun HourlyUnitInfo.toHourlyUnit(): HourlyUnitState {
    return HourlyUnitState(
        time = time,
        temperature = temperature,
        humidity = humidity,
        windspeed = windspeed
    )
}