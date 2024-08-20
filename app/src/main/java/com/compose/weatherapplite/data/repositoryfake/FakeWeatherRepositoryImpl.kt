package com.compose.weatherapplite.data.repositoryfake

import com.compose.weatherapplite.data.mapper.toGeoCodingInfo
import com.compose.weatherapplite.domain.model.GeoCodingInfo
import com.compose.weatherapplite.domain.model.WeatherInfo
import com.compose.weatherapplite.domain.repository.WeatherRepository
import com.compose.weatherapplite.utils.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeWeatherRepositoryImpl @Inject constructor() : WeatherRepository {

    override suspend fun getWeatherForecastAndCurrent(
        latitude: String,
        longitude: String
    ): Resource<WeatherInfo> {
        val weatherInfo = WeatherInfo(
            latitude = fakeLocationLatitude(),
            longitude = fakeLocationLongitude(),
            currentUnit = fakeCurrentUnitInfo(),
            current = fakeCurrentInfo(),
            hourlyUnit = fakeHourlyUnitInfo(),
            hourly = fakeHourlyInfo()
        )

        return Resource.Success(data = weatherInfo)
    }

    override suspend fun getLocalityBasedOnCoordinates(
        latitude: String,
        longitude: String
    ): Resource<GeoCodingInfo> {
        return Resource.Success(data = getFakeGeoCodingLocationBangalore().toGeoCodingInfo())
    }
}
