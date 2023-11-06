package com.compose.weatherapplite.presentation.weather.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.R
import com.compose.weatherapplite.presentation.model.WeatherState
import com.compose.weatherapplite.ui.theme.WeatherTypography
import com.compose.weatherapplite.ui.theme.md_theme_dark_onSecondary
import com.compose.weatherapplite.ui.theme.md_theme_dark_primary
import com.compose.weatherapplite.ui.theme.md_theme_dark_primaryContainer
import com.compose.weatherapplite.ui.theme.md_theme_dark_secondary

@Composable
fun TopBar(weatherState: WeatherState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.13f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.88f)
                .padding(3.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = weatherState.locationState.cityName,
                color = md_theme_dark_primary,
                style = WeatherTypography.headlineSmall,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = weatherState.currentWeatherState.date,
                color = md_theme_dark_secondary,
                style = WeatherTypography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Box(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .weight(0.12f)
                .clip(RoundedCornerShape(10.dp))
                .background(md_theme_dark_primaryContainer)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.vd_menu),
                contentDescription = "list more cities",
                tint = md_theme_dark_onSecondary,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            )
        }
    }
}