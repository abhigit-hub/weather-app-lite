package com.compose.weatherapplite.presentation.mapper

import com.compose.weatherapplite.presentation.model.WeatherType
import com.compose.weatherapplite.utils.WeatherAppConstants
import org.junit.Assert.assertEquals
import org.junit.Test

class WeatherMapperDomainToStateTest {

    @Test
    fun `test toRainLevel returns correct rain level for weather code`() {
        // Action
        val result1 = WeatherAppConstants.WEATHER_CODE_CLEAR_SKY_1.toRainLevel()
        val result2 = WeatherAppConstants.WEATHER_CODE_OVERCAST_1.toRainLevel()
        val result3 = WeatherAppConstants.WEATHER_CODE_OVERCAST_2.toRainLevel()
        val result4 = WeatherAppConstants.WEATHER_CODE_OVERCAST_3.toRainLevel()
        val result5 = WeatherAppConstants.WEATHER_CODE_FOGGY_1.toRainLevel()
        val result6 = WeatherAppConstants.WEATHER_CODE_FOGGY_2.toRainLevel()
        val result7 = WeatherAppConstants.WEATHER_CODE_DRIZZLE_1.toRainLevel()
        val result8 = WeatherAppConstants.WEATHER_CODE_DRIZZLE_2.toRainLevel()
        val result9 = WeatherAppConstants.WEATHER_CODE_DRIZZLE_3.toRainLevel()
        val result10 = WeatherAppConstants.WEATHER_CODE_DRIZZLE_4.toRainLevel()
        val result11 = WeatherAppConstants.WEATHER_CODE_DRIZZLE_5.toRainLevel()
        val result12 = WeatherAppConstants.WEATHER_CODE_RAIN_1.toRainLevel()
        val result13 = WeatherAppConstants.WEATHER_CODE_RAIN_2.toRainLevel()
        val result14 = WeatherAppConstants.WEATHER_CODE_RAIN_3.toRainLevel()
        val result15 = WeatherAppConstants.WEATHER_CODE_HEAVYRAIN_1.toRainLevel()
        val result16 = WeatherAppConstants.WEATHER_CODE_HEAVYRAIN_2.toRainLevel()
        val result17 = WeatherAppConstants.WEATHER_CODE_SNOWFALL_1.toRainLevel()
        val result18 = WeatherAppConstants.WEATHER_CODE_SNOWFALL_2.toRainLevel()
        val result19 = WeatherAppConstants.WEATHER_CODE_SNOWFALL_3.toRainLevel()
        val result20 = WeatherAppConstants.WEATHER_CODE_THUNDERSTORM_1.toRainLevel()
        val result21 = WeatherAppConstants.WEATHER_CODE_THUNDERSTORM_2.toRainLevel()
        val result22 = WeatherAppConstants.WEATHER_CODE_THUNDERSTORM_3.toRainLevel()

        // Assert
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_NONE, result1)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_VERY_LOW, result2)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_VERY_LOW, result3)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_VERY_LOW, result4)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_NONE, result5)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_NONE, result6)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_LOW, result7)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_LOW, result8)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_LOW, result9)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_LOW, result10)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_LOW, result11)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_MODERATE, result12)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_MODERATE, result13)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_MODERATE, result14)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_VERY_HIGH, result15)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_VERY_HIGH, result16)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_VERY_LOW, result17)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_VERY_LOW, result18)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_VERY_LOW, result19)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_HIGH, result20)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_HIGH, result21)
        assertEquals(WeatherAppConstants.WEATHER_RAIN_LEVEL_HIGH, result22)
    }

    @Test
    fun `test toWeatherType returns correct weather type for weather code`() {
        // Action
        val result1 = WeatherAppConstants.WEATHER_CODE_CLEAR_SKY_1.toWeatherType()
        val result2 = WeatherAppConstants.WEATHER_CODE_OVERCAST_1.toWeatherType()
        val result3 = WeatherAppConstants.WEATHER_CODE_OVERCAST_2.toWeatherType()
        val result4 = WeatherAppConstants.WEATHER_CODE_OVERCAST_3.toWeatherType()
        val result5 = WeatherAppConstants.WEATHER_CODE_FOGGY_1.toWeatherType()
        val result6 = WeatherAppConstants.WEATHER_CODE_FOGGY_2.toWeatherType()
        val result7 = WeatherAppConstants.WEATHER_CODE_DRIZZLE_1.toWeatherType()
        val result8 = WeatherAppConstants.WEATHER_CODE_DRIZZLE_2.toWeatherType()
        val result9 = WeatherAppConstants.WEATHER_CODE_DRIZZLE_3.toWeatherType()
        val result10 = WeatherAppConstants.WEATHER_CODE_DRIZZLE_4.toWeatherType()
        val result11 = WeatherAppConstants.WEATHER_CODE_DRIZZLE_5.toWeatherType()
        val result12 = WeatherAppConstants.WEATHER_CODE_RAIN_1.toWeatherType()
        val result13 = WeatherAppConstants.WEATHER_CODE_RAIN_2.toWeatherType()
        val result14 = WeatherAppConstants.WEATHER_CODE_RAIN_3.toWeatherType()
        val result15 = WeatherAppConstants.WEATHER_CODE_HEAVYRAIN_1.toWeatherType()
        val result16 = WeatherAppConstants.WEATHER_CODE_HEAVYRAIN_2.toWeatherType()
        val result17 = WeatherAppConstants.WEATHER_CODE_SNOWFALL_1.toWeatherType()
        val result18 = WeatherAppConstants.WEATHER_CODE_SNOWFALL_2.toWeatherType()
        val result19 = WeatherAppConstants.WEATHER_CODE_SNOWFALL_3.toWeatherType()
        val result20 = WeatherAppConstants.WEATHER_CODE_THUNDERSTORM_1.toWeatherType()
        val result21 = WeatherAppConstants.WEATHER_CODE_THUNDERSTORM_2.toWeatherType()
        val result22 = WeatherAppConstants.WEATHER_CODE_THUNDERSTORM_3.toWeatherType()

        // Assert
        assertEquals(WeatherType.ClearSky, result1)
        assertEquals(WeatherType.Overcast, result2)
        assertEquals(WeatherType.Overcast, result3)
        assertEquals(WeatherType.Overcast, result4)
        assertEquals(WeatherType.Foggy, result5)
        assertEquals(WeatherType.Foggy, result6)
        assertEquals(WeatherType.Drizzle, result7)
        assertEquals(WeatherType.Drizzle, result8)
        assertEquals(WeatherType.Drizzle, result9)
        assertEquals(WeatherType.Drizzle, result10)
        assertEquals(WeatherType.Drizzle, result11)
        assertEquals(WeatherType.Rain, result12)
        assertEquals(WeatherType.Rain, result13)
        assertEquals(WeatherType.Rain, result14)
        assertEquals(WeatherType.HeavyRain, result15)
        assertEquals(WeatherType.HeavyRain, result16)
        assertEquals(WeatherType.SnowFall, result17)
        assertEquals(WeatherType.SnowFall, result18)
        assertEquals(WeatherType.SnowFall, result19)
        assertEquals(WeatherType.Thunderstorm, result20)
        assertEquals(WeatherType.Thunderstorm, result21)
        assertEquals(WeatherType.Thunderstorm, result22)
    }
}
