package com.example.iplant.ui.data.source.ble

import com.example.iplant.ui.common.extension.putOrReplace
import com.example.iplant.ui.domain.entity.PlantDevice
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat
import no.nordicsemi.android.support.v18.scanner.ScanCallback
import no.nordicsemi.android.support.v18.scanner.ScanResult
import java.time.LocalDate
import javax.inject.Inject

class IPlantBluetoothSource @Inject constructor(private val scanner: BluetoothLeScannerCompat) {

    private val nearbyDevices = mutableMapOf<String, PlantDevice>()


    fun getNearby(): Flow<List<PlantDevice>> = flow {
        emit(listOf(PlantDevice("test", LocalDate.now())))
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
        nearbyDevices: MutableMap<String, PlantDevice>,
        recentlyScannedDevice: PlantDevice
    ): List<PlantDevice> {
        val nonExpiredDevices = filterExpiredDevices(nearbyDevices)
        val updatedDevices = updateNearbyDevices(nonExpiredDevices, recentlyScannedDevice)

        return updatedDevices.values.toList()
    }

    private fun filterExpiredDevices(nearbyDevices: MutableMap<String, PlantDevice>): Map<String, PlantDevice> =
        nearbyDevices.filterValues { it.isExpired() }

    private fun updateNearbyDevices(
        nearbyDevices: Map<String, PlantDevice>,
        recentlyScannedDevice: PlantDevice
    ): MutableMap<String, PlantDevice> {
        val mutableNearbyDevices = nearbyDevices.toMutableMap()

        return mutableNearbyDevices.putOrReplace(recentlyScannedDevice.id, recentlyScannedDevice)
    }

}

fun ScanResult.toPlantDevice(): PlantDevice {
    return PlantDevice(device.address, LocalDate.now())
}