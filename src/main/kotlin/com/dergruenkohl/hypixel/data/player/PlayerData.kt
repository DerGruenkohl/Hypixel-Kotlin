package com.dergruenkohl.hypixel.data.player

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayerData(
    @SerialName("_id")
    val id: String,
    val uuid: String,
    val displayname: String? = null,
    val networkExp: Double = 0.0,
    val lastLogout: Long = 0,
    val socialMedia: SocialMedia? = null
)
