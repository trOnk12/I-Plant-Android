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


//1.Connect to device
//2. After successfull connecting user enters name for plant

// We need a singleton object that allows to manipulate characteristics after connected to device

@HiltViewModel
class DeviceDetailViewModel @Inject constructor(
    connectToDevicesUseCaseFactory: ConnectToDeviceUseCaseFactory,
) : ReduxViewModel<DeviceDetailState>(DeviceDetailState()) {

    private val connectToDeviceUseCase by lazy {
        connectToDevicesUseCaseFactory.create(viewModelScope)
    }


    fun connectToDevice(bluetoothDevice: BluetoothDevice) {
        viewModelScope.launch {
            connectToDeviceUseCase.executeSync(bluetoothDevice)
        }
    }

}