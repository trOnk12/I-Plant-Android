package com.example.iplant.ui.feature.nearbydevice.model

import android.bluetooth.BluetoothDevice
import com.example.iplant.ui.domain.entity.PlantDeviceEntity

data class PlantDevice(val bluetoothDevice: BluetoothDevice, val lastSeen: String) {

    val id: String = bluetoothDevice.address

}

fun List<PlantDeviceEntity>.map(): List<PlantDevice> {
    return map {
        PlantDevice(
            bluetoothDevice = it.bluetoothDevice,
            lastSeen = it.lastSeen.toString()
        )
    }
}