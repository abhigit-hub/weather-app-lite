package com.compose.weatherapplite.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CurrentWeatherDTO(
    val latitude: Double,
    val longitude: Double,
    @SerializedName("generationtime_ms") val timeInMillis: String,
    val timezone: String,
    @SerializedName("timezone_abbreviation") val timezoneAbbreviation: String,
    val elevation: Int,
    @SerializedName("current_units") val currentUnit: CurrentUnit,
    val current: Current,
    @SerializedName("hourly_units") val hourlyUnit: HourlyUnit,
    val hourly: Hourly
)

data class CurrentUnit(
    val time: String,
    val interval: String,
    @SerializedName("temparature_2m") val temperature: String,
    @SerializedName("windspeed_10m") val windspeed: String,
)

data class HourlyUnit(
    val time: String,
    @SerializedName("temparature_2m") val temperature: String,
    @SerializedName("relativehumidity_2m") val humidity: String,
    @SerializedName("windspeed_10m") val windspeed: String,
)

data class Current(
    val time: String,
    val interval: Int,
    @SerializedName("temparature_2m") val temperature: Int,
    @SerializedName("windspeed_10m") val windspeed: Int,
)

data class Hourly(
    val time: List<String>,
    @SerializedName("temparature_2m") val temperature: List<Int>,
    @SerializedName("relativehumidity_2m") val humidity: List<Int>,
    @SerializedName("windspeed_10m") val windspeed: List<Int>,
)