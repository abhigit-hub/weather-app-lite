package com.compose.weatherapplite.presentation.weather.temp

sealed class WeatherType(val weatherType: String) {
    object ClearSky: WeatherType("Clear Sky")
    object Overcast: WeatherType("Overcast")
    object Foggy: WeatherType("Foggy")
    object Drizzle: WeatherType("Drizzle")
    object Rain: WeatherType("Rain")
    object HeavyRain: WeatherType("Heavy Rain")
    object SnowFall: WeatherType("Snow Fall")
    object Thunderstorm: WeatherType("Thunderstorm")
}