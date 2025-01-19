package com.abanapps.weatherapp.kmp.di

import com.abanapps.weatherapp.kmp.data.network.Client.HttpClientFactory
import org.koin.core.module.Module
import org.koin.dsl.module


expect val platformModule: Module

val sharedModule = module {

    single {
        HttpClientFactory.createHttpClient(get())
    }
}

