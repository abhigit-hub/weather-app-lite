package com.compose.weatherapplite.data.repository

import android.net.http.HttpException
import com.compose.weatherapplite.data.mapper.toGeoCodingInfo
import com.compose.weatherapplite.data.mapper.toWeatherInfo
import com.compose.weatherapplite.data.remote.GeoCodingApi
import com.compose.weatherapplite.data.remote.WeatherApi
import com.compose.weatherapplite.data.remote.dto.WeatherDTO
import com.compose.weatherapplite.data.repositoryfake.fakeLocationLatitude
import com.compose.weatherapplite.data.repositoryfake.fakeLocationLongitude
import com.compose.weatherapplite.data.repositoryfake.getFakeGeoCodingLocationBangalore
import com.compose.weatherapplite.domain.repository.WeatherRepository
import com.compose.weatherapplite.utils.Resource
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class WeatherRepositoryImplTest {

    @MockK
    private lateinit var weatherApi: WeatherApi

    @MockK
    private lateinit var geoCodingApi: GeoCodingApi

    private lateinit var weatherRepository: WeatherRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        weatherRepository = WeatherRepositoryImpl(
            weatherApi = weatherApi,
            geoCodingApi = geoCodingApi
        )
    }

    @Test
    fun `test getWeatherForecastAndCurrent returns Resource_Success when api call succeeds`() =
        runBlocking {
            // Setup
            val mockWeatherDTOResponse = WeatherDTO(
                latitude = fakeLocationLatitude(),
                longitude = fakeLocationLongitude(),
                timeInMillis = "10_000_000",
                timezone = "UTC+3",
                timezoneAbbreviation = "na",
                elevation = 350,
                currentUnitDTO = mockk(relaxed = true),
                currentDTO = mockk(relaxed = true),
                hourlyUnitDTO = mockk(relaxed = true),
                hourlyDTO = mockk(relaxed = true)
            )
            val expectedWeatherInfo = mockWeatherDTOResponse.toWeatherInfo()
            coEvery {
                weatherApi.getForecastAndCurrentWeather(
                    fakeLocationLatitude().toString(),
                    fakeLocationLongitude().toString()
                )
            } returns mockWeatherDTOResponse

            // Action
            val result = weatherRepository.getWeatherForecastAndCurrent(
                latitude = fakeLocationLatitude().toString(),
                longitude = fakeLocationLongitude().toString()
            )

            // Assert
            assert(result is Resource.Success)
            assertEquals(expectedWeatherInfo, (result as Resource.Success).data)
        }

    @Test
    fun `test getWeatherForecastAndCurrent returns Resource_Error when api call fails`() =
        runBlocking {
            // Setup
            val httpException = mockk<HttpException>()
            coEvery {
                weatherApi.getForecastAndCurrentWeather(
                    latitude = fakeLocationLatitude().toString(),
                    longitude = fakeLocationLongitude().toString()
                )
            } throws httpException

            // Action
            val result = weatherRepository.getWeatherForecastAndCurrent(
                latitude = fakeLocationLatitude().toString(),
                longitude = fakeLocationLongitude().toString()
            )

            // Assert
            assert(result is Resource.Error)
            assertEquals("Failed api request", (result as Resource.Error).message)
        }

    @Test
    fun `test getLocalityBasedOnCoordinates returns Resource_Success when api call succeeds`() =
        runBlocking {
            // Setup
            val mockGeoCodingDTOResponse = getFakeGeoCodingLocationBangalore()
            val expectedGeoCodingInfo = mockGeoCodingDTOResponse.toGeoCodingInfo()
            coEvery {
                geoCodingApi.getLocalityFromCoordinatesUsingGeoCodingApi(
                    resultType = GeoCodingApi.ADDITIONAL_QUERY_PARAMS_FOR_RESULT_TYPE,
                    apiKey = GeoCodingApi.GMAP_API_KEY,
                    latLng = fakeLocationLatitude().toString() + "," +
                        fakeLocationLongitude().toString()
                )
            } returns mockGeoCodingDTOResponse

            // Action
            val result = weatherRepository.getLocalityBasedOnCoordinates(
                latitude = fakeLocationLatitude().toString(),
                longitude = fakeLocationLongitude().toString()
            )

            // Assert
            assert(result is Resource.Success)
            assertEquals(expectedGeoCodingInfo, (result as Resource.Success).data)
        }

    @Test
    fun `test getLocalityBasedOnCoordinates returns Resource_Error when api call fails`() =
        runBlocking {
            // Setup
            val httpException = mockk<HttpException>()
            coEvery {
                geoCodingApi.getLocalityFromCoordinatesUsingGeoCodingApi(
                    resultType = GeoCodingApi.ADDITIONAL_QUERY_PARAMS_FOR_RESULT_TYPE,
                    apiKey = GeoCodingApi.GMAP_API_KEY,
                    latLng = fakeLocationLatitude().toString() + "," +
                        fakeLocationLongitude().toString()
                )
            } throws httpException

            // Action
            val result = weatherRepository.getLocalityBasedOnCoordinates(
                latitude = fakeLocationLatitude().toString(),
                longitude = fakeLocationLongitude().toString()
            )

            // Assert
            assert(result is Resource.Error)
            assertEquals("Failed api request", (result as Resource.Error).message)
        }
}
