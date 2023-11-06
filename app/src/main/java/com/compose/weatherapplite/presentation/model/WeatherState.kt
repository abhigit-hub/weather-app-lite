package com.compose.weatherapplite.presentation.model

import java.time.LocalDateTime

data class WeatherState(
    val locationState: LocationState,
    val currentWeatherState: CurrentWeatherState,
    val tomorrowWeatherItemListState: List<WeatherItemMetaState>,
    val nextTenDaysWeatherItemListState: List<WeatherItemMetaState>,
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
    val rain: String,
    val todaysWeatherItemListState: List<WeatherItemMetaState>
)

data class WeatherItemMetaState(
    val time: LocalDateTime,
    val temperature: String,
    val weatherCode: WeatherType
)