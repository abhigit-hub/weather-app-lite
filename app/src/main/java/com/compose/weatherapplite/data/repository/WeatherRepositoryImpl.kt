package com.compose.weatherapplite.data.repository

import com.compose.weatherapplite.data.mapper.toWeatherInfo
import com.compose.weatherapplite.data.remote.WeatherApi
import com.compose.weatherapplite.domain.model.WeatherInfo
import com.compose.weatherapplite.domain.repository.WeatherRepository
import com.compose.weatherapplite.utils.Resource
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {
    override suspend fun getWeatherForecastAndCurrent(
        latitude: String,
        longitude: String
    ): Resource<WeatherInfo> {
        return try {
            val response = api.getForecastAndCurrentWeather(latitude, longitude)
            val data = response.toWeatherInfo()
            Resource.Success(data = data)
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Error("Failed api request")
        }
    }

}