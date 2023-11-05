package com.compose.weatherapplite.presentation.weather

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.weatherapplite.domain.repository.WeatherRepository
import com.compose.weatherapplite.presentation.mapper.toWeatherState
import com.compose.weatherapplite.presentation.model.WeatherState
import com.compose.weatherapplite.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
): ViewModel() {

    companion object {
        val TAG: String = WeatherViewModel::class.java.simpleName
    }

    var state by mutableStateOf<WeatherState?>(null)

    init {
        initiateApiRequest()
    }

    private fun initiateApiRequest() {
        viewModelScope.launch {
            val response = repository.getWeatherForecastAndCurrent(
                latitude = "18.5892864",
                longitude = "73.7476608"
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
}