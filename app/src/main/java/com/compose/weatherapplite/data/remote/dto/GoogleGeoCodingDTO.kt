package com.compose.weatherapplite.data.remote.dto

import com.google.gson.annotations.SerializedName

data class GoogleGeoCodingDTO(
    @SerializedName("plus_code") val plusCode: PlusCodeDTO?,
    val results: List<AddressDTO>,
    val status: String
)

data class PlusCodeDTO(
    @SerializedName("compound_code") val compoundCode: String,
    @SerializedName("global_code") val globalCode: String
)

data class AddressDTO(
    @SerializedName("formatted_address") val formattedAddress: String,
    val types: List<String>
)