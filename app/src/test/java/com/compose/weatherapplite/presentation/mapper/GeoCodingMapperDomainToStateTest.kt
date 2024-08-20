package com.compose.weatherapplite.presentation.mapper

import com.compose.weatherapplite.domain.model.GeoCodingInfo
import org.junit.Assert.assertEquals
import org.junit.Test

class GeoCodingMapperDomainToStateTest {

    @Test
    fun `test toGeoCodingState correctly maps properties - 1`() {
        // Setup
        val geoCodingInfo = GeoCodingInfo(
            cityName = "Whitefield, Bangalore, Karnataka"
        )

        // Action
        val result = geoCodingInfo.toGeoCodingState()

        // Assert
        assertEquals("Whitefield, Bangalore, Karnataka", result.cityName)
        assertEquals("Whitefield, Karnataka", result.cityShortenedName)
    }

    @Test
    fun `test toGeoCodingState correctly maps properties - 2`() {
        // Setup
        val geoCodingInfo = GeoCodingInfo(
            cityName = "Whitefield, Karnataka"
        )

        // Action
        val result = geoCodingInfo.toGeoCodingState()

        // Assert
        assertEquals("Whitefield, Karnataka", result.cityName)
        assertEquals("Whitefield, Karnataka", result.cityShortenedName)
    }
}
