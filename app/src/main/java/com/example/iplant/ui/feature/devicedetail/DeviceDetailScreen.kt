package com.example.iplant.ui.feature.devicedetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
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
        SimpleFilledTextFieldSample()
    }
}

@Composable
fun SimpleFilledTextFieldSample() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") }
    )
}