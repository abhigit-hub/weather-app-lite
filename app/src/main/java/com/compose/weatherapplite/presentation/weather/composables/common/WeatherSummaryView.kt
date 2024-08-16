@file:Suppress("FunctionNaming")

package com.compose.weatherapplite.presentation.weather.composables.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.R
import com.compose.weatherapplite.presentation.model.CurrentWeatherState
import com.compose.weatherapplite.ui.theme.WeatherTypography

private const val DIMENS_CONTAINER_HEIGHT = 0.2f

@Composable
fun WeatherSummaryView(currentWeatherState: CurrentWeatherState) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(DIMENS_CONTAINER_HEIGHT)
            .clip(RoundedCornerShape(15.dp))
            .shadow(
                elevation = 30.dp,
                shape = RoundedCornerShape(15.dp)
            )
            .background(MaterialTheme.colorScheme.primaryContainer)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CurrentWeatherItem(R.drawable.vd_main_wind, currentWeatherState.wind, "Wind")
            CurrentWeatherItem(
                R.drawable.vd_main_humidity,
                currentWeatherState.humidity,
                "Humidity"
            )
            CurrentWeatherItem(R.drawable.vd_main_rain, currentWeatherState.rain, "Rain")
        }
    }
}

@Composable
fun CurrentWeatherItem(
    @DrawableRes itemDrawable: Int,
    itemData: String,
    itemType: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(itemDrawable),
            contentDescription = null,
            modifier = Modifier.size(50.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = itemData,
            style = WeatherTypography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = itemType,
            style = WeatherTypography.labelLarge,
            color = MaterialTheme.colorScheme.secondary,
            textAlign = TextAlign.Center
        )
    }
}
