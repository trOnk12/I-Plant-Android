package com.example.iplant.ui.feature.devicedetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun DeviceDetailScreen(deviceDetail: DeviceDetailState) {
    Column {
        Text(deviceDetail.name)
    }
}