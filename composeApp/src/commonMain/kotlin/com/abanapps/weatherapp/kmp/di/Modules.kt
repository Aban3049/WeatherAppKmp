package com.abanapps.weatherapp.kmp.di

import com.abanapps.weatherapp.kmp.data.network.Client.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import com.abanapps.weatherapp.kmp.presentation.viewModel.MainViewModel
import org.koin.core.module.dsl.singleOf
import com.abanapps.weatherapp.kmp.domain.Repo
import com.abanapps.weatherapp.kmp.data.repoImpl.RepoImpl
import org.koin.dsl.bind


expect val platformModule: Module

val sharedModule = module {


    single {
        HttpClientFactory.createHttpClient(get())
    }

    singleOf(::RepoImpl).bind<Repo>()

    viewModelOf(::MainViewModel)

}

