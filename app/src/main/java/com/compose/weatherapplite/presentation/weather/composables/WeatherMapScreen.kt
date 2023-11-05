package com.compose.weatherapplite.presentation.weather.composables

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.presentation.weather.WeatherTempState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun WeatherMapScreen(weatherTempState: WeatherTempState) {
    val latLng = LatLng(weatherTempState.latitude.toDouble(), weatherTempState.longitude.toDouble())
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(latLng, 15f)
    }

    GoogleMap(
        modifier = Modifier
            .fillMaxHeight()
            .padding(bottom = 20.dp)
            .clip(RoundedCornerShape(30.dp)),
        cameraPositionState = cameraPositionState,
    ) {

    }
}