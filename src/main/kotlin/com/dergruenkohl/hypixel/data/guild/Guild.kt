package com.dergruenkohl.hypixel.data.guild


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Guild(
    @SerialName("achievements")
    val achievements: Achievements,
    @SerialName("banner")
    val banner: Banner? = null,
    @SerialName("chatMute")
    val chatMute: Long? = null,
    @SerialName("coins")
    val coins: Int,
    @SerialName("coinsEver")
    val coinsEver: Int,
    @SerialName("created")
    val created: Long,
    @SerialName("description")
    val description: String? = null,
    @SerialName("exp")
    val exp: Int,
    @SerialName("guildExpByGameType")
    val guildExpByGameType: GuildExpByGameType,
    @SerialName("_id")
    val id: String,
    @SerialName("members")
    val members: List<Member>,
    @SerialName("name")
    val name: String,
    @SerialName("name_lower")
    val nameLower: String,
    @SerialName("ranks")
    val ranks: List<Rank> = emptyList(),
    @SerialName("tag")
    val tag: String? = null,
    @SerialName("tagColor")
    val tagColor: String? = null,
)