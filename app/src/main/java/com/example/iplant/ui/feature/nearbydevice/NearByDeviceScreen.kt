package com.example.iplant.ui.feature.nearbydevice

import android.os.Bundle
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.iplant.ui.feature.nearbydevice.model.PlantDevice


@Composable
fun NearByDeviceScreen(
    navHostController: NavHostController,
    nearbyDeviceViewModel: NearbyDeviceViewModel = hiltNavGraphViewModel()
) {
    val nearbyDeviceState by nearbyDeviceViewModel.liveData.observeAsState()

    if (nearbyDeviceState != null) {
        NearbyDeviceList(
            onClick = {
                navHostController.currentBackStackEntry?.arguments?.putSerializable(
                    "nearbyDevice",
                    it
                )

                navHostController.navigate("deviceDetails")
            },
            nearbyDevices = nearbyDeviceState!!.devices
        )
    }
}

@Composable
fun NearbyDeviceList(onClick: (PlantDevice) -> Unit, nearbyDevices: List<PlantDevice>) {
    LazyColumn {
        items(nearbyDevices) { nearbyDevice ->
            NearbyDeviceItem(plantDevice = nearbyDevice) { onClick(it) }
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
            Text(text = "this is some plant name with id: ${plantDevice.id} and last seen $plantDevice")
        }
    }
}