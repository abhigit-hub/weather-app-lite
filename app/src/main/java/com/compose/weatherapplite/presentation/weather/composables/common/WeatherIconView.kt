package com.compose.weatherapplite.presentation.weather.composables.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.ui.theme.md_theme_dark_onSecondary
import com.compose.weatherapplite.ui.theme.md_theme_dark_primaryContainer

@Composable
fun WeatherIconView(
    modifier: Modifier,
    @DrawableRes drawable: Int,
    contentDescription: String = "",
    onItemClick: () -> Unit
) {
    Column(modifier = modifier) {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(10.dp))
                .background(md_theme_dark_primaryContainer)
        ) {
            Icon(
                painter = painterResource(id = drawable),
                contentDescription = contentDescription,
                tint = md_theme_dark_onSecondary,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        onItemClick()
                    }
                    .padding(8.dp)
            )
        }
    }
}