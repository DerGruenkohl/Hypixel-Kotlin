package com.dergruenkohl.hypixel.data.guild


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Banner(
    @SerialName("Base")
    val base: Long,
    @SerialName("Patterns")
    val patterns: List<Pattern>
)