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
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

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
                .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Icon(
                painter = painterResource(id = drawable),
                contentDescription = contentDescription,
                tint = MaterialTheme.colorScheme.onSecondary,
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
