@file:Suppress("FunctionNaming")

package com.compose.weatherapplite.presentation.weather.composables.weatherdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.presentation.model.WeatherDetailsItemMetaState
import com.compose.weatherapplite.presentation.model.WeatherState
import com.compose.weatherapplite.presentation.weather.composables.components.AnimatedVector
import com.compose.weatherapplite.ui.theme.WeatherTypography
import com.compose.weatherapplite.utils.toAnimatedVectorDrawable
import com.compose.weatherapplite.utils.toDayOfWeek

private const val DIMENS_DAY_OF_WEEK_WEIGHT = 0.2f
private const val DIMENS_TEMPERATURE_BAR_WEIGHT = 0.55f

@Composable
fun WeatherDetailsHistoryQuickView(
    weatherState: WeatherState
) {
    weatherState.nextTenDaysWeatherDetailsItemListState.forEach { weatherDetailsItemMetaData ->
        Spacer(modifier = Modifier.height(2.dp))
        WeatherDetailsHistoryQuickViewItem(weatherDetailsItemMetaData = weatherDetailsItemMetaData)
        Spacer(modifier = Modifier.height(2.dp))
    }
}

@Composable
fun WeatherDetailsHistoryQuickViewItem(weatherDetailsItemMetaData: WeatherDetailsItemMetaState) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = weatherDetailsItemMetaData.time.toDayOfWeek(),
            color = MaterialTheme.colorScheme.primary,
            style = WeatherTypography.titleMedium,
            modifier = Modifier
                .weight(DIMENS_DAY_OF_WEEK_WEIGHT)
                .padding(start = 12.dp)
        )

        WeatherDetailsTemperatureBarView(
            minTemperature = weatherDetailsItemMetaData.minTemperature,
            maxTemperature = weatherDetailsItemMetaData.maxTemperature,
            modifier = Modifier.weight(DIMENS_TEMPERATURE_BAR_WEIGHT)
        )

        AnimatedVector(
            drawable = weatherDetailsItemMetaData.weatherCode.toAnimatedVectorDrawable(),
            modifier = Modifier.size(60.dp)
        )
    }
}
