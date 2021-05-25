package com.example.iplant.ui.data.service

import com.example.iplant.ui.data.ble.*
import com.example.iplant.ui.domain.service.Connected
import com.example.iplant.ui.domain.service.ConnectorState
import com.example.iplant.ui.domain.service.FailedToConnect
import com.example.iplant.ui.domain.service.PlantDeviceConnector
import com.example.iplant.ui.feature.nearbydevice.model.PlantDevice
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

//
//class PlantDeviceConnectorImpl @Inject constructor(
//    private val plantDeviceBleConnector: PlantDeviceBleConnector
//) : PlantDeviceConnector {
//
//    override fun connectTo(plantDevice: PlantDevice): Flow<ConnectorState> = flow {
//
//        emit(FailedToConnect)
////        plantDeviceBleConnector.connect().collect { connectionState ->
////            if (connectionState is DeviceConnected) {
////                emit(Connected(PlantDeviceBleManager(connectionState.device)))
////            }
////            if (connectionState is DeviceDisconnected) {
////                emit(FailedToConnect)
////            }
//        }
////    }
////
//}
