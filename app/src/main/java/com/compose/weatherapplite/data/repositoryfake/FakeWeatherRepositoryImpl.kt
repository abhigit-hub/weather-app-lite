package com.compose.weatherapplite.data.repositoryfake

import com.compose.weatherapplite.data.mapper.toGeoCodingInfo
import com.compose.weatherapplite.domain.model.CurrentInfo
import com.compose.weatherapplite.domain.model.CurrentUnitInfo
import com.compose.weatherapplite.domain.model.GeoCodingInfo
import com.compose.weatherapplite.domain.model.HourlyInfo
import com.compose.weatherapplite.domain.model.HourlyUnitInfo
import com.compose.weatherapplite.domain.model.WeatherInfo
import com.compose.weatherapplite.domain.repository.WeatherRepository
import com.compose.weatherapplite.utils.Resource
import com.compose.weatherapplite.utils.toLocalDate
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeWeatherRepositoryImpl @Inject constructor() : WeatherRepository {

    override suspend fun getWeatherForecastAndCurrent(
        latitude: String,
        longitude: String
    ): Resource<WeatherInfo> {
        val weatherInfo = WeatherInfo(
            latitude = 12.9737,
            longitude = 77.7007,
            currentUnit = CurrentUnitInfo(
                time = "iso8601",
                interval = "seconds",
                temperature = "°C",
                windspeed = "km/h"
            ),
            current = CurrentInfo(
                time = "2024-11-01T07:30",
                interval = 900,
                temperature = 7.8,
                windspeed = 8.1,
                weatherCode = 3
            ),
            hourlyUnit = HourlyUnitInfo(
                time = "iso8601",
                temperature = "°C",
                humidity = "%",
                windspeed = "km/h"
            ),
            hourly = HourlyInfo(
                time = fakeTimeList.map { it.toLocalDate() },
                temperature = fakeTemperatureList,
                humidity = fakeHumidityList,
                windspeed = fakeWindspeedList,
                weatherCodes = fakeWeatherCodeList
            )
        )

        return Resource.Success(data = weatherInfo)
    }

    override suspend fun getLocalityBasedOnCoordinates(
        latitude: String,
        longitude: String
    ): Resource<GeoCodingInfo> {
        return Resource.Success(data = fakeGeoCodingLocationBangalore.toGeoCodingInfo())
    }

    companion object {
        val fakeTimeList = getFakeTimeList()
        val fakeTemperatureList = getFakeTemperatureList()
        val fakeHumidityList = getFakeHumidityList()
        val fakeWindspeedList = getFakeWindspeedList()
        val fakeWeatherCodeList = getFakeWeatherCodeList()

        val fakeGeoCodingLocationPune = getFakeGeoCodingLocationPune()
        val fakeGeoCodingLocationBangalore = getFakeGeoCodingLocationBangalore()
    }
}
