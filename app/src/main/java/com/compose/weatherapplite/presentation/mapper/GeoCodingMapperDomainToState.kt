package com.compose.weatherapplite.presentation.mapper

import com.compose.weatherapplite.domain.model.GeoCodingInfo
import com.compose.weatherapplite.presentation.model.GeoCodingState
import com.compose.weatherapplite.utils.toShortenedCityName

fun GeoCodingInfo.toGeoCodingState(): GeoCodingState {
    return GeoCodingState(
        cityName = cityName,
        cityShortenedName = cityName.toShortenedCityName()
    )
}