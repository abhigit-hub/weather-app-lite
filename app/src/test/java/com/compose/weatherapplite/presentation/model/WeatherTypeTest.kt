package com.compose.weatherapplite.presentation.model

import org.junit.Assert
import org.junit.Test

class WeatherTypeTest {

    @Test
    fun `test isUnknownWeather returns true when weather type is unknown`() {
        // Action
        val result = WeatherType.Unknown.isUnknownWeather()

        // Assert
        Assert.assertEquals(true, result)
    }

    @Test
    fun `test isUnknownWeather returns false when weather type is known`() {
        // Action
        val result1 = WeatherType.ClearSky.isUnknownWeather()
        val result2 = WeatherType.Rain.isUnknownWeather()
        val result3 = WeatherType.Drizzle.isUnknownWeather()
        val result4 = WeatherType.Thunderstorm.isUnknownWeather()

        // Assert
        Assert.assertEquals(false, result1)
        Assert.assertEquals(false, result2)
        Assert.assertEquals(false, result3)
        Assert.assertEquals(false, result4)
    }
}
