package com.compose.weatherapplite.utils

import io.mockk.impl.annotations.RelaxedMockK
import java.time.LocalDate
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class GenericExtensionsTest {

    @RelaxedMockK
    private val date = LocalDate.now()

    @RelaxedMockK
    private val mockedPastDate = LocalDate.now().minusDays(1)

    @RelaxedMockK
    private val mockedFutureDate = LocalDate.now().plusDays(1)

    @Test
    fun `toDayOfWeek returns Today for current date`() {
        // Action
        val result = date.toDayOfWeek()

        // Assert
        assertEquals("Today", result)
    }

    @Test
    fun `toDayOfWeek returns correct day name for past date`() {
        // Action
        val result = mockedPastDate.toDayOfWeek()

        // Assert
        assertNotEquals("Today", result)
    }

    @Test
    fun `toDayOfWeek returns correct day name for future date`() {
        // Action
        val result = mockedFutureDate.toDayOfWeek()

        // Assert
        assertNotEquals("Today", result)
    }
}
