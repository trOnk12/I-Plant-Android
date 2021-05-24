package com.example.iplant.ui.data.ble

import android.bluetooth.BluetoothDevice
import com.example.iplant.ui.domain.entity.NetworkEntity
import com.example.iplant.ui.domain.service.PlantDeviceManager
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import no.nordicsemi.android.ble.observer.ConnectionObserver
import javax.inject.Inject

class PlantDeviceBleManager @AssistedInject constructor(
   @Assisted private val bluetoothDevice : BluetoothDevice
) : PlantDeviceManager {

    override suspend fun setDeviceName(name: String) {

    }

    override suspend fun connectToNetwork(networkEntity: NetworkEntity) {

    }
}

sealed class ConnectionState
object Initial : ConnectionState()
data class DeviceConnecting(val device: BluetoothDevice) : ConnectionState()
data class DeviceConnected(val device: BluetoothDevice) : ConnectionState()
data class DeviceConnectionFailure(val device: BluetoothDevice) : ConnectionState()
data class DeviceReady(val device: BluetoothDevice) : ConnectionState()
data class DeviceDisconnecting(val device: BluetoothDevice) : ConnectionState()
data class DeviceDisconnected(val device: BluetoothDevice) : ConnectionState()
