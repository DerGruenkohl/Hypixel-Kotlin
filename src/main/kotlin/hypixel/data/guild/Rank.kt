package hypixel.data.guild


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rank(
    @SerialName("created")
    val created: Long,
    @SerialName("default")
    val default: Boolean = false,
    @SerialName("name")
    val name: String,
    @SerialName("priority")
    val priority: Int,
    @SerialName("tag")
    val tag: String? = null
)