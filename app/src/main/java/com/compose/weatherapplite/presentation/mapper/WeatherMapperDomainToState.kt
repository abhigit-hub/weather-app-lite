package com.compose.weatherapplite.presentation.mapper

import com.compose.weatherapplite.domain.model.HourlyInfo
import com.compose.weatherapplite.domain.model.WeatherInfo
import com.compose.weatherapplite.presentation.model.CurrentWeatherState
import com.compose.weatherapplite.presentation.model.LocationState
import com.compose.weatherapplite.presentation.model.WeatherDetailsItemMetaState
import com.compose.weatherapplite.presentation.model.WeatherItemMetaState
import com.compose.weatherapplite.presentation.model.WeatherMenuSelectorType
import com.compose.weatherapplite.presentation.model.WeatherState
import com.compose.weatherapplite.presentation.model.WeatherType
import com.compose.weatherapplite.utils.WeatherAppConstants
import com.compose.weatherapplite.utils.WeatherAppConstants.TIME_12_HOUR_FORMAT
import com.compose.weatherapplite.utils.WeatherAppConstants.WEATHER_CODE_CLEAR_SKY_LIST
import com.compose.weatherapplite.utils.WeatherAppConstants.WEATHER_CODE_DRIZZLE_LIST
import com.compose.weatherapplite.utils.WeatherAppConstants.WEATHER_CODE_FOGGY_LIST
import com.compose.weatherapplite.utils.WeatherAppConstants.WEATHER_CODE_HEAVYRAIN_LIST
import com.compose.weatherapplite.utils.WeatherAppConstants.WEATHER_CODE_OVERCAST_LIST
import com.compose.weatherapplite.utils.WeatherAppConstants.WEATHER_CODE_RAIN_LIST
import com.compose.weatherapplite.utils.WeatherAppConstants.WEATHER_CODE_SNOWFALL_LIST
import com.compose.weatherapplite.utils.WeatherAppConstants.WEATHER_CODE_THUNDERSTORM_LIST
import com.compose.weatherapplite.utils.WeatherAppConstants.WEATHER_RAIN_LEVEL_HIGH
import com.compose.weatherapplite.utils.WeatherAppConstants.WEATHER_RAIN_LEVEL_LOW
import com.compose.weatherapplite.utils.WeatherAppConstants.WEATHER_RAIN_LEVEL_MODERATE
import com.compose.weatherapplite.utils.WeatherAppConstants.WEATHER_RAIN_LEVEL_NONE
import com.compose.weatherapplite.utils.WeatherAppConstants.WEATHER_RAIN_LEVEL_VERY_HIGH
import com.compose.weatherapplite.utils.WeatherAppConstants.WEATHER_RAIN_LEVEL_VERY_LOW
import com.compose.weatherapplite.utils.checkIfDateMatches
import com.compose.weatherapplite.utils.checkIfDateRangeMatches
import com.compose.weatherapplite.utils.convertToWeatherAppLiteDate
import java.time.LocalDate
import java.time.LocalDateTime

fun WeatherInfo.toWeatherState(): WeatherState {
    return WeatherState(
        locationState = this.toLocationState(),
        currentWeatherState = this.toCurrentWeatherState(),
        tomorrowWeatherItemListState = this.hourly.toWeatherItemListState(
            WeatherMenuSelectorType.WeatherMenuSelectorTypeTomorrow
        ),
        nextTenDaysWeatherItemListState = this.hourly.toWeatherItemListState(
            WeatherMenuSelectorType.WeatherMenuSelectorTypeNextTenDays
        ),
        nextTenDaysWeatherDetailsItemListState = this.hourly.toWeatherDetailsItemListState()
    )
}

fun WeatherInfo.toLocationState(): LocationState {
    return LocationState(
        latitude = latitude,
        longitude = longitude,
        cityName = "Berlin, Germany"
    )
}

fun WeatherInfo.toCurrentWeatherState(): CurrentWeatherState {
    return CurrentWeatherState(
        date = LocalDate.now().convertToWeatherAppLiteDate(),
        weatherType = current.weatherCode.toWeatherType(),
        temperature = "${current.temperature}${currentUnit.temperature}",
        wind = "${current.windspeed} ${currentUnit.windspeed}",
        humidity = "${hourly.humidity[0]}%",
        rain = "${current.weatherCode.toRainLevel()}%",
        todaysWeatherItemListState = hourly.toWeatherItemListState(
            WeatherMenuSelectorType.WeatherMenuSelectorTypeToday
        )
    )
}

