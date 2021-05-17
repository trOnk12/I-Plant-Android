package com.example.iplant.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.iplant.ui.feature.nearbydevice.NearByDeviceScreen

@Composable
fun IPlantApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "nearbyDevice") {
        composable("nearbyDevice") { NearByDeviceScreen() }
    }
}


