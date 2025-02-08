package com.dergruenkohl.hypixel.data.guild


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildExpByGameType(
    @SerialName("ARCADE")
    val aRCADE: Int,
    @SerialName("ARENA")
    val aRENA: Int,
    @SerialName("BATTLEGROUND")
    val bATTLEGROUND: Int,
    @SerialName("BEDWARS")
    val bEDWARS: Int,
    @SerialName("BUILD_BATTLE")
    val bUILDBATTLE: Int,
    @SerialName("DUELS")
    val dUELS: Int,
    @SerialName("GINGERBREAD")
    val gINGERBREAD: Int,
    @SerialName("HOUSING")
    val hOUSING: Int,
    @SerialName("LEGACY")
    val lEGACY: Int,
    @SerialName("MCGO")
    val mCGO: Int,
    @SerialName("MURDER_MYSTERY")
    val mURDERMYSTERY: Int,
    @SerialName("PAINTBALL")
    val pAINTBALL: Int,
    @SerialName("PIT")
    val pIT: Int,
    @SerialName("PROTOTYPE")
    val pROTOTYPE: Long,
    @SerialName("QUAKECRAFT")
    val qUAKECRAFT: Int,
    @SerialName("REPLAY")
    val rEPLAY: Int,
    @SerialName("SKYBLOCK")
    val sKYBLOCK: Int,
    @SerialName("SKYWARS")
    val sKYWARS: Int,
    @SerialName("SMP")
    val sMP: Int,
    @SerialName("SPEED_UHC")
    val sPEEDUHC: Int,
    @SerialName("SUPER_SMASH")
    val sUPERSMASH: Int,
    @SerialName("SURVIVAL_GAMES")
    val sURVIVALGAMES: Int,
    @SerialName("TNTGAMES")
    val tNTGAMES: Int,
    @SerialName("UHC")
    val uHC: Int,
    @SerialName("VAMPIREZ")
    val vAMPIREZ: Int,
    @SerialName("WALLS")
    val wALLS: Int,
    @SerialName("WALLS3")
    val wALLS3: Int,
    @SerialName("WOOL_GAMES")
    val wOOLGAMES: Int
)