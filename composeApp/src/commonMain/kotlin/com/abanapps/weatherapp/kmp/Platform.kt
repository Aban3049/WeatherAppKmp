package com.abanapps.weatherapp.kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform