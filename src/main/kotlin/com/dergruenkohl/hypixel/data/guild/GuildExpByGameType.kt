package com.dergruenkohl.hypixel.data.guild


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildExpByGameType(
    @SerialName("ARCADE")
    val aRCADE: Long,
    @SerialName("ARENA")
    val aRENA: Long,
    @SerialName("BATTLEGROUND")
    val bATTLEGROUND: Long,
    @SerialName("BEDWARS")
    val bEDWARS: Long,
    @SerialName("BUILD_BATTLE")
    val bUILDBATTLE: Long,
    @SerialName("DUELS")
    val dUELS: Long,
    @SerialName("GINGERBREAD")
    val gINGERBREAD: Long,
    @SerialName("HOUSING")
    val hOUSING: Long,
    @SerialName("LEGACY")
    val lEGACY: Long,
    @SerialName("MCGO")
    val mCGO: Long,
    @SerialName("MURDER_MYSTERY")
    val mURDERMYSTERY: Long,
    @SerialName("PALongBALL")
    val pALongBALL: Long,
    @SerialName("PIT")
    val pIT: Long,
    @SerialName("PROTOTYPE")
    val pROTOTYPE: Long,
    @SerialName("QUAKECRAFT")
    val qUAKECRAFT: Long,
    @SerialName("REPLAY")
    val rEPLAY: Long,
    @SerialName("SKYBLOCK")
    val sKYBLOCK: Long,
    @SerialName("SKYWARS")
    val sKYWARS: Long,
    @SerialName("SMP")
    val sMP: Long,
    @SerialName("SPEED_UHC")
    val sPEEDUHC: Long,
    @SerialName("SUPER_SMASH")
    val sUPERSMASH: Long,
    @SerialName("SURVIVAL_GAMES")
    val sURVIVALGAMES: Long,
    @SerialName("TNTGAMES")
    val tNTGAMES: Long,
    @SerialName("UHC")
    val uHC: Long,
    @SerialName("VAMPIREZ")
    val vAMPIREZ: Long,
    @SerialName("WALLS")
    val wALLS: Long,
    @SerialName("WALLS3")
    val wALLS3: Long,
    @SerialName("WOOL_GAMES")
    val wOOLGAMES: Long
)