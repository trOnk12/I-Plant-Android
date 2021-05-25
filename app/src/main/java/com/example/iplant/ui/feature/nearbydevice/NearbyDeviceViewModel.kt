package com.example.iplant.ui.feature.nearbydevice

import android.bluetooth.BluetoothDevice
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.iplant.ui.common.redux.ReduxViewModel
import com.example.iplant.ui.domain.usecase.ConnectToDeviceUseCaseFactory
import com.example.iplant.ui.domain.usecase.GetNearbyDevicesUseCase
import com.example.iplant.ui.feature.nearbydevice.model.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NearbyDeviceViewModel @Inject constructor(
    connectToDevicesUseCaseFactory: ConnectToDeviceUseCaseFactory,
    getNearbyDevicesUseCase: GetNearbyDevicesUseCase
) : ReduxViewModel<NearbyDeviceState>(NearbyDeviceState()) {

    private val connectToDeviceUseCase by lazy {
        connectToDevicesUseCaseFactory.create(viewModelScope)
    }

    init {
        viewModelScope.launch {
            getNearbyDevicesUseCase
                .observe()
                .collectAndSetState { copy(devices = it.map()) }
        }

        viewModelScope.launch {
            connectToDeviceUseCase
                .observe()
                .collect { Log.d("TEST", "$it") }
        }

        getNearbyDevicesUseCase(Unit)
    }

    fun connectToDevice(bluetoothDevice: BluetoothDevice) {
        connectToDeviceUseCase(bluetoothDevice)
    }

}