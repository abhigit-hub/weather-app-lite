package com.compose.weatherapplite.presentation.weather

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.weatherapplite.domain.model.GeoCodingInfo
import com.compose.weatherapplite.domain.model.WeatherInfo
import com.compose.weatherapplite.domain.repository.WeatherRepository
import com.compose.weatherapplite.manager.WeatherLocationManager
import com.compose.weatherapplite.presentation.mapper.toGeoCodingState
import com.compose.weatherapplite.presentation.mapper.toWeatherState
import com.compose.weatherapplite.presentation.model.WeatherMenuSelectorType
import com.compose.weatherapplite.presentation.model.WeatherState
import com.compose.weatherapplite.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val weatherLocationManager: WeatherLocationManager
): ViewModel() {

    companion object {
        val TAG: String = WeatherViewModel::class.java.simpleName
    }

    var state by mutableStateOf(WeatherState())
    var firstTimeRequest = AtomicBoolean(false)

    fun initiateApiRequest(latitude: Double, longitude: Double) {
        Log.d(TAG, "initiateApiRequest() ==> (latitude = $latitude, longitude = $longitude)")
        viewModelScope.launch {
            var responseForWeatherApi: Resource<WeatherInfo>
            var responseForGeoCodingApi: Resource<GeoCodingInfo>

            val callWeatherApi = async {
                repository.getWeatherForecastAndCurrent(
                    latitude = latitude.toString(),
                    longitude = longitude.toString()
                )
            }

            val callGeoCodingApi = async {
                repository.getLocalityBasedOnCoordinates(
                    latitude = latitude.toString(),
                    longitude = longitude.toString()
                )
            }

            try {
                responseForWeatherApi = callWeatherApi.await()
                processWeatherApiResponse(responseForWeatherApi)
            } catch (e: HttpException) {
                Log.d(TAG, "Weather API Response: Error ==>")
                e.printStackTrace()
            }

            try {
                responseForGeoCodingApi = callGeoCodingApi.await()
                processGeoCodingApiResponse(responseForGeoCodingApi)
            } catch (e: HttpException) {
                Log.d(TAG, "GeoCoding API Response: Error ==>")
                e.printStackTrace()
            }
        }
    }

    private fun processGeoCodingApiResponse(responseForGeoCodingApi: Resource<GeoCodingInfo>) {
        when (responseForGeoCodingApi) {
            is Resource.Success -> {
                responseForGeoCodingApi.data?.let { geoCodingInfo ->
                    Log.d(TAG, "API Response: Success ==>")
                    Log.d(TAG, geoCodingInfo.cityName)

                    val geoCodingState = geoCodingInfo.toGeoCodingState()

                    state = state.copy(
                        locationState = state.locationState.copy(
                            cityName = geoCodingState.cityName,
                            cityShortenedName = geoCodingState.cityShortenedName
                        )
                    )
                }
            }

            is Resource.Error -> {
                Log.d(TAG, "API Response: Error ==>")
                Log.d(TAG, "${responseForGeoCodingApi.message}")
            }

            else -> Unit
        }
    }

    private fun processWeatherApiResponse(responseForWeatherApi: Resource<WeatherInfo>) {
        when (responseForWeatherApi) {
            is Resource.Success -> {
                responseForWeatherApi.data?.let { weatherInfo ->
                    Log.d(TAG, "API Response: Success ==>")
                    Log.d(TAG, "$weatherInfo")

                    val weatherState = weatherInfo.toWeatherState()

                    state = state.copy(
                        locationState = weatherState.locationState,
                        weatherMenuSelectorType = weatherState.weatherMenuSelectorType,
                        currentWeatherState = weatherState.currentWeatherState,
                        nextTenDaysWeatherItemListState = weatherState.nextTenDaysWeatherItemListState,
                        tomorrowWeatherItemListState = weatherState.tomorrowWeatherItemListState,
                        nextTenDaysWeatherDetailsItemListState = weatherState.nextTenDaysWeatherDetailsItemListState
                    )
                }
            }

            is Resource.Error -> {
                Log.d(TAG, "API Response: Error ==>")
                Log.d(TAG, "${responseForWeatherApi.message}")
            }

            else -> Unit
        }
    }

    fun updateWeatherMenuSelectorType(weatherMenuSelectorType: WeatherMenuSelectorType) {
        state?.let {
            state = state.copy(
                weatherMenuSelectorType = weatherMenuSelectorType
            )
        }
    }

    fun getWeatherLocationManager(): WeatherLocationManager {
        return weatherLocationManager
    }
}