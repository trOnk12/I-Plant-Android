package com.example.iplant.ui.data.source.ble

import com.example.iplant.ui.common.extension.putOrReplace
import com.example.iplant.ui.domain.entity.PlantDeviceEntity
import javax.inject.Inject

class NearbyIPlantDeviceAggregator @Inject constructor() {

    private val nearbyDevices = mutableMapOf<String, PlantDeviceEntity>()

    fun aggregate(nearbyDevice: PlantDeviceEntity): List<PlantDeviceEntity> {
        nearbyDevices.putAll(
            updateRecentlyScannedDevice(
                nearbyDevice,
                filterExpiredDevices(nearbyDevices)
            )
        )

        return nearbyDevices.values.toList()
    }

    private fun filterExpiredDevices(nearbyDevices: MutableMap<String, PlantDeviceEntity>) =
        nearbyDevices.filterValues { it.isExpired() }

    private fun updateRecentlyScannedDevice(
        recentlyScannedDevice: PlantDeviceEntity,
        nearbyDevices: Map<String, PlantDeviceEntity>
    ): MutableMap<String, PlantDeviceEntity> {
        val snapShot = nearbyDevices.toMutableMap()

        return snapShot.putOrReplace(
            recentlyScannedDevice.deviceId,
            recentlyScannedDevice
        )
    }

}