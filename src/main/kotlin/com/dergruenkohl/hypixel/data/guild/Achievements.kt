package com.dergruenkohl.hypixel.data.guild


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Achievements(
    @SerialName("EXPERIENCE_KINGS")
    val eXPERIENCEKINGS: Long? = null,
    @SerialName("ONLINE_PLAYERS")
    val oNLINEPLAYERS: Long? = null,
    @SerialName("WINNERS")
    val wINNERS: Long? = null
)