package com.compose.weatherapplite.presentation.weather.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.weatherapplite.R
import com.compose.weatherapplite.presentation.weather.WeatherTempState
import com.compose.weatherapplite.presentation.weather.WeatherViewModel
import com.compose.weatherapplite.presentation.weather.temp.WeatherHistoryItemState
import com.compose.weatherapplite.presentation.weather.temp.WeatherType

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val state = viewModel.state

    if (state?.hourlyUnit != null) {
        val weatherTempState = WeatherTempState(
            latitude = "12.930657",
            longitude = "77.7379234",
            city = "Pune",
            currentDate = "3 November, Friday",
            currentTemp = "18",
            currentWeather = "Thunderstorm",
            currentWeatherType = WeatherType.Thunderstorm,
            currentWind = "10 m/s",
            currentHumidity = "98%",
            currentRain = "100%"
        )

        val weatherHistoryItems = listOf(
            WeatherHistoryItemState("10 am", R.drawable.vd_menu, "16°"),
            WeatherHistoryItemState("11 am", R.drawable.vd_menu, "18°"),
            WeatherHistoryItemState("12 pm", R.drawable.vd_menu, "21°"),
            WeatherHistoryItemState("1 pm", R.drawable.vd_menu, "24°"),
            WeatherHistoryItemState("2 pm", R.drawable.vd_menu, "23°"),
            WeatherHistoryItemState("3 pm", R.drawable.vd_menu, "21°"),
            WeatherHistoryItemState("4 pm", R.drawable.vd_menu, "18°"),
        )

        Column(
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 40.dp)
        ) {
            TopBar(weatherTempState)
            CurrentWeatherView(weatherTempState = weatherTempState)
            Spacer(modifier = Modifier.height(40.dp))
            WeatherHistoryQuickView(weatherHistoryItems)
            Spacer(modifier = Modifier.height(40.dp))
            WeatherMapScreen(weatherTempState)
        }
    }
}