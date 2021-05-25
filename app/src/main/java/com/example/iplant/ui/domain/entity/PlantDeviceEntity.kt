package com.example.iplant.ui.domain.entity

import android.bluetooth.BluetoothDevice
import kotlinx.datetime.*

data class PlantDeviceEntity(val bluetoothDevice: BluetoothDevice, val lastSeen: Instant) {

    val deviceId: String = bluetoothDevice.address

    fun isExpired(): Boolean {
        val differenceInSec = lastSeen.until(Clock.System.now(), DateTimeUnit.SECOND, TimeZone.UTC)

        return differenceInSec >= 10
    }

}