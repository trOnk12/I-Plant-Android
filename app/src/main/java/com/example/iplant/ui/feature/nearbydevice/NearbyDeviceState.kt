package com.example.iplant.ui.feature.nearbydevice

import com.example.iplant.ui.feature.nearbydevice.model.PlantDevice

data class NearbyDeviceState(
    val devices: List<PlantDevice> = emptyList(),
    val isEmpty: Boolean = true
)