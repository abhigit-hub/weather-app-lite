package com.compose.weatherapplite.manager

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.util.Log
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherLocationManager @Inject constructor(
    private val context: Context
) {

    companion object {
        private val TAG = WeatherLocationManager::class.java.simpleName
    }

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    init {
        setupForLocationUpdates()
    }

    private fun setupForLocationUpdates() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
    }

    @SuppressLint("MissingPermission")
    fun registerForLocationUpdates(onLocationUpdated: (Location) -> Unit) {
        if (::fusedLocationProviderClient.isInitialized) {
            fusedLocationProviderClient.lastLocation.addOnSuccessListener {
                it?.let {
                    Log.d(
                        TAG,
                        "Location update received ==> (latitude = ${it.latitude}, " +
                            "longitude = ${it.longitude})"
                    )
                    onLocationUpdated(it)
                }
            }
        }
    }
}
