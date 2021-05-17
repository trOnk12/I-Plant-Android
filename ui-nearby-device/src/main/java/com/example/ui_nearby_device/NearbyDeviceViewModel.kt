package com.example.ui_nearby_device


import androidx.lifecycle.viewModelScope
import com.example.common_ui_view.ReduxViewModel
import com.example.domain.usecase.GetNearbyDevicesUseCase
import com.example.ui_nearby_device.model.map
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