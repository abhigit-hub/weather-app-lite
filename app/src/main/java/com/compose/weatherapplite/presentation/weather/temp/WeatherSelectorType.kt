package com.compose.weatherapplite.presentation.weather.temp

sealed class WeatherSelectorType(val weatherType: String) {
    object WeatherSelectorTypeToday: WeatherSelectorType("Today")
    object WeatherSelectorTypeTomorrow: WeatherSelectorType("Tomorrow")
    object WeatherSelectorTypeNextTenDays: WeatherSelectorType("Next 10 days")
}