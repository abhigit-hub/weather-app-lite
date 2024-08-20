package com.compose.weatherapplite.presentation.model

import com.compose.weatherapplite.utils.WeatherAppConstants

sealed class WeatherMenuSelectorType(val weatherType: String) {
    data object WeatherMenuSelectorTypeToday : WeatherMenuSelectorType(
        WeatherAppConstants.WEATHER_MENU_SELECTOR_1
    )
    data object WeatherMenuSelectorTypeTomorrow : WeatherMenuSelectorType(
        WeatherAppConstants.WEATHER_MENU_SELECTOR_2
    )
    data object WeatherMenuSelectorTypeNextTenDays : WeatherMenuSelectorType(
        WeatherAppConstants.WEATHER_MENU_SELECTOR_3
    )
}
