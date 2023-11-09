package com.compose.weatherapplite.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.compose.weatherapplite.presentation.weather.WeatherDetailsScreen
import com.compose.weatherapplite.presentation.weather.WeatherScreen
import com.compose.weatherapplite.ui.destinations.WeatherDetailsScreenSurfaceDestination
import com.compose.weatherapplite.ui.theme.WeatherAppLiteTheme
import com.compose.weatherapplite.ui.theme.md_theme_dark_background
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT, android.graphics.Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT, android.graphics.Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppLiteTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}

@RootNavGraph(start = true)
@Destination
@Composable
fun WeatherScreenSurface(
    destinationsNavigator: DestinationsNavigator
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(md_theme_dark_background),
        contentAlignment = Alignment.TopCenter
    ) {
        WeatherScreen {
            destinationsNavigator.navigate(WeatherDetailsScreenSurfaceDestination)
        }
    }
}

@Destination
@Composable
fun WeatherDetailsScreenSurface() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(md_theme_dark_background),
        contentAlignment = Alignment.TopCenter
    ) {
        WeatherDetailsScreen()
    }
}