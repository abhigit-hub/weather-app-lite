package com.compose.weatherapplite.presentation.weather

import com.compose.weatherapplite.presentation.weather.temp.WeatherType

data class WeatherTempState(
    val latitude: String,
    val longitude: String,
    val city: String,
    val currentDate: String,
    val currentTemp: String,
    val currentWeather: String,
    val currentWeatherType: WeatherType,
    val currentWind: String,
    val currentHumidity: String,
    val currentRain: String
)