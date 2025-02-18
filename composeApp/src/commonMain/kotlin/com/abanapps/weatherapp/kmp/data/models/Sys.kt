package com.abanapps.weatherapp.kmp.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sys(
    @SerialName("country")
    val country: String?,
    @SerialName("sunrise")
    val sunrise: Int?,
    @SerialName("sunset")
    val sunset: Int?
)