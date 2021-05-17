package com.example.iplant.ui.feature.nearbydevice

import com.example.iplant.ui.feature.nearbydevice.model.UIPlantDevice

data class NearbyDeviceState(
    val devices: List<UIPlantDevice> = emptyList(),
    val isEmpty: Boolean = true
)