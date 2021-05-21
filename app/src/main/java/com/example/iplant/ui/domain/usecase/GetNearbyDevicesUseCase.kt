package com.example.iplant.ui.domain.usecase

import com.example.iplant.ui.common.interactor.SubjectInteractor
import com.example.iplant.ui.data.IPlantDeviceRepositoryImpl
import com.example.iplant.ui.domain.entity.PlantDevice
import com.example.iplant.ui.domain.repository.IPlantDeviceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import javax.inject.Inject

class GetNearbyDevicesUseCase @Inject constructor(
    private val iPlantDeviceRepository: IPlantDeviceRepositoryImpl
) : SubjectInteractor<Unit, List<PlantDevice>>() {

    override fun createObservable(params: Unit): Flow<List<PlantDevice>> {
      return iPlantDeviceRepository.getNearbyDevice()
    }

}