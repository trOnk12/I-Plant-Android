package com.example.iplant.ui.common.extension

fun <K, V> MutableMap<K, V>.putOrReplace(key: K, value: V): MutableMap<K, V> {
    val currentValue = putIfAbsent(key, value)

    if (currentValue != null) {
        replace(key, currentValue)
    }

    return this
}