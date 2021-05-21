package com.example.iplant.ui.feature.devicedetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.iplant.ui.feature.devicedetail.model.DeviceDetail


@Composable
fun DeviceDetailScreen(deviceDetail: DeviceDetail) {
    Column {
        Text(deviceDetail.name)
    }
}