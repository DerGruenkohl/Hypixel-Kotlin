package hypixel.data.guild


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Achievements(
    @SerialName("EXPERIENCE_KINGS")
    val eXPERIENCEKINGS: Int? = null,
    @SerialName("ONLINE_PLAYERS")
    val oNLINEPLAYERS: Int? = null,
    @SerialName("WINNERS")
    val wINNERS: Int? = null
)