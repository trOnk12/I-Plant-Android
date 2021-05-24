package com.example.iplant.ui.domain.entity

import kotlinx.datetime.*

data class PlantDeviceEntity(val id: String, val lastSeen: Instant) {

    fun isExpired(): Boolean {
        val differenceInSec = lastSeen.until(Clock.System.now(), DateTimeUnit.SECOND, TimeZone.UTC)

        return differenceInSec >= 10
    }

}