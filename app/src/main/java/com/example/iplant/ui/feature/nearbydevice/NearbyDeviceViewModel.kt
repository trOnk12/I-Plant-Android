package com.example.iplant.ui.feature.nearbydevice


import androidx.lifecycle.viewModelScope
import com.example.iplant.ui.domain.usecase.GetNearbyDevicesUseCase
import com.example.iplant.ui.common.redux.ReduxViewModel
import com.example.iplant.ui.feature.nearbydevice.model.map
import kotlinx.coroutines.launch

class NearbyDeviceViewModel(getNearbyDevicesUseCase: GetNearbyDevicesUseCase) :
    ReduxViewModel<NearbyDeviceState>(NearbyDeviceState()) {

    init {
        viewModelScope.launch {
            getNearbyDevicesUseCase.observe()
                .collectAndSetState { copy(devices = it.map()) }
        }
    }

}