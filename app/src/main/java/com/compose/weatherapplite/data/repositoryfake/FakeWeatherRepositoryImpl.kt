package com.compose.weatherapplite.data.repositoryfake

import com.compose.weatherapplite.data.mapper.toGeoCodingInfo
import com.compose.weatherapplite.data.remote.GeoCodingApi
import com.compose.weatherapplite.data.remote.WeatherApi
import com.compose.weatherapplite.data.remote.dto.AddressDTO
import com.compose.weatherapplite.data.remote.dto.GoogleGeoCodingDTO
import com.compose.weatherapplite.domain.model.CurrentInfo
import com.compose.weatherapplite.domain.model.CurrentUnitInfo
import com.compose.weatherapplite.domain.model.GeoCodingInfo
import com.compose.weatherapplite.domain.model.HourlyInfo
import com.compose.weatherapplite.domain.model.HourlyUnitInfo
import com.compose.weatherapplite.domain.model.WeatherInfo
import com.compose.weatherapplite.domain.repository.WeatherRepository
import com.compose.weatherapplite.utils.Resource
import com.compose.weatherapplite.utils.toLocalDate
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeWeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    private val geoCodingApi: GeoCodingApi
): WeatherRepository {

    override suspend fun getWeatherForecastAndCurrent(
        latitude: String,
        longitude: String
    ): Resource<WeatherInfo> {
        val weatherInfo = WeatherInfo(
            latitude = 12.9737,
            longitude = 77.7007,
            currentUnit = CurrentUnitInfo(
                time = "iso8601",
                interval = "seconds",
                temperature = "°C",
                windspeed = "km/h"
            ),
            current = CurrentInfo(
                time = "2023-11-01T07:30",
                interval = 900,
                temperature = 7.8,
                windspeed = 8.1,
                weatherCode = 3
            ),
            hourlyUnit = HourlyUnitInfo(
                time = "iso8601",
                temperature = "°C",
                humidity = "%",
                windspeed = "km/h"
            ),
            hourly = HourlyInfo(
                time = fakeTimeList.map { it.toLocalDate() },
                temperature = fakeTemperatureList,
                humidity = fakeHumidityList,
                windspeed = fakeWindspeedList,
                weatherCodes = fakeWeatherCodeList
            )
        )

        return Resource.Success(data = weatherInfo)
    }

    override suspend fun getLocalityBasedOnCoordinates(
        latitude: String,
        longitude: String
    ): Resource<GeoCodingInfo> {
        return Resource.Success(data = fakeGeoCodingLocationBangalore.toGeoCodingInfo())
    }

    companion object {
        val fakeTimeList = listOf<String>(
            "2023-11-11T00:00",
            "2023-11-11T01:00",
            "2023-11-11T02:00",
            "2023-11-11T03:00",
            "2023-11-11T04:00",
            "2023-11-11T05:00",
            "2023-11-11T06:00",
            "2023-11-11T07:00",
            "2023-11-11T08:00",
            "2023-11-11T09:00",
            "2023-11-11T10:00",
            "2023-11-11T11:00",
            "2023-11-11T12:00",
            "2023-11-11T13:00",
            "2023-11-11T14:00",
            "2023-11-11T15:00",
            "2023-11-11T16:00",
            "2023-11-11T17:00",
            "2023-11-11T18:00",
            "2023-11-11T19:00",
            "2023-11-11T20:00",
            "2023-11-11T21:00",
            "2023-11-11T22:00",
            "2023-11-11T23:00",
            "2023-11-12T00:00",
            "2023-11-12T01:00",
            "2023-11-12T02:00",
            "2023-11-12T03:00",
            "2023-11-12T04:00",
            "2023-11-12T05:00",
            "2023-11-12T06:00",
            "2023-11-12T07:00",
            "2023-11-12T08:00",
            "2023-11-12T09:00",
            "2023-11-12T10:00",
            "2023-11-12T11:00",
            "2023-11-12T12:00",
            "2023-11-12T13:00",
            "2023-11-12T14:00",
            "2023-11-12T15:00",
            "2023-11-12T16:00",
            "2023-11-12T17:00",
            "2023-11-12T18:00",
            "2023-11-12T19:00",
            "2023-11-12T20:00",
            "2023-11-12T21:00",
            "2023-11-12T22:00",
            "2023-11-12T23:00",
            "2023-11-13T00:00",
            "2023-11-13T01:00",
            "2023-11-13T02:00",
            "2023-11-13T03:00",
            "2023-11-13T04:00",
            "2023-11-13T05:00",
            "2023-11-13T06:00",
            "2023-11-13T07:00",
            "2023-11-13T08:00",
            "2023-11-13T09:00",
            "2023-11-13T10:00",
            "2023-11-13T11:00",
            "2023-11-13T12:00",
            "2023-11-13T13:00",
            "2023-11-13T14:00",
            "2023-11-13T15:00",
            "2023-11-13T16:00",
            "2023-11-13T17:00",
            "2023-11-13T18:00",
            "2023-11-13T19:00",
            "2023-11-13T20:00",
            "2023-11-13T21:00",
            "2023-11-13T22:00",
            "2023-11-13T23:00",
            "2023-11-14T00:00",
            "2023-11-14T01:00",
            "2023-11-14T02:00",
            "2023-11-14T03:00",
            "2023-11-14T04:00",
            "2023-11-14T05:00",
            "2023-11-14T06:00",
            "2023-11-14T07:00",
            "2023-11-14T08:00",
            "2023-11-14T09:00",
            "2023-11-14T10:00",
            "2023-11-14T11:00",
            "2023-11-14T12:00",
            "2023-11-14T13:00",
            "2023-11-14T14:00",
            "2023-11-14T15:00",
            "2023-11-14T16:00",
            "2023-11-14T17:00",
            "2023-11-14T18:00",
            "2023-11-14T19:00",
            "2023-11-14T20:00",
            "2023-11-14T21:00",
            "2023-11-14T22:00",
            "2023-11-14T23:00",
            "2023-11-15T00:00",
            "2023-11-15T01:00",
            "2023-11-15T02:00",
            "2023-11-15T03:00",
            "2023-11-15T04:00",
            "2023-11-15T05:00",
            "2023-11-15T06:00",
            "2023-11-15T07:00",
            "2023-11-15T08:00",
            "2023-11-15T09:00",
            "2023-11-15T10:00",
            "2023-11-15T11:00",
            "2023-11-15T12:00",
            "2023-11-15T13:00",
            "2023-11-15T14:00",
            "2023-11-15T15:00",
            "2023-11-15T16:00",
            "2023-11-15T17:00",
            "2023-11-15T18:00",
            "2023-11-15T19:00",
            "2023-11-15T20:00",
            "2023-11-15T21:00",
            "2023-11-15T22:00",
            "2023-11-15T23:00",
            "2023-11-16T23:00",
            "2023-11-17T23:00",
            "2023-11-18T23:00",
            "2023-11-19T23:00",
        )
        val fakeTemperatureList = listOf<Double>(
            7.1,
            7.1,
            7.0,
            7.0,
            7.0,
            7.0,
            7.0,
            7.2,
            8.2,
            9.6,
            11.2,
            13.0,
            13.6,
            13.6,
            13.3,
            12.9,
            12.4,
            11.9,
            11.7,
            11.2,
            10.9,
            10.5,
            10.2,
            10.2,
            10.0,
            9.7,
            9.8,
            9.6,
            9.0,
            8.4,
            8.1,
            8.5,
            9.6,
            11.1,
            12.2,
            12.9,
            12.9,
            13.0,
            12.9,
            12.5,
            12.1,
            11.7,
            11.2,
            10.9,
            10.8,
            10.7,
            10.5,
            10.3,
            10.1,
            9.9,
            9.8,
            9.8,
            9.7,
            9.3,
            8.6,
            9.8,
            9.9,
            10.4,
            10.8,
            11.0,
            11.0,
            11.0,
            10.7,
            10.2,
            9.6,
            9.1,
            8.7,
            8.5,
            8.4,
            8.4,
            8.4,
            8.2,
            8.0,
            7.6,
            7.0,
            6.5,
            6.1,
            5.7,
            5.5,
            6.0,
            7.0,
            8.0,
            9.2,
            10.5,
            11.4,
            11.7,
            11.6,
            11.3,
            10.5,
            9.3,
            8.4,
            8.0,
            7.8,
            7.7,
            7.6,
            7.5,
            7.5,
            7.6,
            7.6,
            7.7,
            7.8,
            7.8,
            8.0,
            8.4,
            9.0,
            9.7,
            10.7,
            11.7,
            12.5,
            13.0,
            13.1,
            13.1,
            12.7,
            12.0,
            11.5,
            11.2,
            11.1,
            11.0,
            10.8,
            10.7,
            10.6,
            10.3,
            10.3,
            10.2,
            10.3,
            10.3,
            10.5,
            10.6,
            10.9,
            11.1,
            11.5,
            11.9,
            12.2,
            12.2,
            12.2,
            11.9,
            11.4,
            10.6,
            10.0,
            9.7,
            9.4,
            9.2,
            8.9,
            8.5,
            8.3,
            8.1,
            7.9,
            7.8,
            7.7,
            7.8,
            7.9,
            8.3,
            8.9,
            9.4,
            9.9,
            10.3,
            10.6,
            10.7,
            10.6,
            10.4,
            9.9,
            9.2,
            8.6,
            8.5,
            8.5,
            8.6,
            8.8,
            8.9,
            8.8,
            8.7,
            8.6,
            8.5,
        )
        val fakeHumidityList = listOf(
            70,
            70,
            71,
            72,
            74,
            75,
            79,
            81,
            84,
            85,
            84,
            77,
            74,
            75,
            79,
            83,
            86,
            89,
            89,
            91,
            90,
            90,
            89,
            86,
            85,
            86,
            83,
            84,
            88,
            90,
            90,
            88,
            84,
            77,
            71,
            69,
            68,
            69,
            70,
            74,
            75,
            79,
            84,
            88,
            91,
            92,
            93,
            95,
            96,
            97,
            97,
            96,
            92,
            90,
            84,
            88,
            83,
            76,
            70,
            68,
            66,
            66,
            68,
            69,
            73,
            76,
            78,
            78,
            79,
            79,
            80,
            80,
            80,
            80,
            81,
            82,
            82,
            82,
            82,
            79,
            74,
            69,
            65,
            61,
            58,
            57,
            57,
            58,
            62,
            68,
            72,
            74,
            74,
            75,
            76,
            77,
            78,
            78,
            77,
            77,
            78,
            79,
            80,
            79,
            77,
            75,
            73,
            70,
            68,
            67,
            66,
            66,
            68,
            72,
            75,
            77,
            79,
            81,
            82,
            83,
            83,
            83,
            83,
            83,
            83,
            82,
            81,
            78,
            74,
            71,
            68,
            65,
            63,
            62,
            61,
            62,
            65,
            70,
            74,
            76,
            76,
            77,
            78,
            80,
            81,
            83,
            84,
            85,
            85,
            84,
            83,
            81,
            78,
            75,
            73,
            71,
            69,
            66,
            64,
            64,
            69,
            76,
            82,
            84,
            85,
            85,
            85,
            84,
            83,
            82,
            81,
            80,
        )
        val fakeWindspeedList = listOf<Double>(
            8.3,
            5.8,
            3.6,
            2.3,
            1.1,
            3.6,
            7.4,
            7.7,
            8.4,
            8.0,
            11.6,
            11.7,
            13.4,
            10.9,
            11.2,
            9.7,
            8.8,
            8.9,
            9.2,
            9.3,
            8.9,
            9.5,
            10.5,
            10.3,
            9.1,
            8.6,
            10.1,
            8.7,
            8.5,
            8.7,
            10.0,
            12.0,
            13.6,
            15.1,
            13.9,
            17.4,
            16.1,
            15.3,
            16.6,
            15.3,
            15.0,
            13.0,
            11.3,
            9.7,
            11.4,
            8.6,
            7.9,
            7.0,
            4.3,
            4.8,
            5.8,
            8.0,
            9.7,
            9.9,
            11.2,
            8.8,
            9.1,
            11.0,
            10.7,
            10.9,
            10.4,
            11.5,
            11.1,
            9.2,
            5.3,
            5.0,
            6.2,
            7.0,
            6.7,
            8.4,
            8.7,
            9.4,
            10.3,
            10.2,
            10.1,
            10.1,
            11.3,
            11.5,
            11.7,
            12.8,
            14.0,
            14.7,
            15.0,
            15.3,
            15.2,
            14.8,
            14.8,
            15.0,
            15.0,
            15.2,
            14.8,
            14.3,
            13.8,
            13.3,
            13.9,
            15.1,
            15.5,
            14.6,
            13.2,
            12.4,
            12.3,
            12.3,
            12.6,
            13.0,
            13.3,
            13.7,
            14.2,
            14.4,
            14.7,
            14.4,
            13.8,
            13.5,
            13.3,
            13.5,
            13.7,
            13.7,
            13.3,
            13.1,
            13.1,
            13.7,
            14.0,
            13.8,
            13.8,
            14.0,
            14.8,
            15.5,
            16.3,
            17.1,
            18.1,
            19.0,
            19.8,
            20.0,
            20.0,
            18.5,
            16.6,
            15.0,
            14.6,
            14.3,
            14.3,
            14.3,
            14.3,
            14.3,
            13.8,
            13.3,
            12.8,
            12.5,
            12.5,
            12.6,
            12.8,
            13.2,
            13.8,
            15.2,
            17.1,
            18.5,
            18.7,
            17.9,
            17.2,
            16.3,
            14.8,
            13.9,
            13.6,
            13.5,
            13.2,
            13.2,
            13.0,
            13.0,
            13.4,
            13.9,
            13.8,
            13.7,
            13.6,
            13.5,
        )
        val fakeWeatherCodeList = listOf<Int>(
            2,
            3,
            61,
            61,
            80,
            3,
            2,
            3,
            3,
            61,
            61,
            61,
            80,
            80,
            3,
            80,
            3,
            3,
            3,
            61,
            61,
            61,
            80,
            3,
            61,
            61,
            61,
            3,
            3,
            2,
            2,
            2,
            2,
            3,
            3,
            3,
            3,
            3,
            3,
            2,
            2,
            1,
            1,
            1,
            0,
            0,
            0,
            2,
            1,
            2,
            3,
            2,
            1,
            1,
            2,
            1,
            1,
            2,
            2,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            2,
            2,
            2,
            2,
            2,
            2,
            3,
            3,
            80,
            3,
            61,
            2,
            2,
            3,
            3,
            2,
            2,
            2,
            3,
            3,
            3,
            3,
            3,
            3,
            61,
            61,
            61,
            61,
            61,
            61,
            3,
            3,
            3,
            2,
            2,
            2,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            61,
            61,
            61,
            80,
            80,
            80,
            61,
            61,
            61,
            3,
            3,
            3,
            2,
            2,
            2,
            2,
            2,
            2,
            3,
            3,
            3,
            3,
            3,
            3,
            2,
            2,
            2,
            2,
            2,
            2,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            3,
            2,
            2,
            3,
            3,
        )

        val fakeGeoCodingLocationPune = GoogleGeoCodingDTO(
            plusCode = null,
            results = listOf(
                AddressDTO(
                    formattedAddress = "Pimpri-Chinchwad, Maharashtra, India",
                    types = listOf(
                        "locality",
                        "political"
                    )
                ),
                AddressDTO(
                    formattedAddress = "Mulshi-Paud, Maharashtra, India",
                    types = listOf(
                        "administrative_area_level_4",
                        "political"
                    )
                ),
                AddressDTO(
                    formattedAddress = "Pune, Maharashtra, India",
                    types = listOf(
                        "administrative_area_level_3",
                        "political"
                    )
                ),
                AddressDTO(
                    formattedAddress = "Pune Division, Maharashtra, India",
                    types = listOf(
                        "administrative_area_level_2",
                        "political"
                    )
                ),
                AddressDTO(
                    formattedAddress = "Maharashtra, India",
                    types = listOf(
                        "administrative_area_level_1",
                        "political"
                    )
                ),
                AddressDTO(
                    formattedAddress = "India",
                    types = listOf(
                        "country",
                        "political"
                    )
                )
            ),
            status = "OK"
        )

        val fakeGeoCodingLocationBangalore = GoogleGeoCodingDTO(
            plusCode = null,
            results = listOf(
                AddressDTO(
                    formattedAddress = "Bengaluru, Karnataka, India",
                    types = listOf(
                        "locality",
                        "political"
                    )
                ),
                AddressDTO(
                    formattedAddress = "Bengaluru Urban, Karnataka, India",
                    types = listOf(
                        "administrative_area_level_3",
                        "political"
                    )
                ),
                AddressDTO(
                    formattedAddress = "Bangalore Division, Karnataka, India",
                    types = listOf(
                        "administrative_area_level_2",
                        "political"
                    )
                ),
                AddressDTO(
                    formattedAddress = "Karnataka, India",
                    types = listOf(
                        "administrative_area_level_1",
                        "political"
                    )
                ),
                AddressDTO(
                    formattedAddress = "India",
                    types = listOf(
                        "country",
                        "political"
                    )
                )
            ),
            status = "OK"
        )
    }
}