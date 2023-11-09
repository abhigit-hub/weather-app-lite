package com.compose.weatherapplite.presentation.weather.composables.weatherdetails

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.compose.weatherapplite.R
import com.compose.weatherapplite.presentation.model.WeatherState
import com.compose.weatherapplite.presentation.weather.composables.common.WeatherIconView
import com.compose.weatherapplite.ui.theme.WeatherTypography
import com.compose.weatherapplite.ui.theme.md_theme_dark_primary

@Composable
fun WeatherDetailsTopBar(
    weatherState: WeatherState,
    navigateHome: () -> Unit
    ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.13f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        WeatherIconView(
            modifier = Modifier.fillMaxHeight(0.4f).weight(0.12f),
            R.drawable.vd_menu,
            "go back to previous page",
            onItemClick = navigateHome
        )

        Text(
            text = weatherState.locationState.cityName,
            color = md_theme_dark_primary,
            style = WeatherTypography.headlineSmall,
            modifier = Modifier.fillMaxWidth().weight(0.76f),
            textAlign = TextAlign.Center
        )

        WeatherIconView(
            modifier = Modifier.fillMaxHeight(0.4f).weight(0.12f),
            R.drawable.vd_menu,
            "list of cities",
            onItemClick = navigateHome
        )
    }
}