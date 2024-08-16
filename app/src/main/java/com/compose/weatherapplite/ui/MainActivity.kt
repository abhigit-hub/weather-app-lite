@file:Suppress("FunctionNaming")

package com.compose.weatherapplite.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.weatherapplite.presentation.weather.NavGraphs
import com.compose.weatherapplite.presentation.weather.WeatherViewModel
import com.compose.weatherapplite.ui.theme.WeatherAppLiteTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppLiteTheme {
                AppNavigation(this@MainActivity)
            }
        }
    }
}

@Composable
private fun AppNavigation(activity: ComponentActivity) {
    DestinationsNavHost(
        navGraph = NavGraphs.root,
        dependenciesContainerBuilder = {
            dependency(hiltViewModel<WeatherViewModel>(activity))
        }
    )
}
