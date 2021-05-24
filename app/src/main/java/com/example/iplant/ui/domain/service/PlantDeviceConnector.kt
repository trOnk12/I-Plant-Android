package com.example.iplant.ui.domain.service

import com.example.iplant.ui.feature.nearbydevice.model.PlantDevice
import kotlinx.coroutines.flow.Flow

interface PlantDeviceConnector {
    suspend fun connectTo(plantDevice: PlantDevice) : Flow<ConnectorState>
}

sealed class ConnectorState
data class Connected(val plantDeviceManager: PlantDeviceManager) : ConnectorState()
object FailedToConnect : ConnectorState()


