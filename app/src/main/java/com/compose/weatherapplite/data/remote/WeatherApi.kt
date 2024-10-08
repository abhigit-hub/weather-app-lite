package com.compose.weatherapplite.data.remote

import com.compose.weatherapplite.data.remote.dto.WeatherDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    companion object {
        const val BASE_URL_WEATHER = "https://api.open-meteo.com/v1/"
        const val ADDITIONAL_QUERY_PARAMS_FOR_CURRENT_WEATHER =
            "current=temperature_2m,windspeed_10m,weathercode&hourly=temperature_2m," +
                "relativehumidity_2m,windspeed_10m,weathercode"
    }

    @GET("forecast?$ADDITIONAL_QUERY_PARAMS_FOR_CURRENT_WEATHER")
    suspend fun getForecastAndCurrentWeather(
        @Query("latitude") latitude: String,
        @Query("longitude") longitude: String
    ): WeatherDTO
}
