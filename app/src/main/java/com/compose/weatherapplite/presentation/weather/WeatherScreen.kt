package com.compose.weatherapplite.presentation.weather

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val state = viewModel.state

    if (state?.hourlyUnit != null) {
        Text(
            text = state.toString(),
            fontSize = 32.sp,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 100.dp)
        )
    }
}