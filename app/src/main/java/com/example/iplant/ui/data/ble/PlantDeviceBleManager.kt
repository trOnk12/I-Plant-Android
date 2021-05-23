package com.example.iplant.ui.data.ble

import android.bluetooth.BluetoothDevice
import dagger.assisted.Assisted
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import no.nordicsemi.android.ble.observer.ConnectionObserver
import javax.inject.Inject

class PlantDeviceBleManager @Inject constructor(
    @Assisted private val externalScope: CoroutineScope,
    private val bluetoothDeviceManager: BluetoothDeviceManager
) : ConnectionObserver {

    private val _connectionStateFlow = MutableStateFlow<ConnectionState>(Initial)

    fun connect(device: BluetoothDevice): StateFlow<ConnectionState> {
        with(bluetoothDeviceManager) {
            setConnectionObserver(this@PlantDeviceBleManager)
            connect(device).enqueue()
        }

        return _connectionStateFlow.asStateFlow()
    }

    override fun onDeviceConnecting(device: BluetoothDevice) {
        externalScope.launch {
            _connectionStateFlow.emit(Connecting(device))
        }
    }

    override fun onDeviceConnected(device: BluetoothDevice) {
        externalScope.launch {
            _connectionStateFlow.emit(Connected(device))
        }
    }

    override fun onDeviceFailedToConnect(device: BluetoothDevice, reason: Int) {
        externalScope.launch {
            _connectionStateFlow.emit(FailedToConnect(device))
        }
    }

    override fun onDeviceReady(device: BluetoothDevice) {
        externalScope.launch {
            _connectionStateFlow.emit(DeviceReady(device))
        }
    }

    override fun onDeviceDisconnecting(device: BluetoothDevice) {
        externalScope.launch {
            _connectionStateFlow.emit(DeviceDisconnecting(device))
        }
    }

    override fun onDeviceDisconnected(device: BluetoothDevice, reason: Int) {
        externalScope.launch {
            _connectionStateFlow.emit(DeviceDisconnected(device))
        }
    }
}

sealed class ConnectionState
object Initial : ConnectionState()
data class Connecting(val device: BluetoothDevice) : ConnectionState()
data class Connected(val device: BluetoothDevice) : ConnectionState()
data class FailedToConnect(val device: BluetoothDevice) : ConnectionState()
data class DeviceReady(val device: BluetoothDevice) : ConnectionState()
data class DeviceDisconnecting(val device: BluetoothDevice) : ConnectionState()
data class DeviceDisconnected(val device: BluetoothDevice) : ConnectionState()
