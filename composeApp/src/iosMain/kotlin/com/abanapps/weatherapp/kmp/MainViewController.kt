package com.abanapps.weatherapp.kmp

import androidx.compose.ui.window.ComposeUIViewController
import com.abanapps.weatherapp.kmp.presentation.App
import com.abanapps.weatherapp.kmp.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = {
    initKoin()
}) { App() }