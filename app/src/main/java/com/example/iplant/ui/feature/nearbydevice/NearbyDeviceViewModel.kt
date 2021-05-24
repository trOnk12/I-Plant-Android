package com.example.iplant.ui.feature.nearbydevice

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.iplant.ui.common.redux.ReduxViewModel
import com.example.iplant.ui.data.source.ble.toPlantDeviceEntity
import com.example.iplant.ui.domain.usecase.GetNearbyDevicesUseCase
import com.example.iplant.ui.feature.nearbydevice.model.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat
import no.nordicsemi.android.support.v18.scanner.ScanCallback
import no.nordicsemi.android.support.v18.scanner.ScanResult
import javax.inject.Inject

@HiltViewModel
class NearbyDeviceViewModel @Inject constructor(getNearbyDevicesUseCase: GetNearbyDevicesUseCase) :
    ReduxViewModel<NearbyDeviceState>(NearbyDeviceState()) {

    init {
        viewModelScope.launch {
            getNearbyDevicesUseCase
                .observe()
                .collectAndSetState { copy(devices = it.map()) }
        }

        getNearbyDevicesUseCase(Unit)
    }

}