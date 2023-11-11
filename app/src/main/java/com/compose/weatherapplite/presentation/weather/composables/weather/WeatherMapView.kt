package com.compose.weatherapplite.presentation.weather.composables.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.presentation.model.LocationState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun WeatherMapView(locationState: LocationState) {
    if (locationState.latitude != 0.0 && locationState.longitude != 0.0) {

        val latLng = LatLng(locationState.latitude, locationState.longitude)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(latLng, 15f)
        }

        Box(modifier = Modifier.fillMaxHeight()) {
            GoogleMap(
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .clip(RoundedCornerShape(30.dp)),
                cameraPositionState = cameraPositionState,
            ) {
                Marker(
                    state = MarkerState(position = LatLng(locationState.latitude, locationState.longitude)),
                    title = locationState.cityShortenedName,
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 20.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(MaterialTheme.colorScheme.surfaceTint)
            )
        }
    }
}