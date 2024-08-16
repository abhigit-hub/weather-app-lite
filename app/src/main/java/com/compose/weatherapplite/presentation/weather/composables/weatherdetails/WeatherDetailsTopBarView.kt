@file:Suppress("FunctionNaming")

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

private const val DIMENS_CONTAINER_HEIGHT = 0.13f
private const val DIMENS_BACK_LOCATION_WEIGHT = 0.76f
private const val DIMENS_ICON_HEIGHT = 0.4f
private const val DIMENS_ICON_WEIGHT = 0.12f

@Composable
fun WeatherDetailsTopBarView(
    weatherState: WeatherState,
    navigateHome: () -> Unit,
    navigatePageInfo: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(DIMENS_CONTAINER_HEIGHT),
        verticalAlignment = Alignment.CenterVertically
    ) {
        WeatherIconView(
            modifier = Modifier.fillMaxHeight(DIMENS_ICON_HEIGHT).weight(DIMENS_ICON_WEIGHT),
            R.drawable.vd_action_back,
            "go back to previous page",
            onItemClick = navigateHome
        )

        Text(
            text = weatherState.locationState.cityShortenedName,
            color = MaterialTheme.colorScheme.primary,
            style = WeatherTypography.headlineSmall,
            modifier = Modifier.fillMaxWidth().weight(DIMENS_BACK_LOCATION_WEIGHT),
            textAlign = TextAlign.Center
        )

        WeatherIconView(
            modifier = Modifier.fillMaxHeight(DIMENS_ICON_HEIGHT).weight(DIMENS_ICON_WEIGHT),
            R.drawable.vd_action_page_info,
            "Page Info",
            onItemClick = navigatePageInfo
        )
    }
}
