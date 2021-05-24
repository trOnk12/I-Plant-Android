package com.example.iplant.ui.domain.usecase

import com.example.iplant.ui.common.interactor.Interactor
import com.example.iplant.ui.domain.service.PlantDeviceConnector
import com.example.iplant.ui.feature.nearbydevice.model.PlantDevice
import javax.inject.Inject

//class ConnectToDeviceUseCase @Inject constructor(
//    private val plantDeviceConnector: PlantDeviceConnector
//) : Interactor<PlantDevice>() {
//
//    override suspend fun doWork(params: PlantDevice) =
//        plantDeviceConnector.connectTo(plantDevice = params)
//
//}