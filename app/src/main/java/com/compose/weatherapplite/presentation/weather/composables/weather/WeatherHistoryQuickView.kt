@file:Suppress("FunctionNaming")

package com.compose.weatherapplite.presentation.weather.composables.weather

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.presentation.model.WeatherMenuSelectorType
import com.compose.weatherapplite.presentation.model.WeatherState
import com.compose.weatherapplite.ui.theme.WeatherTypography
import com.compose.weatherapplite.utils.toDrawable
import com.compose.weatherapplite.utils.toTimeInTheDay

@Composable
fun WeatherHistoryQuickView(
    weatherState: WeatherState,
    onItemClick: (WeatherMenuSelectorType) -> Unit
) {
    Row {
        WeatherHistorySelectorView(
            weatherMenuSelectorType = WeatherMenuSelectorType.WeatherMenuSelectorTypeToday,
            isSelected = weatherState.weatherMenuSelectorType
                == WeatherMenuSelectorType.WeatherMenuSelectorTypeToday,
            onItemClick = {
                onItemClick(WeatherMenuSelectorType.WeatherMenuSelectorTypeToday)
            }
        )
        Spacer(modifier = Modifier.width(20.dp))
        WeatherHistorySelectorView(
            weatherMenuSelectorType = WeatherMenuSelectorType.WeatherMenuSelectorTypeTomorrow,
            isSelected = weatherState.weatherMenuSelectorType
                == WeatherMenuSelectorType.WeatherMenuSelectorTypeTomorrow,
            onItemClick = {
                onItemClick(WeatherMenuSelectorType.WeatherMenuSelectorTypeTomorrow)
            }
        )
        Spacer(modifier = Modifier.width(20.dp))
        WeatherHistorySelectorView(
            weatherMenuSelectorType = WeatherMenuSelectorType.WeatherMenuSelectorTypeNextTenDays,
            isSelected = weatherState.weatherMenuSelectorType
                == WeatherMenuSelectorType.WeatherMenuSelectorTypeNextTenDays,
            onItemClick = {
                onItemClick(WeatherMenuSelectorType.WeatherMenuSelectorTypeNextTenDays)
            }
        )
    }

    Spacer(modifier = Modifier.height(40.dp))

    val weatherListItems = when (weatherState.weatherMenuSelectorType) {
        WeatherMenuSelectorType.WeatherMenuSelectorTypeToday ->
            weatherState.currentWeatherState.todaysWeatherItemListState

        WeatherMenuSelectorType.WeatherMenuSelectorTypeTomorrow ->
            weatherState.tomorrowWeatherItemListState

        WeatherMenuSelectorType.WeatherMenuSelectorTypeNextTenDays ->
            weatherState.nextTenDaysWeatherItemListState
    }

    LazyRow {
        items(weatherListItems.size) { index ->
            val item = weatherListItems[index]

            WeatherHistoryItemView(
                weatherDrawable = item.weatherCode.toDrawable(),
                weatherTime = item.time.toTimeInTheDay(),
                temperature = item.temperature
            )
        }
    }
}

@Composable
fun WeatherHistorySelectorView(
    weatherMenuSelectorType: WeatherMenuSelectorType,
    isSelected: Boolean,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onItemClick() }
    ) {
        Text(
            text = weatherMenuSelectorType.weatherType,
            color =
            if (isSelected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.secondary
            },
            style = WeatherTypography.titleLarge
        )
        if (isSelected) {
            Spacer(modifier = Modifier.height(5.dp))
            Box(
                modifier = Modifier
                    .size(5.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(MaterialTheme.colorScheme.primary)
            )
        }
    }
}

@Composable
fun WeatherHistoryItemView(
    @DrawableRes weatherDrawable: Int,
    weatherTime: String,
    temperature: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(vertical = 20.dp, horizontal = 25.dp)
    ) {
        Text(
            text = weatherTime,
            style = WeatherTypography.titleLarge,
            color = MaterialTheme.colorScheme.onSecondary,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(5.dp))
        Image(
            painter = painterResource(weatherDrawable),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "$temperature°",
            style = WeatherTypography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
    }
    Spacer(modifier = Modifier.width(15.dp))
}
