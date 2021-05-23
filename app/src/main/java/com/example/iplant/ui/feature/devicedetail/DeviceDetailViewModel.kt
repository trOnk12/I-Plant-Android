package com.example.iplant.ui.feature.devicedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iplant.ui.domain.usecase.ConnectToDeviceUseCase
import com.example.iplant.ui.feature.nearbydevice.model.PlantDevice
import dagger.assisted.Assisted
import kotlinx.coroutines.launch
import javax.inject.Inject

class DeviceDetailViewModel @Inject constructor(
    private val connectToDeviceUseCase: ConnectToDeviceUseCase,
    @Assisted private val plantDevice: PlantDevice
) : ViewModel() {

    init {
        viewModelScope.launch {
            connectToDeviceUseCase(plantDevice)
        }
    }

}