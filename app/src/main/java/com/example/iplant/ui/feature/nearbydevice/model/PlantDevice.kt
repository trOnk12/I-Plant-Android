package com.example.iplant.ui.feature.nearbydevice.model

import com.example.iplant.ui.domain.entity.PlantDeviceEntity

data class PlantDevice(val id: String,val lastSeen : String)

fun List<PlantDeviceEntity>.map(): List<PlantDevice> {
    return map { PlantDevice(id = it.id, lastSeen = it.lastSeen.toString()) }
}