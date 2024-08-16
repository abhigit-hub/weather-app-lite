package com.compose.weatherapplite.presentation.weather.composables.weatherdetails

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.compose.weatherapplite.R
import com.compose.weatherapplite.presentation.model.WeatherState
import com.compose.weatherapplite.presentation.weather.composables.common.WeatherIconView
import com.compose.weatherapplite.ui.theme.WeatherTypography

@Composable
fun WeatherDetailsTopBarView(
    weatherState: WeatherState,
    navigateHome: () -> Unit,
    navigatePageInfo: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.13f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        WeatherIconView(
            modifier = Modifier.fillMaxHeight(0.4f).weight(0.12f),
            R.drawable.vd_action_back,
            "go back to previous page",
            onItemClick = navigateHome
        )

        Text(
            text = weatherState.locationState.cityShortenedName,
            color = MaterialTheme.colorScheme.primary,
            style = WeatherTypography.headlineSmall,
            modifier = Modifier.fillMaxWidth().weight(0.76f),
            textAlign = TextAlign.Center
        )

        WeatherIconView(
            modifier = Modifier.fillMaxHeight(0.4f).weight(0.12f),
            R.drawable.vd_action_page_info,
            "Page Info",
            onItemClick = navigatePageInfo
        )
    }
}
