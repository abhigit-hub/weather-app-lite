package com.compose.weatherapplite.data.mapper

import com.compose.weatherapplite.data.remote.GeoCodingApi
import com.compose.weatherapplite.data.remote.dto.GoogleGeoCodingDTO
import com.compose.weatherapplite.domain.model.GeoCodingInfo

fun GoogleGeoCodingDTO.toGeoCodingInfo(): GeoCodingInfo {
    val cityName = this.results.filter {
        it.types.contains(GeoCodingApi.ADDITIONAL_QUERY_PARAMS_FOR_RESULT_TYPE)
    }.let {
        if (it.isNotEmpty()) {
            it[0].formattedAddress
        } else {
            "Unknown Locality"
        }
    }

    return GeoCodingInfo(
        cityName = cityName
    )
}
