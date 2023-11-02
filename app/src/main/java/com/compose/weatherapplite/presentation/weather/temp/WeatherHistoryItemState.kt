package com.compose.weatherapplite.presentation.weather.temp

import androidx.annotation.DrawableRes

data class WeatherHistoryItemState(
    val time: String,
    @DrawableRes val drawable: Int,
    val temperature: String
)
