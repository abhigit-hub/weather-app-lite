package com.compose.weatherapplite.utils

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class GenericExtensionsTest {

    companion object {
        private const val DAYS_TO_ADD = 1L
        private const val TODAY = WeatherAppConstants.DAY_OF_WEEK_TODAY
    }

    @Test
    fun `test convertToWeatherAppLiteDate returns correct formatted date - 1`() {
        // Setup
        val date = LocalDate.of(2024, Month.AUGUST, 23)

        // Action
        val result = date.convertToWeatherAppLiteDate()

        // Assert
        assertEquals("23 AUGUST, FRIDAY", result)
    }

    @Test
    fun `test convertToWeatherAppLiteDate returns correct formatted date - 2`() {
        // Setup
        val date = LocalDate.of(2024, Month.JANUARY, 1)

        // Action
        val result = date.convertToWeatherAppLiteDate()

        // Assert
        assertEquals("1 JANUARY, MONDAY", result)
    }

    @Test
    fun `test toTimeInTheDay returns correct time in AM`() {
        // Setup
        val localDateTime = LocalDateTime.of(2024, 8, 23, 9, 0)

        // Act
        val result = localDateTime.toTimeInTheDay()

        // Assert
        assertEquals("9 ${WeatherAppConstants.KEY_ANTE_MERIDIEM}", result)
    }

    @Test
    fun `test toTimeInTheDay returns correct time in PM`() {
        // Setup
        val localDateTime = LocalDateTime.of(2024, 8, 23, 15, 0)

        // Act
        val result = localDateTime.toTimeInTheDay()

        // Assert
        assertEquals("3 ${WeatherAppConstants.KEY_POST_MERIDIEM}", result)
    }

    @Test
    fun `test toTimeInTheDay returns 12 AM for midnight`() {
        // Setup
        val localDateTime = LocalDateTime.of(2024, 8, 23, 0, 0)

        // Act
        val result = localDateTime.toTimeInTheDay()

        // Assert
        assertEquals("12 ${WeatherAppConstants.KEY_ANTE_MERIDIEM}", result)
    }

    @Test
    fun `test toTimeInTheDay returns 12 PM for noon`() {
        // Setup
        val localDateTime = LocalDateTime.of(2024, 8, 23, 12, 0)

        // Act
        val result = localDateTime.toTimeInTheDay()

        // Assert
        assertEquals("12 ${WeatherAppConstants.KEY_POST_MERIDIEM}", result)
    }

    @Test
    fun `test toDayOfWeek returns Today for current date`() {
        // Action
        val result = LocalDate.now().toDayOfWeek()

        // Assert
        assertEquals(TODAY, result)
    }

    @Test
    fun `test toDayOfWeek returns correct day name for past date`() {
        // Action
        val result = LocalDate.now().plusDays(DAYS_TO_ADD).toDayOfWeek()

        // Assert
        assertNotEquals(TODAY, result)
    }

    @Test
    fun `test toDayOfWeek returns correct day name for future date`() {
        // Action
        val result = LocalDate.now().plusDays(DAYS_TO_ADD).toDayOfWeek()

        // Assert
        assertNotEquals(TODAY, result)
    }

    @Test
    fun `test toShortenedCityName returns first and third part for three-part city names`() {
        // Setup
        val cityName = "New York, NY, USA"

        // Action
        val result = cityName.toShortenedCityName()

        // Assert
        assertEquals("New York, USA", result)
    }

    @Test
    fun `test toShortenedCityName returns the original name for one-part city name`() {
        // Setup
        val cityName = "Paris"

        // Action
        val result = cityName.toShortenedCityName()

        // Assert
        assertEquals("Paris", result)
    }

    @Test
    fun `test toShortenedCityName returns the original name for other sizes`() {
        // Setup
        val cityName = "Los Angeles, California"

        // Action
        val result = cityName.toShortenedCityName()

        // Assert
        assertEquals("Los Angeles, California", result)
    }

    @Test
    fun `test toShortenedCityName for edge cases with empty strings`() {
        // Setup
        val cityName = ""

        // Action
        val result = cityName.toShortenedCityName()

        // Assert
        assertEquals("", result)
    }

    @Test
    fun `test toShortenedCityName returns first and second part for two-part city names`() {
        // Setup
        val cityName = "Tokyo, Japan"

        // Action
        val result = cityName.toShortenedCityName()

        // Assert
        assertEquals("Tokyo, Japan", result)
    }

    @Test
    fun `test checkIfDateRangeMatches returns true when date in range`() {
        // Setup
        val localDate = LocalDate.now()
        val localDatePast = LocalDate.now().minusDays(3).minusMonths(1)
        val localDateFuture = LocalDate.now().plusDays(3).plusYears(1)

        // Action
        val result = localDate.checkIfDateRangeMatches(
            filterDate1 = localDatePast,
            filterDate2 = localDateFuture
        )

        // Assert
        assertEquals(true, result)
    }

    @Test
    fun `test checkIfDateRangeMatches returns false when date not in range - 1`() {
        // Setup
        val localDate = LocalDate.now()
        val localDatePast = LocalDate.now().plusDays(1)
        val localDateFuture = LocalDate.now().plusDays(3)

        // Action
        val result = localDate.checkIfDateRangeMatches(
            filterDate1 = localDatePast,
            filterDate2 = localDateFuture
        )

        // Assert
        assertEquals(false, result)
    }

    @Test
    fun `test checkIfDateRangeMatches returns false when date not in range - 2`() {
        // Setup
        val localDate = LocalDate.now()
        val localDatePast = LocalDate.now()
        val localDateFuture = LocalDate.now().minusDays(1)

        // Action
        val result = localDate.checkIfDateRangeMatches(
            filterDate1 = localDatePast,
            filterDate2 = localDateFuture
        )

        // Assert
        assertEquals(false, result)
    }

    @Test
    fun `test checkIfDateMatches returns true when date matches`() {
        // Setup
        val localDate = LocalDate.now()
        val localDateToBeMatched = LocalDate.now()

        // Action
        val result = localDate.checkIfDateMatches(
            filterDate = localDateToBeMatched
        )

        // Assert
        assertEquals(true, result)
    }

    @Test
    fun `test checkIfDateMatches returns false when date doesnt match - 1`() {
        // Setup
        val localDate = LocalDate.now()
        val localDateToBeMatched = LocalDate.now().minusDays(1)

        // Action
        val result = localDate.checkIfDateMatches(
            filterDate = localDateToBeMatched
        )

        // Assert
        assertEquals(false, result)
    }

    @Test
    fun `test checkIfDateMatches returns false when date doesnt match - 2`() {
        // Setup
        val localDate = LocalDate.now()
        val localDateToBeMatched = LocalDate.now().plusDays(1)

        // Action
        val result = localDate.checkIfDateMatches(
            filterDate = localDateToBeMatched
        )

        // Assert
        assertEquals(false, result)
    }
}