fun HourlyInfo.toWeatherDetailsItemListState(): List<WeatherDetailsItemMetaState> {
    val weatherDetailsItemMetaStateList = mutableListOf<WeatherDetailsItemMetaState>()

    var lastKnownWeatherDetailsItemMetaState: WeatherDetailsItemMetaState? = null
    var lastKnownMinTemperature: Double = -1.0
    var lastKnownMaxTemperature: Double = -1.0

    time.forEachIndexed { index, localDateTime ->
        if (lastKnownWeatherDetailsItemMetaState == null) {
            lastKnownWeatherDetailsItemMetaState = WeatherDetailsItemMetaState(
                time = time[index].toLocalDate(),
                weatherCode = weatherCodes[index].toWeatherType(),
                minTemperature = "0",
                maxTemperature = "0"
            )
            return@forEachIndexed
        }

        if (time[index].toLocalDate().equals(lastKnownWeatherDetailsItemMetaState?.time)) {
            if (temperature[index] < lastKnownMinTemperature || lastKnownMinTemperature == -1.0) {
                lastKnownMinTemperature = temperature[index]
            }
            if (temperature[index] > lastKnownMaxTemperature || lastKnownMaxTemperature == -1.0) {
                lastKnownMaxTemperature = temperature[index]
            }
            if ((index % TIME_12_HOUR_FORMAT) == 0 && (index / TIME_12_HOUR_FORMAT) % 2 == 1) {
                lastKnownWeatherDetailsItemMetaState!!.weatherCode =
                    weatherCodes[index].toWeatherType()
            }

            if (index != time.size - 1) return@forEachIndexed
        }

        lastKnownWeatherDetailsItemMetaState!!.minTemperature = "$lastKnownMinTemperature°"
        lastKnownWeatherDetailsItemMetaState!!.maxTemperature = "$lastKnownMaxTemperature°"
        weatherDetailsItemMetaStateList.add(lastKnownWeatherDetailsItemMetaState!!)

        lastKnownWeatherDetailsItemMetaState = null
        lastKnownMinTemperature = -1.0
        lastKnownMaxTemperature = -1.0
    }

    return weatherDetailsItemMetaStateList
}

fun HourlyInfo.toWeatherItemListState(
    weatherMenuSelectorType: WeatherMenuSelectorType
): List<WeatherItemMetaState> {
    val weatherItemList = mutableListOf<WeatherItemMetaState>()

    time.forEachIndexed { index, dateToBeChecked ->
        if (checkDates(weatherMenuSelectorType, dateToBeChecked)) {
            weatherItemList.add(
                WeatherItemMetaState(
                    time = time[index],
                    temperature = temperature[index].toString(),
                    weatherCode = weatherCodes[index].toWeatherType()
                )
            )
        }
    }

    return weatherItemList
}

private fun checkDates(
    weatherMenuSelectorType: WeatherMenuSelectorType,
    dateToBeChecked: LocalDateTime
): Boolean {
    val filterDate: LocalDate = when (weatherMenuSelectorType) {
        WeatherMenuSelectorType.WeatherMenuSelectorTypeToday -> {
            LocalDate.now()
        }

        WeatherMenuSelectorType.WeatherMenuSelectorTypeTomorrow -> {
            LocalDate.now().plusDays(1)
        }

        WeatherMenuSelectorType.WeatherMenuSelectorTypeNextTenDays -> {
            LocalDate.now().plusDays(WeatherAppConstants.WEATHER_FORECAST_MAX)
        }
    }

    return when (weatherMenuSelectorType) {
        WeatherMenuSelectorType.WeatherMenuSelectorTypeToday,
        WeatherMenuSelectorType.WeatherMenuSelectorTypeTomorrow -> {
            dateToBeChecked.toLocalDate().checkIfDateMatches(
                filterDate = filterDate
            )
        }

        WeatherMenuSelectorType.WeatherMenuSelectorTypeNextTenDays -> {
            dateToBeChecked.toLocalDate().checkIfDateRangeMatches(
                filterDate1 = LocalDate.now(),
                filterDate2 = filterDate
            )
        }
    }
}

fun Int.toWeatherType(): WeatherType {
    return when (this) {
        in WEATHER_CODE_CLEAR_SKY_LIST -> WeatherType.ClearSky
        in WEATHER_CODE_OVERCAST_LIST -> WeatherType.Overcast
        in WEATHER_CODE_FOGGY_LIST -> WeatherType.Foggy
        in WEATHER_CODE_DRIZZLE_LIST -> WeatherType.Drizzle
        in WEATHER_CODE_RAIN_LIST -> WeatherType.Rain
        in WEATHER_CODE_HEAVYRAIN_LIST -> WeatherType.HeavyRain
        in WEATHER_CODE_SNOWFALL_LIST -> WeatherType.SnowFall
        in WEATHER_CODE_THUNDERSTORM_LIST -> WeatherType.Thunderstorm
        else -> WeatherType.ClearSky
    }
}

fun Int.toRainLevel(): Int {
    return when (this) {
        in WEATHER_CODE_CLEAR_SKY_LIST -> WEATHER_RAIN_LEVEL_NONE
        in WEATHER_CODE_OVERCAST_LIST -> WEATHER_RAIN_LEVEL_VERY_LOW
        in WEATHER_CODE_FOGGY_LIST -> WEATHER_RAIN_LEVEL_NONE
        in WEATHER_CODE_DRIZZLE_LIST -> WEATHER_RAIN_LEVEL_LOW
        in WEATHER_CODE_RAIN_LIST -> WEATHER_RAIN_LEVEL_MODERATE
        in WEATHER_CODE_HEAVYRAIN_LIST -> WEATHER_RAIN_LEVEL_VERY_HIGH
        in WEATHER_CODE_SNOWFALL_LIST -> WEATHER_RAIN_LEVEL_VERY_LOW
        in WEATHER_CODE_THUNDERSTORM_LIST -> WEATHER_RAIN_LEVEL_HIGH
        else -> WEATHER_RAIN_LEVEL_NONE
    }
}
