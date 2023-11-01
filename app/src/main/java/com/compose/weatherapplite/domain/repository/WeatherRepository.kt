package com.compose.weatherapplite.domain.repository

import com.compose.weatherapplite.domain.model.WeatherInfo
import com.compose.weatherapplite.utils.Resource

interface WeatherRepository {
    suspend fun getWeatherForecastAndCurrent(
        latitude: String,
        longitude: String
    ): Resource<WeatherInfo>
}