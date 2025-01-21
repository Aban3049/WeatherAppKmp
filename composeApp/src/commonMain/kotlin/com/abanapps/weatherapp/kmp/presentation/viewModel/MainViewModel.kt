package com.abanapps.weatherapp.kmp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abanapps.weatherapp.kmp.data.network.safeCallUtils.onError
import com.abanapps.weatherapp.kmp.data.network.safeCallUtils.onSuccess
import com.abanapps.weatherapp.kmp.domain.Repo
import com.abanapps.weatherapp.kmp.presentation.states.States
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repo: Repo,
) : ViewModel()
{

    private val _state = MutableStateFlow<States>(States.isLoading)
    val state = _state.asStateFlow()

    fun getWeather(lat: Double, log: Double) {


        _state.value = States.isLoading

        viewModelScope.launch {

            repo.getWeather(lat = lat, log = log).onSuccess {
                _state.value = States.onSuccess(weatherResponse = it)
            }.onError {
                _state.value = States.onError(it.toString())
            }

        }

    }

}