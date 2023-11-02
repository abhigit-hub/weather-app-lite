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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.ui.theme.WeatherTypography
import com.compose.weatherapplite.ui.theme.md_theme_dark_primaryContainer

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.17f)
            .padding(
                horizontal = 30.dp,
                vertical = 40.dp,
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.85f)
                .padding(3.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Stuttgart",
                color = Color.White,
                style = WeatherTypography.displaySmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "02, November, Thursday",
                color = Color.White,
                style = WeatherTypography.bodyMedium,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Box(
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .weight(0.15f)
                .clip(RoundedCornerShape(15.dp))
                .background(md_theme_dark_primaryContainer)
        ) {
            Icon(
                imageVector = Icons.Default.List,
                contentDescription = "list more cities",
                tint = Color.White,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            )
        }
    }
}