package com.compose.weatherapplite.presentation.weather.composables

import android.Manifest
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.weatherapplite.presentation.weather.WeatherViewModel
import com.compose.weatherapplite.ui.theme.WeatherTypography
import com.compose.weatherapplite.ui.theme.md_theme_dark_primary
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val locationPermissionState = rememberMultiplePermissionsState(listOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    ))

    if (locationPermissionState.allPermissionsGranted) {
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
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val allPermissionsRevoked = locationPermissionState.permissions.size ==
                    locationPermissionState.revokedPermissions.size

            val textToShow = if (!allPermissionsRevoked) {
                "Yay! Thanks for letting me access your approximate location. " +
                        "But you know what would be great? If you allow me to know where you " +
                        "exactly are. Thank you!"
            } else if (!locationPermissionState.shouldShowRationale) {
                "Getting your exact location is important for localising the Weather App.\n" +
                        "Please grant us fine location to help us provide you with accurate weather information"
            } else {
                "This app requires location permission!"
            }

            val buttonText = if (!allPermissionsRevoked) {
                "Allow precise location"
            } else "Request permissions"

            Text(
                text = textToShow,
                color = md_theme_dark_primary,
                style = WeatherTypography.titleLarge,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = { locationPermissionState.launchMultiplePermissionRequest() }
            ) {
                Text(text = buttonText)
            }
        }
    }
}