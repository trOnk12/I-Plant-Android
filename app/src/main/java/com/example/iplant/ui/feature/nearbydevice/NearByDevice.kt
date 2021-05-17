package com.example.iplant.ui.feature.nearbydevice

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.example.iplant.ui.feature.nearbydevice.model.UIPlantDevice

@Composable
fun NearByDeviceScreen(nearbyDeviceViewModel: NearbyDeviceViewModel) {
    val nearbyDeviceState = nearbyDeviceViewModel.liveData.observeAsState()

    NearByDeviceContent(nearbyDevices = nearbyDeviceState.value!!.devices)
}

@Composable
fun NearByDeviceContent(nearbyDevices: List<UIPlantDevice>) {
    LazyColumn {
        items(nearbyDevices) {
            Text(text = "test")
        }
    }
}