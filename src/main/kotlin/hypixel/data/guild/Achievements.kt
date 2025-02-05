package hypixel.data.guild


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Achievements(
    @SerialName("EXPERIENCE_KINGS")
    val eXPERIENCEKINGS: Int,
    @SerialName("ONLINE_PLAYERS")
    val oNLINEPLAYERS: Int,
    @SerialName("WINNERS")
    val wINNERS: Int
)