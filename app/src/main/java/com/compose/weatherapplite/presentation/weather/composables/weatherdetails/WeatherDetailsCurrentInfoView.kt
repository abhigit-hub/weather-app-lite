package com.compose.weatherapplite.presentation.weather.composables.weatherdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.presentation.model.WeatherState
import com.compose.weatherapplite.presentation.weather.composables.common.WeatherSummaryView
import com.compose.weatherapplite.ui.theme.WeatherTypography
import com.compose.weatherapplite.ui.theme.md_theme_dark_primary
import com.compose.weatherapplite.ui.theme.md_theme_dark_secondary

@Composable
fun WeatherDetailsCurrentInfoView(
    weatherState: WeatherState
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.17f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = weatherState.currentWeatherState.temperature,
            style = WeatherTypography.displayLarge,
            color = md_theme_dark_primary,
        )
        Text(
            text = weatherState.currentWeatherState.weatherType.weatherType,
            style = WeatherTypography.titleLarge,
            color = md_theme_dark_secondary,
        )
    }

    Spacer(modifier = Modifier.height(20.dp))

    WeatherSummaryView(weatherState.currentWeatherState)
}