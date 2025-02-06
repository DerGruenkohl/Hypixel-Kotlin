package hypixel.data.profile

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlin.math.cbrt

@Serializable
internal data class ProfilesReply(
    val success: Boolean,
    val profiles: List<InternalProfileData>
)
@Serializable
internal data class InternalProfileData(
    @SerialName("profile_id")
    val profileID: String,
    @SerialName("cute_name")
    val cuteName: String? = null,
    val selected: Boolean? = null,
)


@Serializable
data class ProfileReply(
    val success: Boolean,
    val profile: ProfileData
)

@Serializable
data class ProfileData(
    @SerialName("profile_id")
    val profileID: String,
    @SerialName("community_upgrades")
    val communityUpgrades: JsonElement,
    val banking: String? = null,
    @Serializable(with = ProfileMemberDeserializer::class)
    val members: List<ProfileMember>
    )

object ProfileMemberDeserializer : KSerializer<List<ProfileMember>> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("ProfileMember")

    override fun deserialize(decoder: Decoder): List<ProfileMember> {
        val jsonDecoder = decoder as JsonDecoder
        val jsonElement = jsonDecoder.decodeJsonElement()
        val jsonObject = jsonElement.jsonObject

        return jsonObject.map { (key, value) ->
            jsonDecoder.json.decodeFromJsonElement(ProfileMember.serializer(), value)
        }
    }

    override fun serialize(encoder: Encoder, value: List<ProfileMember>) {
        // Implement serialization if needed
    }
}


@Serializable
data class ProfileMember(
    @SerialName("player_id")
    val uuid: String,
    @SerialName("player_data")
    val playerData: JsonElement? = null,
    @SerialName("glacite_player_data")
    val glaciteData: JsonElement? = null,
    val rift: JsonElement? = null,
    val events: JsonElement? = null,
    @SerialName("garden_player_data")
    val gardenData: JsonElement? = null,
    @SerialName("accessory_bag_storage")
    val accessoryBag: JsonElement? = null,
    val leveling: LevelData? = null,
    val currencies: CoinData? = null,

)
@Serializable
data class LevelData(
    val experience: Int,
){
    fun getLevel(): Int{
        return (experience/1000.0).toInt()
    }
}
@Serializable
data class CoinData(
    @SerialName("coin_purse")
    val coins: Double,
    @SerialName("motes_purse")
    val motes: Double? = null,
    val essence: JsonElement? = null,
)
