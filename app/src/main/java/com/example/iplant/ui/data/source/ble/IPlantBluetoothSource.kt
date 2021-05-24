package com.example.iplant.ui.data.source.ble

import com.example.iplant.ui.domain.entity.PlantDeviceEntity
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.time.LocalDate
import javax.inject.Inject
import no.nordicsemi.android.support.v18.scanner.*


class IPlantBluetoothSource @Inject constructor(
    private val scanner: BluetoothLeScannerCompat,
    private val nearbyIPlantDeviceAggregator: NearbyIPlantDeviceAggregator
) {

    fun getNearby(): Flow<List<PlantDeviceEntity>> = callbackFlow {
        val scanCallback = object : ScanCallback() {
            override fun onScanResult(callbackType: Int, result: ScanResult) {
                trySend(nearbyIPlantDeviceAggregator.aggregate(result.toPlantDeviceEntity()))
            }
        }

        scanner.startScan(scanCallback)

        awaitClose { scanner.stopScan(scanCallback) }
    }
}

fun ScanResult.toPlantDeviceEntity(): PlantDeviceEntity {
    return PlantDeviceEntity(device.address, LocalDate.now())
}