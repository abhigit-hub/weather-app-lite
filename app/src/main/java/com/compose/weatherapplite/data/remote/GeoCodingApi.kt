package com.compose.weatherapplite.data.remote

import com.compose.weatherapplite.data.remote.dto.GoogleGeoCodingDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoCodingApi {
    companion object {
        const val GMAP_API_KEY = "YOUR_API_KEY_HERE"
        const val BASE_URL_GMAPS = "https://maps.googleapis.com/maps/api/geocode/"

        const val ADDITIONAL_QUERY_PARAMS_FOR_RESULT_TYPE = "locality"
    }

    @GET("json")
    suspend fun getLocalityFromCoordinatesUsingGeoCodingApi(
        @Query("result_type") resultType: String = ADDITIONAL_QUERY_PARAMS_FOR_RESULT_TYPE,
        @Query("key") apiKey: String = GMAP_API_KEY,
        @Query("address") latLng: String
    ): GoogleGeoCodingDTO
}
