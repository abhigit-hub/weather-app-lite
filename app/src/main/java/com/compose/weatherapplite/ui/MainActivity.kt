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
import androidx.compose.ui.tooling.preview.Preview
import com.compose.weatherapplite.presentation.weather.composables.WeatherScreen
import com.compose.weatherapplite.ui.theme.WeatherAppLiteTheme
import com.compose.weatherapplite.ui.theme.md_theme_dark_background
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
                MainSurface()
            }
        }
    }
}

@Composable
fun MainSurface() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(md_theme_dark_background),
        contentAlignment = Alignment.TopCenter
    ) {
        WeatherScreen()
    }
}

@Preview
@Composable
fun MainSurfacePreview() {
    MainSurface()
}