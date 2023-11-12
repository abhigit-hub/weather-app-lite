package com.compose.weatherapplite.presentation.weather.composables.weatherdetails

import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.presentation.model.WeatherDetailsItemMetaState
import com.compose.weatherapplite.presentation.model.WeatherState
import com.compose.weatherapplite.ui.theme.WeatherTypography
import com.compose.weatherapplite.utils.toAnimatedVectorDrawable
import com.compose.weatherapplite.utils.toDayOfWeek
import com.compose.weatherapplite.utils.toDrawable
import kotlinx.coroutines.delay
import java.util.concurrent.atomic.AtomicBoolean

@Composable
fun WeatherDetailsHistoryQuickView(
    weatherState: WeatherState
) {
    weatherState.nextTenDaysWeatherDetailsItemListState.forEach { weatherDetailsItemMetaData ->
        Spacer(modifier = Modifier.height(2.dp))
        WeatherDetailsHistoryQuickViewItem(weatherDetailsItemMetaData = weatherDetailsItemMetaData)
        Spacer(modifier = Modifier.height(2.dp))
    }
}

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun WeatherDetailsHistoryQuickViewItem(weatherDetailsItemMetaData: WeatherDetailsItemMetaState) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = weatherDetailsItemMetaData.time.toDayOfWeek(),
            color = MaterialTheme.colorScheme.primary,
            style = WeatherTypography.titleMedium,
            modifier = Modifier.weight(0.2f).padding(start = 12.dp)
        )

        WeatherDetailsTemperatureBarView(
            minTemperature = weatherDetailsItemMetaData.minTemperature,
            maxTemperature = weatherDetailsItemMetaData.maxTemperature,
            modifier = Modifier.weight(0.55f)
        )

        val vector = AnimatedImageVector.animatedVectorResource(
            id = weatherDetailsItemMetaData.weatherCode.toAnimatedVectorDrawable()
        )
        var atEnd by remember { mutableStateOf(true) }
        var isRunning = AtomicBoolean(false)

        suspend fun runAnimation() {
            while (true) {
                if (isRunning.getAndSet(true))
                    delay(14000)

                atEnd = !atEnd
            }
        }

        // This is necessary just if you want to run the animation when the
        // component is displayed. Otherwise, you can remove it.
        LaunchedEffect(Unit) {
            runAnimation()
        }

        Image(
            painter = rememberAnimatedVectorPainter(animatedImageVector = vector, atEnd = atEnd),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
        )
    }
}