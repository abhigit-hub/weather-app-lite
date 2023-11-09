package com.compose.weatherapplite.domain.repository

import com.compose.weatherapplite.domain.model.GeoCodingInfo
import com.compose.weatherapplite.domain.model.WeatherInfo
import com.compose.weatherapplite.utils.Resource

interface WeatherRepository {
    suspend fun getWeatherForecastAndCurrent(
        latitude: String,
        longitude: String
    ): Resource<WeatherInfo>

    suspend fun getLocalityBasedOnCoordinates(
        latitude: String,
        longitude: String
    ): Resource<GeoCodingInfo>
}