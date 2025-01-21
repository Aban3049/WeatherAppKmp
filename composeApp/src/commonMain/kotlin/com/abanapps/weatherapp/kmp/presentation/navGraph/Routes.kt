package com.abanapps.weatherapp.kmp.presentation.navGraph

import kotlinx.serialization.Serializable

sealed interface Routes {

    @Serializable
    data object SplashScreen:Routes

    @Serializable
    data object HomeScreen:Routes

}