package com.dergruenkohl.hypixel.data.guild


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Banner(
    @SerialName("Base")
    val base: Int,
    @SerialName("Patterns")
    val patterns: List<Pattern>
)