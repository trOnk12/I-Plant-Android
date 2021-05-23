package com.example.iplant.ui.domain.usecase

import com.example.iplant.ui.common.interactor.Interactor
import com.example.iplant.ui.domain.service.PlantDeviceManager
import com.example.iplant.ui.feature.nearbydevice.model.PlantDevice
import javax.inject.Inject

class ConnectToDeviceUseCase @Inject constructor(
    private val plantDeviceManager: PlantDeviceManager
) : Interactor<PlantDevice>() {

    override suspend fun doWork(params: PlantDevice) =
        plantDeviceManager.connect(plantDevice = params)

}