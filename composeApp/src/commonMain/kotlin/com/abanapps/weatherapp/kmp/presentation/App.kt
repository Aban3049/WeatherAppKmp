package com.abanapps.weatherapp.kmp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abanapps.weatherapp.kmp.presentation.states.States
import com.abanapps.weatherapp.kmp.presentation.viewModel.MainViewModel
import dev.jordond.compass.geolocation.Geolocator
import dev.jordond.compass.geolocation.GeolocatorResult
import dev.jordond.compass.geolocation.mobile
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App(viewModel: MainViewModel = koinViewModel()) {

    val state = viewModel.state.collectAsStateWithLifecycle()

    MaterialTheme {

        val geoLocator = remember {
            Geolocator.mobile()
        }

        LaunchedEffect(Unit) {

            when (val result = geoLocator.current()) {

                is GeolocatorResult.Success -> {
                    println("LOCATION: ${result.data.coordinates}")
                    viewModel.getWeather(
                        lat = result.data.coordinates.latitude,
                        log = result.data.coordinates.longitude
                    )

                }


                is GeolocatorResult.Error -> when (result) {

                    is GeolocatorResult.NotSupported -> println("LOCATION ERROR ${result.message}")
                    is GeolocatorResult.NotFound -> println("LOCATION ERROR ${result.message}")
                    is GeolocatorResult.GeolocationFailed -> println("LOCATION ERROR ${result.message}")
                    is GeolocatorResult.PermissionError -> println("LOCATION ERROR ${result.message}")
                    else -> println("")


                }


            }

        }

        when (state.value) {
            States.isLoading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is States.onError -> {

                val errorMessage = (state.value as States.onError).errorMessage

                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(errorMessage, color = Color.Red)
                }
            }

            is States.onSuccess -> {
                val weatherResponse = (state.value as States.onSuccess).weatherResponse

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(("City: " + weatherResponse.name) ?: "")
                    Text("Temperature: " + weatherResponse.main?.temp)
                    Text("Max Temperature: " + weatherResponse.main?.tempMax)
                    Text("Min Temperature:" + weatherResponse.main?.tempMin)


                }

            }
        }

    }
}