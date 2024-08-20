package com.compose.weatherapplite.utils

import com.compose.weatherapplite.R
import com.compose.weatherapplite.presentation.model.WeatherType
import org.junit.Assert.assertEquals
import org.junit.Test

class WeatherTypeExtensionsTest {

    @Test
    fun `toDrawable returns correct drawable for ClearSky`() {
        // Action
        val result = WeatherType.ClearSky.toDrawable()

        // Assert
        assertEquals(R.drawable.vd_clear_sky, result)
    }

    @Test
    fun `toDrawable returns correct drawable for Overcast`() {
        // Action
        val result = WeatherType.Overcast.toDrawable()

        // Assert
        assertEquals(R.drawable.vd_overcast, result)
    }

    @Test
    fun `toDrawable returns correct drawable for Foggy`() {
        // Action
        val result = WeatherType.Foggy.toDrawable()

        // Assert
        assertEquals(R.drawable.vd_foggy, result)
    }

    @Test
    fun `toDrawable returns correct drawable for Drizzle`() {
        // Action
        val result = WeatherType.Drizzle.toDrawable()

        // Assert
        assertEquals(R.drawable.vd_drizzle, result)
    }

    @Test
    fun `toDrawable returns correct drawable for Rain`() {
        // Action
        val result = WeatherType.Rain.toDrawable()

        // Assert
        assertEquals(R.drawable.vd_rain, result)
    }

    @Test
    fun `toDrawable returns correct drawable for HeavyRain`() {
        // Action
        val result = WeatherType.HeavyRain.toDrawable()

        // Assert
        assertEquals(R.drawable.vd_heavy_rain, result)
    }

    @Test
    fun `toDrawable returns correct drawable for SnowFall`() {
        // Action
        val result = WeatherType.SnowFall.toDrawable()

        // Assert
        assertEquals(R.drawable.vd_snowfall, result)
    }

    @Test
    fun `toDrawable returns correct drawable for Thunderstorm`() {
        // Action
        val result = WeatherType.Thunderstorm.toDrawable()

        // Assert
        assertEquals(R.drawable.vd_thunderstorm, result)
    }

    @Test
    fun `toAnimatedVectorDrawable returns correct drawable for ClearSky`() {
        // Action
        val result = WeatherType.ClearSky.toAnimatedVectorDrawable()

        // Assert
        assertEquals(R.drawable.avd_clear_sky, result)
    }

    @Test
    fun `toAnimatedVectorDrawable returns correct drawable for Overcast`() {
        // Action
        val result = WeatherType.Overcast.toAnimatedVectorDrawable()

        // Assert
        assertEquals(R.drawable.avd_overcast, result)
    }

    @Test
    fun `toAnimatedVectorDrawable returns correct drawable for Foggy`() {
        // Action
        val result = WeatherType.Foggy.toAnimatedVectorDrawable()

        // Assert
        assertEquals(R.drawable.avd_foggy, result)
    }

    @Test
    fun `toAnimatedVectorDrawable returns correct drawable for Drizzle`() {
        // Action
        val result = WeatherType.Drizzle.toAnimatedVectorDrawable()

        // Assert
        assertEquals(R.drawable.avd_drizzle, result)
    }

    @Test
    fun `toAnimatedVectorDrawable returns correct drawable for Rain`() {
        // Action
        val result = WeatherType.Rain.toAnimatedVectorDrawable()

        // Assert
        assertEquals(R.drawable.avd_rain, result)
    }

    @Test
    fun `toAnimatedVectorDrawable returns correct drawable for HeavyRain`() {
        // Action
        val result = WeatherType.HeavyRain.toAnimatedVectorDrawable()

        // Assert
        assertEquals(R.drawable.avd_heavy_rain, result)
    }

    @Test
    fun `toAnimatedVectorDrawable returns correct drawable for SnowFall`() {
        // Action
        val result = WeatherType.SnowFall.toAnimatedVectorDrawable()

        // Assert
        assertEquals(R.drawable.avd_snowfall, result)
    }

    @Test
    fun `toAnimatedVectorDrawable returns correct drawable for Thunderstorm`() {
        // Action
        val result = WeatherType.Thunderstorm.toAnimatedVectorDrawable()

        // Assert
        assertEquals(R.drawable.avd_thunderstorm, result)
    }
}
