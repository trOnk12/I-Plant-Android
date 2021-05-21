package com.example.iplant.ui.domain.entity

import java.time.LocalDate

data class PlantDeviceEntity(val id: String, val lastSeen: LocalDate) {
    fun isExpired(): Boolean {
        return false
    }
}