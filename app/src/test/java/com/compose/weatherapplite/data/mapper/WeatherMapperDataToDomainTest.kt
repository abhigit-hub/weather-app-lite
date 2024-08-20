package com.compose.weatherapplite.data.mapper

import com.compose.weatherapplite.data.remote.dto.CurrentDTO
import com.compose.weatherapplite.data.remote.dto.CurrentUnitDTO
import com.compose.weatherapplite.data.remote.dto.HourlyDTO
import com.compose.weatherapplite.data.remote.dto.HourlyUnitDTO
import com.compose.weatherapplite.utils.toLocalDate
import org.junit.Assert.assertEquals
import org.junit.Test

class WeatherMapperDataToDomainTest {

    companion object {
        private const val WEATHER_TIME = "2024-11-01T07:30"
        private const val WEATHER_TEMPERATURE = "22.5"
        private const val WEATHER_HUMIDITY = "75"
        private const val WEATHER_WIND_SPEED = "5.4"
        private const val WEATHER_CODE = 66
        private const val WEATHER_INTERVAL = 1000
        private const val WEATHER_INTERVAL_TIME_UNIT = "seconds"

        private val WEATHER_TIME_LIST = listOf("2024-11-01T07:30", "2024-11-02T07:30")
        private val WEATHER_TEMPERATURE_LIST = listOf(22.5, 22.6)
        private val WEATHER_HUMIDITY_LIST = listOf(75, 76)
        private val WEATHER_WIND_SPEED_LIST = listOf(5.4, 5.5)
        private val WEATHER_CODE_LIST = listOf(66, 67)
    }

    @Test
    fun `test toHourlyUnitInfo correctly maps properties`() {
        // Setup
        val hourlyUnitDTO = HourlyUnitDTO(
            time = WEATHER_TIME,
            temperature = WEATHER_TEMPERATURE,
            humidity = WEATHER_HUMIDITY,
            windspeed = WEATHER_WIND_SPEED
        )

        // Action
        val result = hourlyUnitDTO.toHourlyUnitInfo()

        // Assert
        assertEquals(WEATHER_TIME, result.time)
        assertEquals(WEATHER_TEMPERATURE, result.temperature)
        assertEquals(WEATHER_HUMIDITY, result.humidity)
        assertEquals(WEATHER_WIND_SPEED, result.windspeed)
    }

    @Test
    fun `test toHourlyInfo correctly maps properties`() {
        // Setup
        val hourlyDTO = HourlyDTO(
            time = WEATHER_TIME_LIST,
            temperature = WEATHER_TEMPERATURE_LIST,
            humidity = WEATHER_HUMIDITY_LIST,
            windspeed = WEATHER_WIND_SPEED_LIST,
            weathercodes = WEATHER_CODE_LIST
        )

        // Action
        val result = hourlyDTO.toHourlyInfo()
        val expectedTimeListResult = WEATHER_TIME_LIST.map { it.toLocalDate() }

        // Assert
        assertEquals(
            expectedTimeListResult,
            result.time
        )
        assertEquals(WEATHER_TEMPERATURE_LIST, result.temperature)
        assertEquals(WEATHER_HUMIDITY_LIST, result.humidity)
        assertEquals(WEATHER_WIND_SPEED_LIST, result.windspeed)
        assertEquals(WEATHER_CODE_LIST, result.weatherCodes)
    }

    @Test
    fun `test toCurrentUnitInfo correctly maps properties`() {
        // Setup
        val currentUnitDTO = CurrentUnitDTO(
            time = WEATHER_TIME,
            interval = WEATHER_INTERVAL_TIME_UNIT,
            temperature = WEATHER_TEMPERATURE,
            windspeed = WEATHER_WIND_SPEED
        )

        // Action
        val result = currentUnitDTO.toCurrentUnitInfo()

        // Assert
        assertEquals(WEATHER_TIME, result.time)
        assertEquals(WEATHER_INTERVAL_TIME_UNIT, result.interval)
        assertEquals(WEATHER_TEMPERATURE, result.temperature)
        assertEquals(WEATHER_WIND_SPEED, result.windspeed)
    }

    @Test
    fun `test toCurrentInfo correctly maps properties`() {
        // Setup
        val currentDTO = CurrentDTO(
            time = WEATHER_TIME,
            interval = WEATHER_INTERVAL,
            temperature = WEATHER_TEMPERATURE.toDouble(),
            windspeed = WEATHER_WIND_SPEED.toDouble(),
            weathercode = WEATHER_CODE
        )

        // Action
        val result = currentDTO.toCurrentInfo()

        // Assert
        assertEquals(WEATHER_TIME, result.time)
        assertEquals(WEATHER_INTERVAL, result.interval)
        assertEquals(WEATHER_TEMPERATURE.toDouble(), result.temperature, 0.0)
        assertEquals(WEATHER_WIND_SPEED.toDouble(), result.windspeed, 0.0)
        assertEquals(WEATHER_CODE, result.weatherCode)
    }
}
