package com.compose.weatherapplite.presentation.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.presentation.weather.composables.weatherdetails.WeatherDetailsCurrentInfoView
import com.compose.weatherapplite.presentation.weather.composables.weatherdetails.WeatherDetailsTopBarView
import com.compose.weatherapplite.ui.theme.md_theme_dark_background
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun WeatherScreenDetailsContainer(
    viewModel: WeatherViewModel,
    destinationsNavigator: DestinationsNavigator
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(md_theme_dark_background),
        contentAlignment = Alignment.TopCenter
    ) {
        WeatherDetailsScreen(viewModel = viewModel) {
            destinationsNavigator.navigateUp()
        }
    }
}

@Composable
fun WeatherDetailsScreen(
    viewModel: WeatherViewModel,
    navigateHome: () -> Unit
) {
    val weatherState = viewModel.state

    Column(
        modifier = Modifier.padding(horizontal = 30.dp, vertical = 40.dp)
    ) {
        WeatherDetailsTopBarView(weatherState = weatherState, navigateHome = navigateHome)
        WeatherDetailsCurrentInfoView(weatherState = weatherState)
    }
}