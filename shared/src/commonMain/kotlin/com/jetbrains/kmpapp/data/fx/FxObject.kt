package com.jetbrains.kmpapp.data.fx

import kotlinx.serialization.Serializable

@Serializable
data class FxObject(
    val id: String,
    val from: String,
    val to: String,
    val value: Double,
    val date: String,
    val multiplier: Int,
)