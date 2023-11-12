package com.compose.weatherapplite.presentation.weather.composables.weather

import androidx.annotation.DrawableRes
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.presentation.model.CurrentWeatherState
import com.compose.weatherapplite.presentation.weather.composables.common.WeatherSummaryView
import com.compose.weatherapplite.ui.theme.WeatherTypography
import com.compose.weatherapplite.utils.toAnimatedVectorDrawable
import kotlinx.coroutines.delay
import java.util.concurrent.atomic.AtomicBoolean

@Composable
fun WeatherCurrentInfoView(
    currentWeatherState: CurrentWeatherState
) {
    Column {
        Row {
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.17f)
                    .weight(0.5f)
            ) {
                Text(
                    text = currentWeatherState.temperature,
                    style = WeatherTypography.displayLarge,
                    color = MaterialTheme.colorScheme.primary,
                )
                Text(
                    text = currentWeatherState.weatherType.weatherType,
                    style = WeatherTypography.titleLarge,
                    color = MaterialTheme.colorScheme.secondary,
                )
            }

            AnimatedVector(
                currentWeatherState.weatherType.toAnimatedVectorDrawable(),
                modifier = Modifier
                    .size(150.dp)
                    .fillMaxWidth()
                    .weight(0.4f)
                    .scale(1.25f, 1.25f)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        WeatherSummaryView(currentWeatherState)
    }
}

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun AnimatedVector(
    @DrawableRes drawable: Int,
    modifier: Modifier
) {
    val vector = AnimatedImageVector.animatedVectorResource(id = drawable)
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
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}