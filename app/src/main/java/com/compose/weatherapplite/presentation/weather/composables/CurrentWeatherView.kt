package com.compose.weatherapplite.presentation.weather.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.R
import com.compose.weatherapplite.utils.toDrawable
import com.compose.weatherapplite.presentation.model.CurrentWeatherState
import com.compose.weatherapplite.ui.theme.WeatherTypography
import com.compose.weatherapplite.ui.theme.md_theme_dark_primary
import com.compose.weatherapplite.ui.theme.md_theme_dark_primaryContainer
import com.compose.weatherapplite.ui.theme.md_theme_dark_secondary

@Composable
fun CurrentWeatherView(
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
                    color = md_theme_dark_primary,
                )
                Text(
                    text = currentWeatherState.weatherType.weatherType,
                    style = WeatherTypography.titleLarge,
                    color = md_theme_dark_secondary,
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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .clip(RoundedCornerShape(15.dp))
                .shadow(
                    elevation = 30.dp,
                    shape = RoundedCornerShape(15.dp)
                )
                .background(md_theme_dark_primaryContainer)

        ) {
            Row(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CurrentWeatherItem(R.drawable.vd_main_wind, currentWeatherState.wind, "Wind")
                CurrentWeatherItem(R.drawable.vd_main_humidity, currentWeatherState.humidity, "Humidity")
                CurrentWeatherItem(R.drawable.vd_main_rain, currentWeatherState.rain, "Rain")
            }
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
        Image(
            painter = painterResource(itemDrawable),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = itemData,
            style = WeatherTypography.headlineSmall,
            color = md_theme_dark_primary,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = itemType,
            style = WeatherTypography.labelLarge,
            color = md_theme_dark_primary,
            textAlign = TextAlign.Center
        )
    }
}