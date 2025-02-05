package com.dergruenkohl.hypixel.data.player

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SocialMedia(
    val links: Links
)
@Serializable
data class Links(
    @SerialName("DISCORD")
    val discord: String? = null
)
