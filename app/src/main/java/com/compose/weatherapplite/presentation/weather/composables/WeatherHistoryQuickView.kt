package com.compose.weatherapplite.presentation.weather.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.presentation.weather.temp.WeatherHistoryItemState
import com.compose.weatherapplite.presentation.weather.temp.WeatherMenuSelectorType
import com.compose.weatherapplite.ui.theme.WeatherTypography
import com.compose.weatherapplite.ui.theme.md_theme_dark_onSecondary
import com.compose.weatherapplite.ui.theme.md_theme_dark_primary
import com.compose.weatherapplite.ui.theme.md_theme_dark_primaryContainer
import com.compose.weatherapplite.ui.theme.md_theme_dark_secondary

@Composable
fun WeatherHistoryQuickView(
    weatherHistoryItems: List<WeatherHistoryItemState>
) {
    Row {
        WeatherHistorySelectorView(
            weatherMenuSelectorType = WeatherMenuSelectorType.WeatherMenuSelectorTypeToday,
            isSelected = true
        )
        Spacer(modifier = Modifier.width(20.dp))
        WeatherHistorySelectorView(
            weatherMenuSelectorType = WeatherMenuSelectorType.WeatherMenuSelectorTypeTomorrow,
            isSelected = false
        )
        Spacer(modifier = Modifier.width(20.dp))
        WeatherHistorySelectorView(
            weatherMenuSelectorType = WeatherMenuSelectorType.WeatherMenuSelectorTypeNextTenDays,
            isSelected = false
        )
    }

    Spacer(modifier = Modifier.height(40.dp))

    LazyRow {
        items(weatherHistoryItems.size) { index ->
            val item = weatherHistoryItems[index]

            WeatherHistoryItemView(
                weatherDrawable = item.drawable,
                weatherTime = item.time,
                temperature = item.temperature
            )
        }
    }
}

@Composable
fun WeatherHistorySelectorView(weatherMenuSelectorType: WeatherMenuSelectorType, isSelected: Boolean) {
   Column(
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
       Text(
           text = weatherMenuSelectorType.weatherType,
           color = if (isSelected) md_theme_dark_primary else md_theme_dark_secondary,
           style = WeatherTypography.titleLarge
       )
       if (isSelected) {
           Spacer(modifier = Modifier.height(5.dp))
           Box(
               modifier = Modifier
                   .size(5.dp)
                   .clip(RoundedCornerShape(50.dp))
                   .background(md_theme_dark_primary)
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
            .background(md_theme_dark_primaryContainer)
            .padding(vertical = 20.dp, horizontal = 25.dp)
    ) {
        Text(
            text = weatherTime,
            style = WeatherTypography.titleLarge,
            color = md_theme_dark_onSecondary,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(5.dp))
        Icon(
            painter = painterResource(weatherDrawable),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = temperature,
            style = WeatherTypography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = md_theme_dark_primary,
            textAlign = TextAlign.Center
        )
    }
    Spacer(modifier = Modifier.width(15.dp))
}