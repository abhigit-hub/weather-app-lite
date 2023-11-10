package com.compose.weatherapplite.presentation.weather.composables.weatherdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.presentation.model.WeatherDetailsItemMetaState
import com.compose.weatherapplite.presentation.model.WeatherState
import com.compose.weatherapplite.ui.theme.WeatherTypography
import com.compose.weatherapplite.ui.theme.md_theme_dark_primary
import com.compose.weatherapplite.utils.toDayOfWeek
import com.compose.weatherapplite.utils.toDrawable

@Composable
fun WeatherDetailsHistoryQuickView(
    weatherState: WeatherState
) {
    weatherState.nextTenDaysWeatherDetailsItemListState.forEach { weatherDetailsItemMetaData ->
        Spacer(modifier = Modifier.height(6.dp))
        WeatherDetailsHistoryQuickViewItem(weatherDetailsItemMetaData = weatherDetailsItemMetaData)
        Spacer(modifier = Modifier.height(6.dp))
    }
}

@Composable
fun WeatherDetailsHistoryQuickViewItem(weatherDetailsItemMetaData: WeatherDetailsItemMetaState) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = weatherDetailsItemMetaData.time.toDayOfWeek(),
            color = md_theme_dark_primary,
            style = WeatherTypography.titleMedium,
            modifier = Modifier.weight(0.2f).padding(start = 12.dp)
        )

        WeatherDetailsTemperatureBarView(
            minTemperature = weatherDetailsItemMetaData.minTemperature,
            maxTemperature = weatherDetailsItemMetaData.maxTemperature,
            modifier = Modifier.weight(0.55f)
        )

        Image(
            painter = painterResource(weatherDetailsItemMetaData.weatherCode.toDrawable()),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
        )
    }
}