package com.example.iplant.ui.feature.nearbydevice.model

import com.example.iplant.ui.domain.entity.PlantDevice

data class UIPlantDevice(val id: String)

fun List<PlantDevice>.map() : List<UIPlantDevice>{
    return map { UIPlantDevice(id = it.id ) }
}