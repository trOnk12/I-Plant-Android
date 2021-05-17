package com.example.iplant.ui.feature.nearbydevice

import androidx.lifecycle.viewModelScope
import com.example.iplant.ui.common.redux.ReduxViewModel
import com.example.iplant.ui.domain.usecase.GetNearbyDevicesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NearbyDeviceViewModel @Inject constructor(getNearbyDevicesUseCase: GetNearbyDevicesUseCase) :
    ReduxViewModel<NearbyDeviceState>(NearbyDeviceState()) {

    init {
        viewModelScope.launch {
            getNearbyDevicesUseCase.observe()
                .collectAndSetState {  }
        }
    }

}