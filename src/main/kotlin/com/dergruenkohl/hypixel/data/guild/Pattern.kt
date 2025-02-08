package com.dergruenkohl.hypixel.data.guild


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pattern(
    @SerialName("Color")
    val color: Int,
    @SerialName("Pattern")
    val pattern: String
)