package com.example.iplant.ui.feature.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.iplant.ui.feature.devicedetail.DeviceDetailScreen
import com.example.iplant.ui.feature.nearbydevice.NearByDeviceScreen
import com.example.iplant.ui.feature.nearbydevice.model.PlantDevice
import java.lang.IllegalStateException

@Composable
fun IPlant() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "nearbyDevice") {
        composable("nearbyDevice") { NearByDeviceScreen(navController) }
        composable(
            "deviceDetails",
        ) {
            DeviceDetailScreen(
                navController.previousBackStackEntry
                    ?.arguments?.getSerializable("nearbyDevice") as? PlantDevice
                    ?: throw IllegalStateException()
            )
        }
    }

}


