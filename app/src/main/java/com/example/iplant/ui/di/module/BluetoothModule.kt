package com.example.iplant.ui.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat

@Module
@InstallIn(SingletonComponent::class)
class BluetoothModule {

    @Provides
    fun provideBluetoothScanner(): BluetoothLeScannerCompat {
        return BluetoothLeScannerCompat.getScanner()
    }

}