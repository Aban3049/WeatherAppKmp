package com.abanapps.weatherapp.kmp.domain

import com.abanapps.weatherapp.kmp.data.models.WeatherResponse
import com.abanapps.weatherapp.kmp.data.network.safeCallUtils.DataError
import com.abanapps.weatherapp.kmp.data.network.safeCallUtils.Result

interface Repo {

    suspend fun getWeather(lat:Double?,log:Double?):Result<WeatherResponse,DataError>

}