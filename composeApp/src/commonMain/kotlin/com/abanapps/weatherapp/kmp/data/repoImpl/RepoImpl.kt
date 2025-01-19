package com.abanapps.weatherapp.kmp.data.repoImpl

import com.abanapps.weatherapp.kmp.data.constant.API_KEY
import com.abanapps.weatherapp.kmp.data.models.WeatherResponse
import com.abanapps.weatherapp.kmp.data.network.safeCall.safeCall
import com.abanapps.weatherapp.kmp.data.network.safeCallUtils.DataError
import com.abanapps.weatherapp.kmp.data.network.safeCallUtils.Result
import com.abanapps.weatherapp.kmp.domain.Repo
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RepoImpl(
    private val httpClient: HttpClient
) : Repo {

    override suspend fun getWeather(
        lat: Double?,
        log: Double?
    ): Result<WeatherResponse, DataError> {

        return safeCall {
            httpClient.get("https://api.openweathermap.org/data/2.5/weather?/l≈at=$lat&lon=$log&appid=$API_KEY&units=metric")
        }

    }


}