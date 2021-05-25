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
    getNearbyDevicesUseCase: GetNearbyDevicesUseCase
) : ReduxViewModel<NearbyDeviceState>(NearbyDeviceState()) {

    init {
        viewModelScope.launch {
            getNearbyDevicesUseCase
                .observe()
                .collectAndSetState { copy(devices = it.map()) }
        }

        getNearbyDevicesUseCase(Unit)
    }

}