package com.compose.weatherapplite.di

import android.content.Context
import com.compose.weatherapplite.data.remote.GeoCodingApi
import com.compose.weatherapplite.data.remote.WeatherApi
import com.compose.weatherapplite.manager.WeatherLocationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
            .build()
    }

    @Provides
    @Singleton
    fun providesWeatherApi(okHttpClient: OkHttpClient): WeatherApi {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(WeatherApi.BASE_URL_WEATHER)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun providesGeoCodingApi(okHttpClient: OkHttpClient): GeoCodingApi {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(GeoCodingApi.BASE_URL_GMAPS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GeoCodingApi::class.java)
    }

    @Provides
    @Singleton
    fun providesWeatherLocationManager(
        @ApplicationContext appContext: Context
    ): WeatherLocationManager {
        return WeatherLocationManager(appContext)
    }
}
