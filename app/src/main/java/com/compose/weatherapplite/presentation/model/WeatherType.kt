package com.compose.weatherapplite.presentation.model

sealed class WeatherType(val weatherType: String) {
    data object Unknown: WeatherType("Unknown")
    data object ClearSky: WeatherType("Clear Sky")
    data object Overcast: WeatherType("Overcast")
    data object Foggy: WeatherType("Foggy")
    data object Drizzle: WeatherType("Drizzle")
    data object Rain: WeatherType("Rain")
    data object HeavyRain: WeatherType("Heavy Rain")
    data object SnowFall: WeatherType("Snow Fall")
    data object Thunderstorm: WeatherType("Thunderstorm")
}

fun WeatherType.isUnknownWeather(): Boolean =
    this == WeatherType.Unknown