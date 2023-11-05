package com.compose.weatherapplite.presentation.weather

import com.compose.weatherapplite.domain.model.CurrentInfo
import com.compose.weatherapplite.domain.model.CurrentUnitInfo
import com.compose.weatherapplite.domain.model.HourlyInfo
import com.compose.weatherapplite.domain.model.HourlyUnitInfo
import com.compose.weatherapplite.domain.model.WeatherInfo
import com.compose.weatherapplite.presentation.weather.temp.WeatherType

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
        windspeed = windspeed,
        weatherType = weatherCode.toWeatherType()
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
        windspeed = windspeed,
        weatherType = weatherCodes.toWeatherTypeList()
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

fun List<Int>.toWeatherTypeList(): List<WeatherType> {
    return this.map { it.toWeatherType() }
}