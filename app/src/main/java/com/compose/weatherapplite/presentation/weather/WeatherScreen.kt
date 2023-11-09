package com.compose.weatherapplite.presentation.weather

import android.Manifest
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.weatherapplite.R
import com.compose.weatherapplite.presentation.weather.composables.weather.CurrentWeatherView
import com.compose.weatherapplite.presentation.weather.composables.weather.TopBar
import com.compose.weatherapplite.presentation.weather.composables.weather.WeatherHistoryQuickView
import com.compose.weatherapplite.presentation.weather.composables.weather.WeatherMapScreen
import com.compose.weatherapplite.presentation.weather.destinations.WeatherScreenDetailsContainerDestination
import com.compose.weatherapplite.ui.theme.WeatherTypography
import com.compose.weatherapplite.ui.theme.md_theme_dark_background
import com.compose.weatherapplite.ui.theme.md_theme_dark_primary
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun WeatherScreenContainer(
    viewModel: WeatherViewModel = hiltViewModel(),
    destinationsNavigator: DestinationsNavigator
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(md_theme_dark_background),
        contentAlignment = Alignment.TopCenter
    ) {
        WeatherScreen(viewModel = viewModel) {
            destinationsNavigator.navigate(WeatherScreenDetailsContainerDestination)
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel,
    onGridClick: () -> Unit
) {
    val locationPermissionState = rememberMultiplePermissionsState(listOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    ))

    if (locationPermissionState.allPermissionsGranted) {
        if (!viewModel.firstTimeRequest.getAndSet(true)) {
            viewModel.getWeatherLocationManager().registerForLocationUpdates {
                viewModel.initiateApiRequest(it.latitude, it.longitude)
            }
        }
        val weatherState = viewModel.state

        Column(
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 40.dp)
        ) {
            TopBar(weatherState = weatherState, onGridClick)
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

            Image(
                painter = painterResource(id = R.drawable.vd_foggy),
                contentDescription = null,
                modifier = Modifier.size(500.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
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