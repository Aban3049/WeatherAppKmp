package com.abanapps.weatherapp.kmp.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.abanapps.colors.backgroundGradientOne
import com.abanapps.colors.backgroundGradientTwo
import com.abanapps.weatherapp.kmp.presentation.states.States
import com.abanapps.weatherapp.kmp.presentation.utils.Utils
import com.abanapps.weatherapp.kmp.presentation.utils.customFont
import com.abanapps.weatherapp.kmp.presentation.viewModel.MainViewModel
import dev.jordond.compass.geolocation.Geolocator
import dev.jordond.compass.geolocation.GeolocatorResult
import dev.jordond.compass.geolocation.mobile
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import weatherappkmp.composeapp.generated.resources.Res
import weatherappkmp.composeapp.generated.resources.ic_humidity
import weatherappkmp.composeapp.generated.resources.ic_wind
import weatherappkmp.composeapp.generated.resources.logo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController,viewModel: MainViewModel = koinViewModel()) {

    val state = viewModel.state.collectAsStateWithLifecycle()

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

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            "Rawalpindi",
                            fontFamily = customFont(),
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 21.sp
                        )
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = "ic_down",
                            tint = Color.White
                        )
                    }

                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Outlined.LocationOn,
                            contentDescription = "ic_location",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "ic_notification",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
                windowInsets = WindowInsets(0.dp)
            )

        },
        modifier = Modifier.background(
            brush = Brush.linearGradient(
                colors = listOf(
                    backgroundGradientTwo,
                    backgroundGradientOne,
                )
            )
        ),
        containerColor = Color.Transparent,
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 14.dp, vertical = 20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {


            Spacer(modifier = Modifier.weight(.5f))
            Image(
                painter = painterResource(Res.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(180.dp)
            )

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

                when (state.value) {



                    States.IsLoading -> {
                        Box(modifier = Modifier.fillMaxSize().padding(innerPadding), contentAlignment = Alignment.Center) {
                            CircularProgressIndicator()
                        }
                    }

                    is States.OnError -> {

                        val errorMessage = (state.value as States.OnError).errorMessage

                        Box(modifier = Modifier.fillMaxSize().padding(innerPadding), contentAlignment = Alignment.Center) {
                            Text(errorMessage, color = Color.Red)
                        }
                    }

                    is States.OnSuccess -> {
                        val weatherResponse = (state.value as States.OnSuccess).weatherResponse


                        ElevatedCard(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF7FC3F3)),
                            shape = RoundedCornerShape(8.dp)
                        ) {

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(14.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(12.dp)
                            ) {

                                Text(
                                    "${weatherResponse.dt?.toLong()
                                        ?.let { Utils.convertLongToDateString(it) }}",
                                    color = Color.White,
                                    fontFamily = customFont(),
                                    fontSize = 20.sp
                                )

                                Box(modifier = Modifier) {

                                    Text(
                                        "${weatherResponse.main?.temp} ",
                                        fontSize = 26.sp,
                                        color = Color.White,
                                        fontFamily = customFont()
                                    )
                                    Text(
                                        "°",
                                        modifier = Modifier.align(Alignment.TopEnd),
                                        fontFamily = customFont(),
                                        fontSize = 18.sp,
                                        color = Color.White
                                    )

                                }

                                Text(
                                    "Cloudy",
                                    color = Color.White,
                                    fontFamily = customFont(),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )


                                Row(
                                    modifier = Modifier
                                        .align(Alignment.CenterHorizontally)
                                        .fillMaxWidth()
                                        .height(IntrinsicSize.Min),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {

                                    Image(
                                        painter = painterResource(Res.drawable.ic_wind),
                                        contentDescription = "ic_wind",
                                        modifier = Modifier.size(28.dp)
                                    )

                                    Spacer(modifier = Modifier.size(8.dp))

                                    Text(
                                        "Wind",
                                        fontFamily = customFont(),
                                        color = Color.White,
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )

                                    Spacer(modifier = Modifier.size(14.dp))

                                    Spacer(
                                        modifier = Modifier
                                            .width(2.dp)
                                            .padding(vertical = 7.dp)
                                            .background(Color.White)
                                            .fillMaxHeight()

                                    )

                                    Spacer(modifier = Modifier.size(14.dp))

                                    Text(
                                        "${weatherResponse.wind} km/h",
                                        fontWeight = FontWeight.SemiBold,
                                        fontFamily = customFont(),
                                        color = Color.White,
                                        fontSize = 17.sp
                                    )

                                }

                                Row(
                                    modifier = Modifier
                                        .align(Alignment.CenterHorizontally)
                                        .fillMaxWidth()
                                        .height(IntrinsicSize.Min),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {

                                    Image(
                                        painter = painterResource(Res.drawable.ic_humidity),
                                        contentDescription = "ic_wind",
                                        modifier = Modifier.size(28.dp)
                                    )

                                    Spacer(modifier = Modifier.size(8.dp))

                                    Text(
                                        "Hum",
                                        fontFamily = customFont(),
                                        color = Color.White,
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )

                                    Spacer(modifier = Modifier.size(14.dp))

                                    Spacer(
                                        modifier = Modifier
                                            .width(2.dp)
                                            .padding(vertical = 7.dp)
                                            .background(Color.White)
                                            .fillMaxHeight()

                                    )

                                    Spacer(modifier = Modifier.size(14.dp))

                                    Text(
                                        "${weatherResponse.main?.humidity} %",
                                        fontWeight = FontWeight.SemiBold,
                                        fontFamily = customFont(),
                                        color = Color.White,
                                        fontSize = 17.sp
                                    )

                                }


                            }


                        }

//                        Column(
//                            modifier = Modifier.fillMaxSize().padding(innerPadding),
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            verticalArrangement = Arrangement.Center
//                        ) {
//
//                            Text(("City: " + weatherResponse.name) ?: "")
//                            Text("Temperature: " + weatherResponse.main?.temp)
//                            Text("Max Temperature: " + weatherResponse.main?.tempMax)
//                            Text("Min Temperature:" + weatherResponse.main?.tempMin)
//
//
//                        }

                    }
                }



            }

            Spacer(modifier = Modifier.weight(1f))

        }



    }


}