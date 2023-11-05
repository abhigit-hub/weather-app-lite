package com.compose.weatherapplite.presentation.model

data class WeatherState(
    val locationState: LocationState,
    val currentWeatherState: CurrentWeatherState,
    val pastDatedWeatherListState: List<PastDatedWeatherState>,
    val pastDatedWeatherStateComplete: PastDatedWeatherStateComplete
)

data class LocationState(
    val latitude: Double,
    val longitude: Double,
    val cityName: String
)

data class CurrentWeatherState(
    val date: String,
    val weatherType: WeatherType,
    val temperature: String,
    val wind: String,
    val humidity: String,
    val rain: String
)

data class PastDatedWeatherStateComplete(
    val time: List<String>,
    val temperature: List<Double>,
    val humidity: List<Int>,
    val windspeed: List<Double>,
    val weatherCodes: List<WeatherType>
)

data class PastDatedWeatherState(
    val time: String,
    val temperature: String,
    val weatherCode: WeatherType
)