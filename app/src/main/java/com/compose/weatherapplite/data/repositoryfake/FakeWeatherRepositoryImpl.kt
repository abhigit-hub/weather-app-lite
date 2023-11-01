package com.compose.weatherapplite.data.repositoryfake

import com.compose.weatherapplite.data.remote.WeatherApi
import com.compose.weatherapplite.domain.model.CurrentInfo
import com.compose.weatherapplite.domain.model.CurrentUnitInfo
import com.compose.weatherapplite.domain.model.HourlyInfo
import com.compose.weatherapplite.domain.model.HourlyUnitInfo
import com.compose.weatherapplite.domain.model.WeatherInfo
import com.compose.weatherapplite.domain.repository.WeatherRepository
import com.compose.weatherapplite.utils.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeWeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherForecastAndCurrent(
        latitude: String,
        longitude: String
    ): Resource<WeatherInfo> {
        val weatherInfo = WeatherInfo(
            latitude = 52.52,
            longitude = 13.41,
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
                windspeed = 8.1
            ),
            hourlyUnit = HourlyUnitInfo(
                time = "iso8601",
                temperature = "°C",
                humidity = "%",
                windspeed = "km/h"
            ),
            hourly = HourlyInfo(
                time = fakeTimeList,
                temperature = fakeTemperatureList,
                humidity = fakeHumidityList,
                windspeed = fakeWindspeedList
            )
        )

        return Resource.Success(data = weatherInfo)
    }

    companion object {
        val fakeTimeList = listOf<String>(
            "2023-11-01T00:00",
            "2023-11-01T01:00",
            "2023-11-01T02:00",
            "2023-11-01T03:00",
            "2023-11-01T04:00",
            "2023-11-01T05:00",
            "2023-11-01T06:00",
            "2023-11-01T07:00",
            "2023-11-01T08:00",
            "2023-11-01T09:00",
            "2023-11-01T10:00",
            "2023-11-01T11:00",
            "2023-11-01T12:00",
            "2023-11-01T13:00",
            "2023-11-01T14:00",
            "2023-11-01T15:00",
            "2023-11-01T16:00",
            "2023-11-01T17:00",
            "2023-11-01T18:00",
            "2023-11-01T19:00",
            "2023-11-01T20:00",
            "2023-11-01T21:00",
            "2023-11-01T22:00",
            "2023-11-01T23:00",
            "2023-11-02T00:00",
            "2023-11-02T01:00",
            "2023-11-02T02:00",
            "2023-11-02T03:00",
            "2023-11-02T04:00",
            "2023-11-02T05:00",
            "2023-11-02T06:00",
            "2023-11-02T07:00",
            "2023-11-02T08:00",
            "2023-11-02T09:00",
            "2023-11-02T10:00",
            "2023-11-02T11:00",
            "2023-11-02T12:00",
            "2023-11-02T13:00",
            "2023-11-02T14:00",
            "2023-11-02T15:00",
            "2023-11-02T16:00",
            "2023-11-02T17:00",
            "2023-11-02T18:00",
            "2023-11-02T19:00",
            "2023-11-02T20:00",
            "2023-11-02T21:00",
            "2023-11-02T22:00",
            "2023-11-02T23:00",
            "2023-11-03T00:00",
            "2023-11-03T01:00",
            "2023-11-03T02:00",
            "2023-11-03T03:00",
            "2023-11-03T04:00",
            "2023-11-03T05:00",
            "2023-11-03T06:00",
            "2023-11-03T07:00",
            "2023-11-03T08:00",
            "2023-11-03T09:00",
            "2023-11-03T10:00",
            "2023-11-03T11:00",
            "2023-11-03T12:00",
            "2023-11-03T13:00",
            "2023-11-03T14:00",
            "2023-11-03T15:00",
            "2023-11-03T16:00",
            "2023-11-03T17:00",
            "2023-11-03T18:00",
            "2023-11-03T19:00",
            "2023-11-03T20:00",
            "2023-11-03T21:00",
            "2023-11-03T22:00",
            "2023-11-03T23:00",
            "2023-11-04T00:00",
            "2023-11-04T01:00",
            "2023-11-04T02:00",
            "2023-11-04T03:00",
            "2023-11-04T04:00",
            "2023-11-04T05:00",
            "2023-11-04T06:00",
            "2023-11-04T07:00",
            "2023-11-04T08:00",
            "2023-11-04T09:00",
            "2023-11-04T10:00",
            "2023-11-04T11:00",
            "2023-11-04T12:00",
            "2023-11-04T13:00",
            "2023-11-04T14:00",
            "2023-11-04T15:00",
            "2023-11-04T16:00",
            "2023-11-04T17:00",
            "2023-11-04T18:00",
            "2023-11-04T19:00",
            "2023-11-04T20:00",
            "2023-11-04T21:00",
            "2023-11-04T22:00",
            "2023-11-04T23:00",
            "2023-11-05T00:00",
            "2023-11-05T01:00",
            "2023-11-05T02:00",
            "2023-11-05T03:00",
            "2023-11-05T04:00",
            "2023-11-05T05:00",
            "2023-11-05T06:00",
            "2023-11-05T07:00",
            "2023-11-05T08:00",
            "2023-11-05T09:00",
            "2023-11-05T10:00",
            "2023-11-05T11:00",
            "2023-11-05T12:00",
            "2023-11-05T13:00",
            "2023-11-05T14:00",
            "2023-11-05T15:00",
            "2023-11-05T16:00",
            "2023-11-05T17:00",
            "2023-11-05T18:00",
            "2023-11-05T19:00",
            "2023-11-05T20:00",
            "2023-11-05T21:00",
            "2023-11-05T22:00",
            "2023-11-05T23:00",
            "2023-11-06T00:00",
            "2023-11-06T01:00",
            "2023-11-06T02:00",
            "2023-11-06T03:00",
            "2023-11-06T04:00",
            "2023-11-06T05:00",
            "2023-11-06T06:00",
            "2023-11-06T07:00",
            "2023-11-06T08:00",
            "2023-11-06T09:00",
            "2023-11-06T10:00",
            "2023-11-06T11:00",
            "2023-11-06T12:00",
            "2023-11-06T13:00",
            "2023-11-06T14:00",
            "2023-11-06T15:00",
            "2023-11-06T16:00",
            "2023-11-06T17:00",
            "2023-11-06T18:00",
            "2023-11-06T19:00",
            "2023-11-06T20:00",
            "2023-11-06T21:00",
            "2023-11-06T22:00",
            "2023-11-06T23:00",
            "2023-11-07T00:00",
            "2023-11-07T01:00",
            "2023-11-07T02:00",
            "2023-11-07T03:00",
            "2023-11-07T04:00",
            "2023-11-07T05:00",
            "2023-11-07T06:00",
            "2023-11-07T07:00",
            "2023-11-07T08:00",
            "2023-11-07T09:00",
            "2023-11-07T10:00",
            "2023-11-07T11:00",
            "2023-11-07T12:00",
            "2023-11-07T13:00",
            "2023-11-07T14:00",
            "2023-11-07T15:00",
            "2023-11-07T16:00",
            "2023-11-07T17:00",
            "2023-11-07T18:00",
            "2023-11-07T19:00",
            "2023-11-07T20:00",
            "2023-11-07T21:00",
            "2023-11-07T22:00",
            "2023-11-07T23:00"
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
            8.9
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
            84
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
            13.9
        )
    }
}