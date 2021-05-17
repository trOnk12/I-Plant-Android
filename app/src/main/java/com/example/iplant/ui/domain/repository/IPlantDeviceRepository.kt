package com.example.iplant.ui.domain.repository

import com.example.iplant.ui.domain.entity.PlantDevice
import kotlinx.coroutines.flow.Flow

interface IPlantDeviceRepository {
    fun getNearbyDevice() : Flow<List<PlantDevice>>
}