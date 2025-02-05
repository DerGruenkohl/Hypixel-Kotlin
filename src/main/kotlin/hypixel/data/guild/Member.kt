package hypixel.data.guild


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Member(
    @SerialName("expHistory")
    val expHistory: ExpHistory,
    @SerialName("joined")
    val joined: Long,
    @SerialName("mutedTill")
    val mutedTill: Long? = null,
    @SerialName("questParticipation")
    val questParticipation: Int? = null,
    @SerialName("rank")
    val rank: String,
    @SerialName("uuid")
    val uuid: String
)