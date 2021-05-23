package com.example.iplant.ui.domain.service

import com.example.iplant.ui.feature.nearbydevice.model.PlantDevice

interface PlantDeviceManager {
    suspend fun connect(plantDevice: PlantDevice)
}