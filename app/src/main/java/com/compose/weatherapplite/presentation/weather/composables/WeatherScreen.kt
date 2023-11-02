package com.compose.weatherapplite.presentation.weather.composables

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.weatherapplite.presentation.weather.WeatherTempState
import com.compose.weatherapplite.presentation.weather.WeatherViewModel

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val state = viewModel.state

    if (state?.hourlyUnit != null) {
        val weatherTempState = WeatherTempState(
            "12.34",
            "11.76",
            "Pune",
            "3 November, Friday",
            "18",
            "Thunderstorm",
            "10 m/s",
            "98%",
            "100%"
        )

        TopBar(weatherTempState)
    }
}