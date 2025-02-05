package com.dergruenkohl.hypixel.data.player

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayerData(
    @SerialName("_id")
    val id: String,
    val uuid: String,
    val displayname: String? = null,
    val networkExp: Double,
    val lastLogout: Long,
    val socialMedia: SocialMedia? = null
)
