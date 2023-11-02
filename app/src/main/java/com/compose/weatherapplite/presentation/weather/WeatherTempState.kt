package com.compose.weatherapplite.presentation.weather

data class WeatherTempState(
    val latitude: String,
    val longitude: String,
    val city: String,
    val currentDate: String,
    val currentTemp: String,
    val currentWeather: String,
    val currentWind: String,
    val currentHumidity: String,
    val currentRain: String
)