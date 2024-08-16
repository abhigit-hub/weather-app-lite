package com.compose.weatherapplite.data.repository

import android.util.Log
import com.compose.weatherapplite.data.mapper.toGeoCodingInfo
import com.compose.weatherapplite.data.mapper.toWeatherInfo
import com.compose.weatherapplite.data.remote.GeoCodingApi
import com.compose.weatherapplite.data.remote.WeatherApi
import com.compose.weatherapplite.domain.model.GeoCodingInfo
import com.compose.weatherapplite.domain.model.WeatherInfo
import com.compose.weatherapplite.domain.repository.WeatherRepository
import com.compose.weatherapplite.utils.Resource
import javax.inject.Inject
import javax.inject.Singleton
import retrofit2.HttpException

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    private val geoCodingApi: GeoCodingApi
) : WeatherRepository {
    companion object {
        private val TAG = WeatherRepositoryImpl::class.java.simpleName
    }

    override suspend fun getWeatherForecastAndCurrent(
        latitude: String,
        longitude: String
    ): Resource<WeatherInfo> {
        return try {
            Log.d(
                TAG,
                "REQ ==> getWeatherForecastAndCurrent() ==> (latitude = $latitude," +
                    " longitude = $longitude)"
            )
            val response = weatherApi.getForecastAndCurrentWeather(latitude, longitude)
            Log.d(TAG, "RESP <== getWeatherForecastAndCurrent() <== $response)")

            val data = response.toWeatherInfo()
            Resource.Success(data = data)
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Error("Failed api request")
        }
    }

    override suspend fun getLocalityBasedOnCoordinates(
        latitude: String,
        longitude: String
    ): Resource<GeoCodingInfo> {
        return try {
            val latlng = "$latitude,$longitude"

            Log.d(TAG, "REQ ==> fetchLocalityBasedOnCoordinates() ==> (address = $latlng)")
            val response = geoCodingApi.getLocalityFromCoordinatesUsingGeoCodingApi(latLng = latlng)
            Log.d(TAG, "RESP <== fetchLocalityBasedOnCoordinates() <== (response = $response)")

            val data = response.toGeoCodingInfo()
            Resource.Success(data = data)
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Error("Failed api request")
        }
    }
}
