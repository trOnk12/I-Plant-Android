package com.example.iplant.ui.data

import com.example.iplant.ui.data.source.ble.IPlantBluetoothSource
import com.example.iplant.ui.domain.entity.PlantDevice
import com.example.iplant.ui.domain.repository.IPlantDeviceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IPlantDeviceRepositoryImpl @Inject constructor(
    private val iPlantBluetoothSource: IPlantBluetoothSource
) : IPlantDeviceRepository {

    override fun getNearbyDevice(): Flow<List<PlantDevice>> {
        return iPlantBluetoothSource.getNearby()
    }

}