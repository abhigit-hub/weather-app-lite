package com.compose.weatherapplite.presentation.mapper

import com.compose.weatherapplite.domain.model.GeoCodingInfo
import com.compose.weatherapplite.presentation.model.GeoCodingState

fun GeoCodingInfo.toGeoCodingState(): GeoCodingState {
    return GeoCodingState(
        cityName = cityName
    )
}