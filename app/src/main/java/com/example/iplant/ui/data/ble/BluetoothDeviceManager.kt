//package com.example.iplant.ui.data.ble
//
//import android.bluetooth.BluetoothGatt
//import android.content.Context
//import dagger.hilt.android.qualifiers.ApplicationContext
//import no.nordicsemi.android.ble.BleManager
//import javax.inject.Inject
//import android.bluetooth.BluetoothGattCharacteristic
//import java.util.*
//import javax.inject.Singleton
//
//
//@Singleton
//class BluetoothDeviceManager @Inject constructor(
//    @ApplicationContext context: Context
//) : BleManager(context) {
//
//    companion object {
//        private val GENERAL_INFO_SERVICE_UUID =
//            UUID.fromString("3057b961-e173-4aae-8432-565f123daaa5")
////        private val NETWORK_INFO_SERVICE_UUID = UUID.fromString("")
//
//        private val DEVICE_NAME_CHARACTERISTIC_UUID =
//            UUID.fromString("547de50b-14b8-49fc-9c88-deb5b65cf716")
////        private val WIFI_SSID_NAME_CHARACTERISTIC_UUID = UUID.fromString("")
////        private val WIFI_PASSWORD_CHARACTERISTIC_UUID = UUID.fromString("")
//    }
//
//    private var deviceNameCharacteristic: BluetoothGattCharacteristic? = null
//    private var wifiSSIDNameCharacteristic: BluetoothGattCharacteristic? = null
//    private var wifiPasswordCharacteristic: BluetoothGattCharacteristic? = null
//
//    private inner class ManagerGattCallback : BleManagerGattCallback() {
//        override fun isRequiredServiceSupported(gatt: BluetoothGatt): Boolean {
//            val service = gatt.getService(GENERAL_INFO_SERVICE_UUID)
//            if (service != null) {
//                deviceNameCharacteristic =
//                    service.getCharacteristic(DEVICE_NAME_CHARACTERISTIC_UUID)
//            }
//
//            return deviceNameCharacteristic != null
//        }
//
//        override fun onDeviceDisconnected() {
//
//        }
//    }
//
//    override fun getGattCallback(): BleManagerGattCallback {
//        return ManagerGattCallback()
//    }
//
//
//}