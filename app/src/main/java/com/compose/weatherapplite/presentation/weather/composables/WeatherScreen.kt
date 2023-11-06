package com.compose.weatherapplite.presentation.weather.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.weatherapplite.presentation.weather.WeatherViewModel

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val weatherState = viewModel.state

    Column(
        modifier = Modifier.padding(horizontal = 30.dp, vertical = 40.dp)
    ) {
        TopBar(weatherState = weatherState)
        CurrentWeatherView(currentWeatherState = weatherState.currentWeatherState)
        Spacer(modifier = Modifier.height(40.dp))
        WeatherHistoryQuickView(
            weatherState = weatherState,
            onItemClick = {
                viewModel.updateWeatherMenuSelectorType(it)
            }
        )
        Spacer(modifier = Modifier.height(40.dp))
        WeatherMapScreen(locationState = weatherState.locationState)
    }
}