package com.example.iplant.ui.feature.devicedetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.iplant.ui.feature.nearbydevice.model.PlantDevice

@Composable
fun DeviceDetailScreen(deviceDetail: PlantDevice) {
    Column {
        Text(deviceDetail.lastSeen)
    }
}