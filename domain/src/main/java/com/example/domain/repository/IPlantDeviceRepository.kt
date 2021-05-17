package com.example.domain.repository

import com.example.domain.entity.PlantDevice
import kotlinx.coroutines.flow.Flow

interface IPlantDeviceRepository {
    fun getNearbyDevice() : Flow<List<PlantDevice>>
}