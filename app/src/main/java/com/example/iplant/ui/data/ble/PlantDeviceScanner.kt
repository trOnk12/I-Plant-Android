package com.example.iplant.ui.data.ble

import android.os.ParcelUuid
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat
import no.nordicsemi.android.support.v18.scanner.ScanCallback
import no.nordicsemi.android.support.v18.scanner.ScanFilter
import no.nordicsemi.android.support.v18.scanner.ScanSettings
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.collections.ArrayList


@Singleton
class PlantDeviceScanner @Inject constructor(private val scanner: BluetoothLeScannerCompat) {

    fun startScanning(callback: ScanCallback) {
        val settings: ScanSettings = ScanSettings.Builder()
            .setScanMode(ScanSettings.SCAN_MODE_LOW_POWER)
            .build()

        val filters: MutableList<ScanFilter> = ArrayList()
        filters.add(
            ScanFilter.Builder()
                .setServiceUuid(ParcelUuid(UUID.fromString("84b3571a-98d0-46fe-95c2-bb2fc4b126ad")))
                .build()
        )

        scanner.startScan(filters, settings, callback)
    }

    fun stopScanning(callback: ScanCallback) {
        scanner.startScan(callback)
    }

}