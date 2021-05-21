package com.example.iplant.ui.feature.nearbydevice

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import com.example.iplant.ui.feature.nearbydevice.model.PlantDevice

@Preview
@Composable
fun NearByDeviceScreen(nearbyDeviceViewModel: NearbyDeviceViewModel = hiltNavGraphViewModel()) {
    val nearbyDeviceState by nearbyDeviceViewModel.liveData.observeAsState()

    if (nearbyDeviceState != null) {
        NearbyDeviceList(nearbyDevices = nearbyDeviceState!!.devices)
    }
}

@Composable
fun NearbyDeviceList(nearbyDevices: List<PlantDevice>) {
    LazyColumn {
        items(nearbyDevices) { nearbyDevice ->
            NearbyDeviceItem(plantDevice = nearbyDevice) { Log.d("TEST", "$nearbyDevice") }
        }
    }
}


@Composable
fun NearbyDeviceItem(plantDevice: PlantDevice, onClick: (PlantDevice) -> Unit) {
    Row(Modifier.clickable { onClick(plantDevice) }) {
        Image(
            painter = painterResource(id = android.R.drawable.ic_menu_call),
            contentDescription = null
        )
        Column {
            Text(text = "this is some plant name with id: ${plantDevice.id}")
        }
    }
}