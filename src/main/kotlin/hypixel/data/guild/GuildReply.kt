package hypixel.data.guild


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildReply(
    @SerialName("guild")
    val guild: Guild? = null,
    @SerialName("success")
    val success: Boolean
)