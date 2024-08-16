package com.compose.weatherapplite.presentation.weather.composables.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import java.util.concurrent.atomic.AtomicBoolean
import kotlinx.coroutines.delay

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
            if (isRunning.getAndSet(true)) {
                delay(14000)
            }

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
