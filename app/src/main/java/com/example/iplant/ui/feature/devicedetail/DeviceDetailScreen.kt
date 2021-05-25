package com.example.iplant.ui.feature.devicedetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import com.example.iplant.ui.feature.nearbydevice.model.PlantDevice

@Composable
fun DeviceDetailScreen(
    nearbyDevice: PlantDevice,
    deviceDetailViewModel: DeviceDetailViewModel = hiltNavGraphViewModel()
) {
    deviceDetailViewModel.connectToDevice(nearbyDevice.bluetoothDevice)

    Column {
        Text(nearbyDevice.lastSeen)
    }
}