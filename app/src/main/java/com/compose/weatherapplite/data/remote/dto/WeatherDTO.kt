package com.compose.weatherapplite.data.remote.dto

import com.google.gson.annotations.SerializedName

data class WeatherDTO(
    val latitude: Double,
    val longitude: Double,
    @SerializedName("generationtime_ms") val timeInMillis: String,
    val timezone: String,
    @SerializedName("timezone_abbreviation") val timezoneAbbreviation: String,
    val elevation: Int,
    @SerializedName("current_units") val currentUnitDTO: CurrentUnitDTO,
    @SerializedName("current") val currentDTO: CurrentDTO,
    @SerializedName("hourly_units") val hourlyUnitDTO: HourlyUnitDTO,
    @SerializedName("hourly") val hourlyDTO: HourlyDTO
)

data class CurrentUnitDTO(
    val time: String,
    val interval: String,
    @SerializedName("temperature_2m") val temperature: String,
    @SerializedName("windspeed_10m") val windspeed: String,
)

data class HourlyUnitDTO(
    val time: String,
    @SerializedName("temperature_2m") val temperature: String,
    @SerializedName("relativehumidity_2m") val humidity: String,
    @SerializedName("windspeed_10m") val windspeed: String,
)

data class CurrentDTO(
    val time: String,
    val interval: Int,
    @SerializedName("temperature_2m") val temperature: Double,
    @SerializedName("windspeed_10m") val windspeed: Double,
    val weathercode: Int
)

data class HourlyDTO(
    val time: List<String>,
    @SerializedName("temperature_2m") val temperature: List<Double>,
    @SerializedName("relativehumidity_2m") val humidity: List<Int>,
    @SerializedName("windspeed_10m") val windspeed: List<Double>,
    @SerializedName("weathercode") val weathercodes: List<Int>
)