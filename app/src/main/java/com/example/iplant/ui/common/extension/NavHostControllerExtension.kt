package com.example.iplant.ui.common.extension

import androidx.navigation.NavHostController
import java.io.Serializable

@Suppress("UNCHECKED_CAST")
fun <T> NavHostController.getArgument(name: String): T {
    return previousBackStackEntry?.arguments?.getSerializable(name) as? T
        ?: throw IllegalArgumentException()
}

fun NavHostController.putArgument(name: String, arg: Serializable) {
    currentBackStackEntry?.arguments?.putSerializable(name, arg)
}