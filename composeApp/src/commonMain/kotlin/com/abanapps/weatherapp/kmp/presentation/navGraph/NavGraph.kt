package com.abanapps.weatherapp.kmp.presentation.navGraph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abanapps.weatherapp.kmp.presentation.screens.home.HomeScreen
import com.abanapps.weatherapp.kmp.presentation.screens.splash.SplashScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.SplashScreen){
        composable<Routes.SplashScreen> {
            SplashScreen(navController )
        }
        composable<Routes.HomeScreen> {
            HomeScreen(navController)
        }
    }

}