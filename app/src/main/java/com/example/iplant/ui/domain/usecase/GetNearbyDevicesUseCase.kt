package com.example.iplant.ui.domain.usecase

import com.example.iplant.ui.common.interactor.SubjectInteractor
import com.example.iplant.ui.data.IPlantDeviceRepositoryImpl
import com.example.iplant.ui.domain.entity.PlantDeviceEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNearbyDevicesUseCase @Inject constructor(
    private val iPlantDeviceRepository: IPlantDeviceRepositoryImpl
) : SubjectInteractor<Unit, List<PlantDeviceEntity>>() {

    override fun createObservable(params: Unit): Flow<List<PlantDeviceEntity>> {
        return iPlantDeviceRepository.getNearbyDevice()
    }

}