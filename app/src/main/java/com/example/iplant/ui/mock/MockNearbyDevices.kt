package com.example.iplant.ui.mock

import com.example.iplant.ui.domain.entity.PlantDeviceEntity
import java.time.LocalDate

val mockNearbyDevices = listOf(
    PlantDeviceEntity("test1", LocalDate.now()),
    PlantDeviceEntity("test2", LocalDate.now()),
    PlantDeviceEntity("test3", LocalDate.now()),
    PlantDeviceEntity("test4", LocalDate.now())
)