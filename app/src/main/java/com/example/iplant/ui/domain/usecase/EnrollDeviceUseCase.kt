package com.example.iplant.ui.domain.usecase

import com.example.iplant.ui.common.interactor.SubjectInteractor
import com.example.iplant.ui.data.ble.PlantDeviceBleManager
import com.example.iplant.ui.domain.entity.EnrollmentDataEntity
import com.example.iplant.ui.domain.entity.NetworkEntity
import com.example.iplant.ui.domain.service.PlantDeviceConnector
import com.example.iplant.ui.domain.service.PlantDeviceManager
import dagger.assisted.Assisted
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

//1. Connect to device
//2. Set name of the device
//3. Set SSID and password of the network
//4. Wait for the device to connect to WiFi
class EnrollDeviceUseCase @Inject constructor(
    @Assisted private val plantDeviceBleManager: PlantDeviceBleManager
) : SubjectInteractor<EnrollmentDataEntity, EnrollmentStatus>() {

    override fun createObservable(params: EnrollmentDataEntity) = flow {
        emit(Configuration)
        plantDeviceBleManager.setDeviceName(params.name)
        emit(ConnectingToNetwork)
        plantDeviceBleManager.connectToNetwork(
            NetworkEntity(
                params.networkName,
                params.networkPassword
            )
        )
        emit(Completed)
    }

}


sealed class EnrollmentStatus
object Configuration : EnrollmentStatus()
object ConnectingToNetwork : EnrollmentStatus()
object Completed : EnrollmentStatus()