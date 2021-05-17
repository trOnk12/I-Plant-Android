package com.example.ui_nearby_device.model

import com.example.domain.entity.PlantDevice

data class UIPlantDevice(val id: String)

fun List<PlantDevice>.map() : List<UIPlantDevice>{
    return map { UIPlantDevice(id = it.id ) }
}