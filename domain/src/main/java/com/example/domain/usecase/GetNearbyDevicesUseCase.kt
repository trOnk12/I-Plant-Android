package com.example.domain.usecase

import com.example.domain.SubjectInteractor
import com.example.domain.entity.PlantDevice
import com.example.domain.repository.IPlantDeviceRepository
import kotlinx.coroutines.flow.Flow

class GetNearbyDevicesUseCase(
    private val iPlantDeviceRepository: IPlantDeviceRepository
) : SubjectInteractor<Unit, List<PlantDevice>>() {

    override fun createObservable(params: Unit): Flow<List<PlantDevice>> =
        iPlantDeviceRepository.getNearbyDevice()

}