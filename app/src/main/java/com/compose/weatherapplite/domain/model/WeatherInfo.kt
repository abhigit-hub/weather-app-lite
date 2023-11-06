package com.compose.weatherapplite.domain.model

import java.time.LocalDateTime

data class WeatherInfo(
    val latitude: Double,
    val longitude: Double,
    val currentUnit: CurrentUnitInfo,
    val current: CurrentInfo,
    val hourlyUnit: HourlyUnitInfo,
    val hourly: HourlyInfo
)

data class CurrentUnitInfo(
    val time: String,
    val interval: String,
    val temperature: String,
    val windspeed: String,
)

data class HourlyUnitInfo(
    val time: String,
    val temperature: String,
    val humidity: String,
    val windspeed: String,
)

data class CurrentInfo(
    val time: String,
    val interval: Int,
    val temperature: Double,
    val windspeed: Double,
    val weatherCode: Int
)

data class HourlyInfo(
    val time: List<LocalDateTime>,
    val temperature: List<Double>,
    val humidity: List<Int>,
    val windspeed: List<Double>,
    val weatherCodes: List<Int>
)