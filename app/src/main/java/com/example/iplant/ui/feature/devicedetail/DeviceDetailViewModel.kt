package com.example.iplant.ui.feature.devicedetail

import android.bluetooth.BluetoothDevice
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.iplant.ui.common.redux.ReduxViewModel
import com.example.iplant.ui.domain.usecase.ConnectToDeviceUseCaseFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeviceDetailViewModel @Inject constructor(
    connectToDevicesUseCaseFactory: ConnectToDeviceUseCaseFactory,
) : ReduxViewModel<DeviceDetailState>(DeviceDetailState()) {

    private val connectToDeviceUseCase by lazy {
        connectToDevicesUseCaseFactory.create(viewModelScope)
    }

    init {
        viewModelScope.launch {
            connectToDeviceUseCase
                .observe()
                .collect { Log.d("TEST", "$it") }
        }
    }

    fun connectToDevice(bluetoothDevice: BluetoothDevice) {
        connectToDeviceUseCase(bluetoothDevice)
    }

}