package com.example.iplant.ui.feature.nearbydevice

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.iplant.ui.feature.nearbydevice.model.UIPlantDevice

@Composable
fun NearByDeviceScreen(nearbyDeviceViewModel: NearbyDeviceViewModel = hiltNavGraphViewModel()) {
    val nearbyDeviceState = nearbyDeviceViewModel.liveData.observeAsState()

}

@Composable
fun NearByDeviceContent(nearbyDevices: List<UIPlantDevice>) {
    LazyColumn {
        items(nearbyDevices) {
            Text(text = "test")
        }
    }
}