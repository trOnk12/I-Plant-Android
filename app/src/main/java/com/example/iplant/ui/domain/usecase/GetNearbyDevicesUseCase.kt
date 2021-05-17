package com.example.iplant.ui.domain.usecase

import com.example.domain.SubjectInteractor
import com.example.iplant.ui.domain.entity.PlantDevice
import com.example.iplant.ui.domain.repository.IPlantDeviceRepository
import kotlinx.coroutines.flow.Flow

class GetNearbyDevicesUseCase(
    private val iPlantDeviceRepository: IPlantDeviceRepository
) : SubjectInteractor<Unit, List<PlantDevice>>() {

    override fun createObservable(params: Unit): Flow<List<PlantDevice>> =
        iPlantDeviceRepository.getNearbyDevice()

}