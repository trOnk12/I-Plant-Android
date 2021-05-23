package com.example.iplant.ui.data.ble

import android.bluetooth.BluetoothGatt
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import no.nordicsemi.android.ble.BleManager
import javax.inject.Inject

class BluetoothDeviceManager @Inject constructor(
    @ApplicationContext context: Context
) : BleManager(context) {

    private inner class ManagerGattCallback : BleManagerGattCallback() {
        override fun isRequiredServiceSupported(gatt: BluetoothGatt): Boolean {
            return true
        }

        override fun onDeviceDisconnected() {

        }
    }

    override fun getGattCallback(): BleManagerGattCallback {
        return ManagerGattCallback()
    }

}