package com.compose.weatherapplite.utils

import com.compose.weatherapplite.R
import com.compose.weatherapplite.presentation.model.WeatherType

fun WeatherType.toDrawable(): Int {
    return when (this) {
        is WeatherType.ClearSky -> R.drawable.vd_clear_sky
        is WeatherType.Overcast -> R.drawable.vd_overcast
        is WeatherType.Foggy -> R.drawable.vd_foggy
        is WeatherType.Drizzle -> R.drawable.vd_drizzle
        is WeatherType.Rain -> R.drawable.vd_rain
        is WeatherType.HeavyRain -> R.drawable.vd_heavy_rain
        is WeatherType.SnowFall -> R.drawable.vd_snowfall
        is WeatherType.Thunderstorm -> R.drawable.vd_thunderstorm
        else -> R.drawable.vd_clear_sky
    }
}

fun WeatherType.toAnimatedVectorDrawable(): Int {
    return when (this) {
        is WeatherType.ClearSky -> R.drawable.avd_clear_sky
        is WeatherType.Overcast -> R.drawable.avd_overcast
        is WeatherType.Foggy -> R.drawable.avd_foggy
        is WeatherType.Drizzle -> R.drawable.avd_drizzle
        is WeatherType.Rain -> R.drawable.avd_rain
        is WeatherType.HeavyRain -> R.drawable.avd_heavy_rain
        is WeatherType.SnowFall -> R.drawable.avd_snowfall
        is WeatherType.Thunderstorm -> R.drawable.avd_thunderstorm
        else -> R.drawable.avd_clear_sky
    }
}
