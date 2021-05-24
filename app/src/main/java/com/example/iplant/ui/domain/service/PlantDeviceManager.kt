package com.example.iplant.ui.domain.service

import com.example.iplant.ui.domain.entity.NetworkEntity

interface PlantDeviceManager {
    suspend fun setDeviceName(name: String)
    suspend fun connectToNetwork(networkEntity: NetworkEntity)
}