@file:Suppress("FunctionNaming")

package com.compose.weatherapplite.presentation.weather.composables.weather

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.compose.weatherapplite.presentation.model.LocationState
import com.compose.weatherapplite.utils.WeatherAppConstants
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

private const val DIMENS_CAMERA_ZOOM_FACTOR = 15f

@Composable
fun WeatherMapView(
    locationState: LocationState,
    isDarkThemeEnabledState: Boolean
) {
    if (locationState.latitude != 0.0 && locationState.longitude != 0.0) {
        val latLng = LatLng(locationState.latitude, locationState.longitude)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(latLng, DIMENS_CAMERA_ZOOM_FACTOR)
        }
        val mapProperties = MapProperties(
            mapStyleOptions = MapStyleOptions(
                if (isDarkThemeEnabledState) {
                    WeatherAppConstants.MAP_STYLE_DARK
                } else {
                    WeatherAppConstants.MAP_STYLE_LIGHT
                }
            )
        )

        GoogleMap(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .clip(RoundedCornerShape(30.dp)),
            cameraPositionState = cameraPositionState,
            properties = mapProperties
        ) {
            Marker(
                state = MarkerState(
                    position = LatLng(locationState.latitude, locationState.longitude)
                ),
                title = locationState.cityShortenedName
            )
        }
    }
}
