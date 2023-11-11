package com.compose.weatherapplite.presentation.weather.composables.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.presentation.model.CurrentWeatherState
import com.compose.weatherapplite.presentation.weather.composables.common.WeatherSummaryView
import com.compose.weatherapplite.ui.theme.WeatherTypography
import com.compose.weatherapplite.utils.toDrawable

@Composable
fun WeatherCurrentInfoView(
    currentWeatherState: CurrentWeatherState
) {
    Column {
        Row {
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.17f)
                    .weight(0.5f)
            ) {
                Text(
                    text = currentWeatherState.temperature,
                    style = WeatherTypography.displayLarge,
                    color = MaterialTheme.colorScheme.primary,
                )
                Text(
                    text = currentWeatherState.weatherType.weatherType,
                    style = WeatherTypography.titleLarge,
                    color = MaterialTheme.colorScheme.secondary,
                )
            }

            Image(
                painter = painterResource(id = currentWeatherState.weatherType.toDrawable()),
                contentDescription = "Current Weather",
                modifier = Modifier
                    .size(150.dp)
                    .fillMaxWidth()
                    .weight(0.4f)
                    .scale(1.25f, 1.25f),
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        WeatherSummaryView(currentWeatherState)
    }
}