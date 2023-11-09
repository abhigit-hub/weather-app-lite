package com.compose.weatherapplite.presentation.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.weatherapplite.ui.theme.WeatherTypography
import com.compose.weatherapplite.ui.theme.md_theme_dark_background
import com.compose.weatherapplite.ui.theme.md_theme_dark_primary
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun WeatherScreenDetailsContainer(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(md_theme_dark_background),
        contentAlignment = Alignment.TopCenter
    ) {
        WeatherDetailsScreen(viewModel = viewModel)
    }
}

@Composable
fun WeatherDetailsScreen(
    viewModel: WeatherViewModel
) {
    val state = viewModel.state

    Text(
        text = state.locationState.cityName,
        style = WeatherTypography.titleLarge,
        color = md_theme_dark_primary
    )
}