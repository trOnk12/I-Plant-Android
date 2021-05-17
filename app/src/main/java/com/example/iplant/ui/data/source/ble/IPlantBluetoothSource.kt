package com.example.iplant.ui.data.source.ble

import com.example.iplant.ui.domain.entity.PlantDevice
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class IPlantBluetoothSource @Inject constructor() {
    fun getNearby(): Flow<List<PlantDevice>> = flow {
        repeat(100) {
            emit(listOf(PlantDevice("test"), PlantDevice("test"), PlantDevice("test")))
        }
    }

}