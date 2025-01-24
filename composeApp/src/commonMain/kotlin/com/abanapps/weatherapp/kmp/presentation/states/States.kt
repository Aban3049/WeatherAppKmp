package com.abanapps.weatherapp.kmp.presentation.states

import com.abanapps.weatherapp.kmp.data.models.WeatherResponse

sealed class States {
    data object IsLoading : States()
    data class OnSuccess(val weatherResponse: WeatherResponse) : States()
    data class OnError(val errorMessage: String) : States()
}