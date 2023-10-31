package com.compose.weatherapplite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.compose.weatherapplite.ui.theme.WeatherAppLiteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
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
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {

    }
}

@Preview
@Composable
fun MainSurfacePreview() {
    MainSurface()
}