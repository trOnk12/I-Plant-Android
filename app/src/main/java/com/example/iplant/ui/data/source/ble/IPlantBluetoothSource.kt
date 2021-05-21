package com.example.iplant.ui.data.source.ble

import com.example.iplant.ui.common.extension.putOrReplace
import com.example.iplant.ui.domain.entity.PlantDeviceEntity
import com.example.iplant.ui.mock.mockNearbyDevices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat
import no.nordicsemi.android.support.v18.scanner.ScanResult
import java.time.LocalDate
import javax.inject.Inject

class IPlantBluetoothSource @Inject constructor(private val scanner: BluetoothLeScannerCompat) {

    private val nearbyDevices = mutableMapOf<String, PlantDeviceEntity>()

    fun getNearby(): Flow<List<PlantDeviceEntity>> = flow {
        emit(mockNearbyDevices)
    }

//    fun getNearby(): Flow<List<PlantDevice>> = callbackFlow {
//        val scanCallback = object : ScanCallback() {
//            override fun onScanResult(callbackType: Int, result: ScanResult) {
//                trySend(filterOnlyRecentDevices(nearbyDevices, result.toPlantDevice()))
//            }
//        }
//
//        scanner.startScan(scanCallback)
//
//        awaitClose { scanner.stopScan(scanCallback) }
//    }

    private fun filterOnlyRecentDevices(
        nearbyDevices: MutableMap<String, PlantDeviceEntity>,
        recentlyScannedDeviceEntity: PlantDeviceEntity
    ): List<PlantDeviceEntity> {
        val nonExpiredDevices = filterExpiredDevices(nearbyDevices)
        val updatedDevices = updateNearbyDevices(nonExpiredDevices, recentlyScannedDeviceEntity)

        return updatedDevices.values.toList()
    }

    private fun filterExpiredDevices(nearbyDevices: MutableMap<String, PlantDeviceEntity>): Map<String, PlantDeviceEntity> =
        nearbyDevices.filterValues { it.isExpired() }

    private fun updateNearbyDevices(
        nearbyDevices: Map<String, PlantDeviceEntity>,
        recentlyScannedDeviceEntity: PlantDeviceEntity
    ): MutableMap<String, PlantDeviceEntity> {
        val mutableNearbyDevices = nearbyDevices.toMutableMap()

        return mutableNearbyDevices.putOrReplace(recentlyScannedDeviceEntity.id, recentlyScannedDeviceEntity)
    }

}

fun ScanResult.toPlantDevice(): PlantDeviceEntity {
    return PlantDeviceEntity(device.address, LocalDate.now())
}