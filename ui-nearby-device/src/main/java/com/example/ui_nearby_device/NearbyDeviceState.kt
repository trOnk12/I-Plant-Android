package com.example.ui_nearby_device

import com.example.ui_nearby_device.model.UIPlantDevice

data class NearbyDeviceState(
    val devices: List<UIPlantDevice> = emptyList(),
    val isEmpty: Boolean = true
)