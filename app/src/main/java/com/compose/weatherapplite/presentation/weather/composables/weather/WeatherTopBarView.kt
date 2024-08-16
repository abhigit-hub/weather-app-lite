@file:Suppress("FunctionNaming")

package com.compose.weatherapplite.presentation.weather.composables.weather

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.R
import com.compose.weatherapplite.presentation.model.WeatherState
import com.compose.weatherapplite.presentation.weather.composables.common.WeatherIconView
import com.compose.weatherapplite.ui.theme.WeatherTypography

private const val DIMENS_CONTAINER_HEIGHT = 0.13f
private const val DIMENS_TOP_BAR_LOCATION_DATE_WEIGHT = 0.86f
private const val DIMENS_TOP_BAR_ICON_HEIGHT = 0.4f
private const val DIMENS_TOP_BAR_ICON_WEIGHT = 0.12f

@Composable
fun WeatherTopBarView(
    weatherState: WeatherState,
    isDarkThemeEnabled: Boolean,
    onGridClick: () -> Unit,
    onNightModeSwitch: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(DIMENS_CONTAINER_HEIGHT),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(DIMENS_TOP_BAR_LOCATION_DATE_WEIGHT)
                .padding(3.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = weatherState.locationState.cityName,
                color = MaterialTheme.colorScheme.primary,
                style = WeatherTypography.headlineSmall,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = weatherState.currentWeatherState.date,
                color = MaterialTheme.colorScheme.secondary,
                style = WeatherTypography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
        }

        WeatherIconView(
            modifier = Modifier
                .fillMaxHeight(DIMENS_TOP_BAR_ICON_HEIGHT)
                .weight(DIMENS_TOP_BAR_ICON_WEIGHT),
            drawable = if (isDarkThemeEnabled) {
                R.drawable.vd_action_dark_mode
            } else {
                R.drawable.vd_action_light_mode
            },
            onItemClick = {
                onNightModeSwitch()
            }
        )
        Spacer(modifier = Modifier.width(5.dp))

        WeatherIconView(
            modifier = Modifier
                .fillMaxHeight(DIMENS_TOP_BAR_ICON_HEIGHT)
                .weight(DIMENS_TOP_BAR_ICON_WEIGHT),
            R.drawable.vd_action_menu,
            "detailed weather",
            onItemClick = onGridClick
        )
    }
}
