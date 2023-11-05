package com.compose.weatherapplite.presentation.weather

import com.compose.weatherapplite.presentation.weather.temp.WeatherType

data class WeatherState(
    val latitude: Double,
    val longitude: Double,
    val currentUnit: CurrentUnitState,
    val current: CurrentState,
    val hourlyUnit: HourlyUnitState,
    val hourly: HourlyState
)

data class CurrentUnitState(
    val time: String,
    val interval: String,
    val temperature: String,
    val windspeed: String,
)

data class HourlyUnitState(
    val time: String,
    val temperature: String,
    val humidity: String,
    val windspeed: String,
)

data class CurrentState(
    val time: String,
    val interval: Int,
    val temperature: Double,
    val windspeed: Double,
    val weatherType: WeatherType
)

data class HourlyState(
    val time: List<String>,
    val temperature: List<Double>,
    val humidity: List<Int>,
    val windspeed: List<Double>,
    val weatherType: List<WeatherType>
)