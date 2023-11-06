package com.compose.weatherapplite.data.mapper

import com.compose.weatherapplite.data.remote.dto.CurrentDTO
import com.compose.weatherapplite.data.remote.dto.CurrentUnitDTO
import com.compose.weatherapplite.data.remote.dto.HourlyDTO
import com.compose.weatherapplite.data.remote.dto.HourlyUnitDTO
import com.compose.weatherapplite.data.remote.dto.WeatherDTO
import com.compose.weatherapplite.domain.model.CurrentInfo
import com.compose.weatherapplite.domain.model.CurrentUnitInfo
import com.compose.weatherapplite.domain.model.HourlyInfo
import com.compose.weatherapplite.domain.model.HourlyUnitInfo
import com.compose.weatherapplite.domain.model.WeatherInfo
import com.compose.weatherapplite.utils.toLocalDate

fun WeatherDTO.toWeatherInfo(): WeatherInfo {
    return WeatherInfo(
        latitude = latitude,
        longitude = longitude,
        current = currentDTO.toCurrentInfo(),
        currentUnit = currentUnitDTO.toCurrentUnitInfo(),
        hourly = hourlyDTO.toHourlyInfo(),
        hourlyUnit = hourlyUnitDTO.toHourlyUnitInfo()
    )
}

fun CurrentDTO.toCurrentInfo(): CurrentInfo {
    return CurrentInfo(
        time = time,
        interval = interval,
        temperature = temperature,
        windspeed = windspeed,
        weatherCode = weathercode
    )
}

fun CurrentUnitDTO.toCurrentUnitInfo(): CurrentUnitInfo {
    return CurrentUnitInfo(
        time = time,
        interval = interval,
        temperature = temperature,
        windspeed = windspeed
    )
}

fun HourlyDTO.toHourlyInfo(): HourlyInfo {
    return HourlyInfo(
        time = time.map { it.toLocalDate() },
        temperature = temperature,
        humidity = humidity,
        windspeed = windspeed,
        weatherCodes = weathercodes
    )
}

fun HourlyUnitDTO.toHourlyUnitInfo(): HourlyUnitInfo {
    return HourlyUnitInfo(
        time = time,
        temperature = temperature,
        humidity = humidity,
        windspeed = windspeed
    )
}