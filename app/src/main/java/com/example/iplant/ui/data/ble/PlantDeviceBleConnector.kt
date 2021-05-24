package com.example.iplant.ui.data.ble

import android.bluetooth.BluetoothDevice
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import no.nordicsemi.android.ble.observer.ConnectionObserver
import javax.inject.Inject

class PlantDeviceBleConnector @AssistedInject constructor(
    @Assisted private val externalScope: CoroutineScope,
    private val bluetoothDeviceManager: BluetoothDeviceManager
) : ConnectionObserver {

    init {
        bluetoothDeviceManager.setConnectionObserver(this)
    }

    private val _connectionStateFlow = MutableStateFlow<ConnectionState>(Initial)

    fun connect(device: BluetoothDevice): StateFlow<ConnectionState> {
        bluetoothDeviceManager.connect(device).enqueue()

        return _connectionStateFlow.asStateFlow()
    }

    override fun onDeviceConnecting(device: BluetoothDevice) {
        externalScope.launch {
            _connectionStateFlow.emit(DeviceConnecting(device))
        }
    }

    override fun onDeviceConnected(device: BluetoothDevice) {
        externalScope.launch {
            _connectionStateFlow.emit(DeviceConnected(device))
        }
    }

    override fun onDeviceFailedToConnect(device: BluetoothDevice, reason: Int) {
        externalScope.launch {
            _connectionStateFlow.emit(DeviceConnectionFailure(device))
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