package com.compose.weatherapplite.presentation.weather

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.weatherapplite.domain.repository.WeatherRepository
import com.compose.weatherapplite.manager.WeatherLocationManager
import com.compose.weatherapplite.presentation.mapper.toWeatherState
import com.compose.weatherapplite.presentation.model.WeatherMenuSelectorType
import com.compose.weatherapplite.presentation.model.WeatherState
import com.compose.weatherapplite.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
            val response = repository.getWeatherForecastAndCurrent(
                latitude = latitude.toString(),
                longitude = longitude.toString()
            )

            when (response) {
                is Resource.Success -> {
                    response.data?.let { weatherInfo ->
                        Log.d(TAG, "API Response: Success ==>")
                        Log.d(TAG, "$weatherInfo")

                        state = weatherInfo.toWeatherState()
                    }
                }
                is Resource.Error -> {
                    Log.d(TAG, "API Response: Error ==>")
                    Log.d(TAG, "${response.message}")
                }
                else -> Unit
            }
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