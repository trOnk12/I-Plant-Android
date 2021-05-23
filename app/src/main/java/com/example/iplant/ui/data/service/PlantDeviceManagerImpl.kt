package com.example.iplant.ui.data.service

import com.example.iplant.ui.data.ble.PlantDeviceBleManager
import com.example.iplant.ui.domain.service.PlantDeviceManager
import com.example.iplant.ui.feature.nearbydevice.model.PlantDevice
import javax.inject.Inject

class PlantDeviceManagerImpl @Inject constructor(
    private val plantDeviceBleManager: PlantDeviceBleManager
) : PlantDeviceManager {

    override suspend fun connect(plantDevice: PlantDevice) {
        plantDeviceBleManager.connect()
    }

}