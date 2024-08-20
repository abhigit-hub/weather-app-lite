package com.compose.weatherapplite.data.mapper

import com.compose.weatherapplite.data.remote.GeoCodingApi
import com.compose.weatherapplite.data.remote.dto.AddressDTO
import com.compose.weatherapplite.data.remote.dto.GoogleGeoCodingDTO
import com.compose.weatherapplite.utils.WeatherAppConstants
import org.junit.Assert.assertEquals
import org.junit.Test

class GeoCodingMapperDataToDomainTest {

    companion object {
        private const val CITY_UNKNOWN = WeatherAppConstants.WEATHER_UNKNOWN_LOCATION
        private const val CITY = "City Name"
        private const val CITY_1 = "City Name 1"
        private const val CITY_2 = "City Name 2"
        private const val STATUS_OK = "ok"
        private const val RESULT_TYPE_VALID = GeoCodingApi.ADDITIONAL_QUERY_PARAMS_FOR_RESULT_TYPE
        private const val RESULT_TYPE_INVALID = "non matching type"
    }

    @Test
    fun `test toGeoCodingInfo when results not contain matching type`() {
        // Setup
        val addressDTO = AddressDTO(
            formattedAddress = CITY_1,
            types = listOf(RESULT_TYPE_INVALID)
        )
        val googleGeoCodingDTO = GoogleGeoCodingDTO(
            results = listOf(addressDTO),
            status = STATUS_OK,
            plusCode = null
        )

        // Action
        val result = googleGeoCodingDTO.toGeoCodingInfo()

        // Assert
        assertEquals(CITY_UNKNOWN, result.cityName)
    }

    @Test
    fun `toGeoCodingInfo returns unknown locality for empty result list`() {
        // Setup
        val googleGeoCodingDTO = GoogleGeoCodingDTO(
            results = emptyList(),
            status = STATUS_OK,
            plusCode = null
        )

        // Action
        val result = googleGeoCodingDTO.toGeoCodingInfo()

        // Assert
        assertEquals(CITY_UNKNOWN, result.cityName)
    }

    @Test
    fun `test toGeoCodingInfo when results contain matching type`() {
        // Setup
        val addressDTO = AddressDTO(
            formattedAddress = CITY,
            types = listOf(RESULT_TYPE_VALID)
        )
        val googleGeoCodingDTO = GoogleGeoCodingDTO(
            results = listOf(addressDTO),
            status = STATUS_OK,
            plusCode = null
        )

        // Action
        val result = googleGeoCodingDTO.toGeoCodingInfo()

        // Assert
        assertEquals(CITY, result.cityName)
    }

    @Test
    fun `test toGeoCodingInfo when results contain matching type and address dto size is one`() {
        // Setup
        val addressDTO1 = AddressDTO(
            formattedAddress = CITY_1,
            types = listOf(GeoCodingApi.ADDITIONAL_QUERY_PARAMS_FOR_RESULT_TYPE)
        )
        val addressDTO2 = AddressDTO(
            formattedAddress = CITY_2,
            types = listOf(GeoCodingApi.ADDITIONAL_QUERY_PARAMS_FOR_RESULT_TYPE)
        )
        val googleGeoCodingDTO = GoogleGeoCodingDTO(
            results = listOf(addressDTO1, addressDTO2),
            status = STATUS_OK,
            plusCode = null
        )

        // Action
        val result = googleGeoCodingDTO.toGeoCodingInfo()

        // Assert
        assertEquals(CITY_1, result.cityName)
    }

    @Test
    fun `test toGeoCodingInfo when results contain matching type and address dto size is zero`() {
        // Setup
        val googleGeoCodingDTO = GoogleGeoCodingDTO(
            results = listOf(),
            status = STATUS_OK,
            plusCode = null
        )

        // Action
        val result = googleGeoCodingDTO.toGeoCodingInfo()

        // Assert
        assertEquals(CITY_UNKNOWN, result.cityName)
    }
}
