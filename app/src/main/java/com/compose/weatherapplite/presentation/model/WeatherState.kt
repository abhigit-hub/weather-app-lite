package com.compose.weatherapplite.presentation.model

import java.time.LocalDate
import java.time.LocalDateTime

data class WeatherState(
    val weatherMenuSelectorType: WeatherMenuSelectorType = WeatherMenuSelectorType.WeatherMenuSelectorTypeToday,
    val locationState: LocationState = LocationState(),
    val currentWeatherState: CurrentWeatherState = CurrentWeatherState(),
    val tomorrowWeatherItemListState: List<WeatherItemMetaState> = emptyList(),
    val nextTenDaysWeatherItemListState: List<WeatherItemMetaState> = emptyList(),
    val nextTenDaysWeatherDetailsItemListState: List<WeatherDetailsItemMetaState> = emptyList(),
)

data class LocationState(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val cityName: String = "",
    val cityShortenedName: String = "",
)

data class CurrentWeatherState(
    val date: String = "",
    val weatherType: WeatherType = WeatherType.Unknown,
    val temperature: String = "",
    val wind: String = "",
    val humidity: String = "",
    val rain: String = "",
    val todaysWeatherItemListState: List<WeatherItemMetaState> = emptyList()
)

data class WeatherItemMetaState(
    val time: LocalDateTime,
    val temperature: String,
    val weatherCode: WeatherType
)

data class WeatherDetailsItemMetaState(
    val time: LocalDate,
    var minTemperature: String,
    var maxTemperature: String,
    var weatherCode: WeatherType
)