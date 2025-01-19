package com.abanapps.weatherapp.kmp.presentation.states

import com.abanapps.weatherapp.kmp.data.models.WeatherResponse

sealed class States {
    data object isLoading : States()
    data class onSuccess(val weatherResponse: WeatherResponse) : States()
    data class onError(val errorMessage: String) : States()
}