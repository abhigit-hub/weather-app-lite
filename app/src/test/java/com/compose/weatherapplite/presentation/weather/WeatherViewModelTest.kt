package com.compose.weatherapplite.presentation.weather

import com.compose.weatherapplite.data.repositoryfake.fakeCurrentInfo
import com.compose.weatherapplite.data.repositoryfake.fakeCurrentUnitInfo
import com.compose.weatherapplite.data.repositoryfake.fakeHourlyInfo
import com.compose.weatherapplite.data.repositoryfake.fakeHourlyUnitInfo
import com.compose.weatherapplite.data.repositoryfake.fakeLocationLatitude
import com.compose.weatherapplite.data.repositoryfake.fakeLocationLongitude
import com.compose.weatherapplite.domain.model.GeoCodingInfo
import com.compose.weatherapplite.domain.model.WeatherInfo
import com.compose.weatherapplite.domain.repository.WeatherRepository
import com.compose.weatherapplite.manager.WeatherLocationManager
import com.compose.weatherapplite.presentation.mapper.toWeatherState
import com.compose.weatherapplite.presentation.model.WeatherMenuSelectorType
import com.compose.weatherapplite.presentation.model.WeatherState
import com.compose.weatherapplite.utils.Resource
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import retrofit2.HttpException

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class WeatherViewModelTest {

    @MockK
    private lateinit var weatherRepository: WeatherRepository

    @MockK
    private lateinit var weatherLocationManager: WeatherLocationManager

    private lateinit var weatherViewModel: WeatherViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        weatherViewModel = WeatherViewModel(
            repository = weatherRepository,
            weatherLocationManager = weatherLocationManager
        )
    }

    @Test
    fun `test initiateApiRequest processes weather & geocoding response with success`() = runTest {
        // Setup
        val mockLatitude = fakeLocationLatitude()
        val mockLongitude = fakeLocationLongitude()
        val mockResponseWeatherApi = Resource.Success(
            data = mockk<WeatherInfo>(relaxed = true).apply {
                every { latitude } returns mockLatitude
                every { longitude } returns mockLongitude
                every { current } returns fakeCurrentInfo()
                every { currentUnit } returns fakeCurrentUnitInfo()
                every { hourly } returns fakeHourlyInfo()
                every { hourlyUnit } returns fakeHourlyUnitInfo()
            }
        )
        val mockResponseGeoCodingApi = Resource.Success(
            data = GeoCodingInfo(
                cityName = "Whitefield, Bangalore, Karnataka"
            )
        )
        val mockException = mockk<HttpException>()

        coEvery {
            weatherRepository.getWeatherForecastAndCurrent(
                latitude = mockLatitude.toString(),
                longitude = mockLongitude.toString()
            )
        } returns mockResponseWeatherApi
        coEvery {
            weatherRepository.getLocalityBasedOnCoordinates(
                latitude = mockLatitude.toString(),
                longitude = mockLongitude.toString()
            )
        } returns mockResponseGeoCodingApi

        // Action
        val spyWeatherViewModel = spyk(weatherViewModel)
        spyWeatherViewModel.initiateApiRequest(mockLatitude, mockLongitude)
        advanceUntilIdle()

        // Assert
        coVerify {
            weatherRepository.getWeatherForecastAndCurrent(
                mockLatitude.toString(),
                mockLongitude.toString()
            )
        }
        coVerify {
            weatherRepository.getLocalityBasedOnCoordinates(
                mockLatitude.toString(),
                mockLongitude.toString()
            )
        }
        coVerify { spyWeatherViewModel.processWeatherApiResponse(mockResponseWeatherApi) }
        coVerify { spyWeatherViewModel.processGeoCodingApiResponse(mockResponseGeoCodingApi) }
        coVerify(exactly = 0) { mockException.printStackTrace() }
    }

    @Test
    fun `test initiateApiRequest processes weather and geocoding response with error`() = runTest {
        // Setup
        val mockLatitude = fakeLocationLatitude()
        val mockLongitude = fakeLocationLongitude()
        val mockResponseWeatherApi = Resource.Error(
            message = "",
            data = mockk<WeatherInfo>(relaxed = true)
        )
        val mockResponseGeoCodingApi = Resource.Error(
            message = "",
            data = mockk<GeoCodingInfo>(relaxed = true)
        )
        coEvery {
            weatherRepository.getWeatherForecastAndCurrent(
                mockLatitude.toString(),
                mockLongitude.toString()
            )
        } returns mockResponseWeatherApi
        coEvery {
            weatherRepository.getLocalityBasedOnCoordinates(
                mockLatitude.toString(),
                mockLongitude.toString()
            )
        } returns mockResponseGeoCodingApi

        // Action
        val spyWeatherViewModel = spyk(weatherViewModel)
        spyWeatherViewModel.initiateApiRequest(mockLatitude, mockLongitude)
        advanceUntilIdle()

        // Assert
        coVerify { spyWeatherViewModel.processWeatherApiResponse(mockResponseWeatherApi) }
        coVerify { spyWeatherViewModel.processGeoCodingApiResponse(mockResponseGeoCodingApi) }
    }

    @Test
    fun `test processGeoCodingApiResponse updates state on success response`() {
        // Setup
        val geoCodingInfo = GeoCodingInfo(
            cityName = "Whitefield, Bangalore, Karnataka"
        )
        val responseForGeoCodingApi = Resource.Success(geoCodingInfo)

        // Action
        weatherViewModel.processGeoCodingApiResponse(responseForGeoCodingApi)

        // Assert
        assertEquals(
            "Whitefield, Bangalore, Karnataka",
            weatherViewModel.state.locationState.cityName
        )
        assertEquals(
            "Whitefield, Karnataka",
            weatherViewModel.state.locationState.cityShortenedName
        )
    }

    @Test
    fun `test processGeoCodingApiResponse updates state on error response`() {
        // Setup
        val mockWeatherState = mockk<WeatherState>()
        val responseForGeoCodingApi = Resource.Error(
            message = "",
            data = mockk<GeoCodingInfo>()
        )
        weatherViewModel.state = mockWeatherState

        // Action
        weatherViewModel.processGeoCodingApiResponse(responseForGeoCodingApi)

        // Assert
        assertEquals(mockWeatherState, weatherViewModel.state)
    }

    @Test
    fun `test processWeatherApiResponse updates state on success response`() {
        // Setup
        val weatherInfo = WeatherInfo(
            latitude = fakeLocationLatitude(),
            longitude = fakeLocationLongitude(),
            currentUnit = fakeCurrentUnitInfo(),
            current = fakeCurrentInfo(),
            hourlyUnit = fakeHourlyUnitInfo(),
            hourly = fakeHourlyInfo()
        )
        val weatherState = weatherInfo.toWeatherState()
        val responseForWeatherApi = Resource.Success(weatherInfo)

        // Action
        weatherViewModel.processWeatherApiResponse(responseForWeatherApi)

        // Assert
        assertEquals(
            fakeLocationLatitude().toString(),
            weatherViewModel.state.locationState.latitude.toString()
        )
        assertEquals(
            fakeLocationLongitude().toString(),
            weatherViewModel.state.locationState.longitude.toString()
        )
        assertEquals(
            weatherState,
            weatherViewModel.state
        )
    }

    @Test
    fun `test processWeatherApiResponse updates state on error response`() {
        // Setup
        val mockWeatherState = mockk<WeatherState>()
        val responseForWeatherApi = Resource.Error(
            message = "",
            data = mockk<WeatherInfo>()
        )
        weatherViewModel.state = mockWeatherState

        // Action
        weatherViewModel.processWeatherApiResponse(responseForWeatherApi)

        // Assert
        assertEquals(mockWeatherState, weatherViewModel.state)
    }

    @Test
    fun `test updateWeatherMenuSelectorType returns when state updated is correct`() {
        // Setup
        val weatherMenuSelectorType = WeatherMenuSelectorType.WeatherMenuSelectorTypeToday

        // Action
        weatherViewModel.updateWeatherMenuSelectorType(
            weatherMenuSelectorType = WeatherMenuSelectorType.WeatherMenuSelectorTypeToday
        )

        // Assert
        assertEquals(weatherMenuSelectorType, weatherViewModel.state.weatherMenuSelectorType)
    }

    @Test
    fun `test toggleDarkThemeEnabledState returns false when isDarkThemeEnabledState is true`() {
        // Setup
        weatherViewModel.isDarkThemeEnabledState = true

        // Action
        weatherViewModel.toggleDarkThemeEnabledState()

        // Assert
        assertEquals(false, weatherViewModel.isDarkThemeEnabledState)
    }

    @Test
    fun `test toggleDarkThemeEnabledState returns true when isDarkThemeEnabledState is false`() {
        // Setup
        weatherViewModel.isDarkThemeEnabledState = false

        // Action
        weatherViewModel.toggleDarkThemeEnabledState()

        // Assert
        assertEquals(true, weatherViewModel.isDarkThemeEnabledState)
    }
}
