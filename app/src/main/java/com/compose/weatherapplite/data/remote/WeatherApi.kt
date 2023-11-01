package com.compose.weatherapplite.data.remote

import com.compose.weatherapplite.data.remote.dto.CurrentWeatherDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    companion object {
        const val BASE_URL = "https://api.open-meteo.com/v1/forecast"
    }

    @GET("current=temperature_2m,windspeed_10m&hourly=temperature_2m,relativehumidity_2m,windspeed_10m&")
    suspend fun getForecastAndCurrentWeather(
        @Query("latitude") latitude: String,
        @Query("longitude") longitude: String
    ): CurrentWeatherDTO

    @GET("past_days=10&hourly=temperature_2m,relativehumidity_2m,windspeed_10m&")
    suspend fun getRecentPastWeather(
        @Query("latitude") latitude: String,
        @Query("longitude") longitude: String
    ): CurrentWeatherDTO
}