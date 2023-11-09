package com.compose.weatherapplite.presentation.weather

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.weatherapplite.ui.theme.WeatherTypography
import com.compose.weatherapplite.ui.theme.md_theme_dark_primary

@Composable
fun WeatherDetailsScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Text(
        text = state.locationState.cityName,
        style = WeatherTypography.titleLarge,
        color = md_theme_dark_primary
    )
}