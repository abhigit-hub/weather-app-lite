package com.compose.weatherapplite.presentation.model

sealed class WeatherMenuSelectorType(val weatherType: String) {
    object WeatherMenuSelectorTypeToday: WeatherMenuSelectorType("Today")
    object WeatherMenuSelectorTypeTomorrow: WeatherMenuSelectorType("Tomorrow")
    object WeatherMenuSelectorTypeNextTenDays: WeatherMenuSelectorType("Next 10 days")
}