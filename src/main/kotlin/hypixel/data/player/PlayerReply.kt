package com.dergruenkohl.hypixel.data.player

import kotlinx.serialization.Serializable

@Serializable
data class PlayerReply(
    val success: Boolean,
    val player: PlayerData
)
