package com.example.iplant.ui.domain.usecase

import android.bluetooth.BluetoothDevice
import android.util.Log
import com.example.iplant.ui.common.interactor.ResultInteractor
import com.example.iplant.ui.common.interactor.SubjectInteractor
import com.example.iplant.ui.data.ble.Connection
import com.example.iplant.ui.data.ble.PlantDeviceBleManager
import com.example.iplant.ui.data.ble.PlantDeviceBleManagerFactory
import com.example.iplant.ui.domain.service.Connected
import com.example.iplant.ui.domain.service.ConnectorState
import com.example.iplant.ui.domain.service.PlantDeviceManager
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class ConnectToDeviceUseCase @AssistedInject constructor(
    @Assisted private val coroutineScope: CoroutineScope,
    private val plantDeviceBleManagerFactory: PlantDeviceBleManagerFactory,
) : ResultInteractor<BluetoothDevice, Connection>() {

    override suspend fun doWork(params: BluetoothDevice) =
        plantDeviceBleManagerFactory.create(coroutineScope).connectTo(params)

}

@AssistedFactory
interface ConnectToDeviceUseCaseFactory {
    fun create(coroutineScope: CoroutineScope): ConnectToDeviceUseCase
}