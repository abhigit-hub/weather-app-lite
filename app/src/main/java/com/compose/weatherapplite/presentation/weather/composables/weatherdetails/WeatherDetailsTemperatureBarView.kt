@file:Suppress("FunctionNaming")

package com.compose.weatherapplite.presentation.weather.composables.weatherdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.ui.theme.WeatherTypography
import com.compose.weatherapplite.ui.theme.md_theme_common_gradientLinearEnd
import com.compose.weatherapplite.ui.theme.md_theme_common_gradientLinearStart

@Composable
fun WeatherDetailsTemperatureBarView(
    minTemperature: String,
    maxTemperature: String,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = minTemperature,
            color = MaterialTheme.colorScheme.secondary,
            style = WeatherTypography.titleLarge,
            textAlign = TextAlign.Left,
            modifier = Modifier.width(45.dp)
        )

        Box(
            modifier = Modifier
                .height(4.dp)
                .width(80.dp)
                .padding(horizontal = 15.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            md_theme_common_gradientLinearStart,
                            md_theme_common_gradientLinearEnd
                        )
                    )
                )
        )

        Text(
            text = maxTemperature,
            color = MaterialTheme.colorScheme.primary,
            style = WeatherTypography.titleLarge,
            textAlign = TextAlign.End,
            modifier = Modifier.width(45.dp)
        )
    }
}
