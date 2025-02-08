package com.dergruenkohl.hypixel.data.profile

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
    val profile: ProfileData? = null
)

@Serializable
data class ProfileData(
    @SerialName("profile_id")
    val profileID: String,
    @SerialName("community_upgrades")
    val communityUpgrades: JsonElement,
    val banking: JsonElement? = null,
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
    val playerData: Player_Data? = null,
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
    @SerialName("collection")
    val collections: Collections? = null,
    val bestiary: Bestiary? = null,

)
@Serializable
data class Bestiary(
    val migrations: Boolean = false,
    val kills: JsonElement? = null,
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
@Serializable
data class Player_Data(
    @SerialName("experience")
    val skills: Skills? = null,
)
@Serializable
data class Skills(
    @SerialName("SKILL_FISHING")
    val fishing: Double = 0.0,
    @SerialName("SKILL_ALCHEMY")
    val alchemy: Double= 0.0,
    @SerialName("SKILL_RUNECRAFTING")
    val runecrafting: Double = 0.0,
    @SerialName("SKILL_MINING")
    val mining: Double = 0.0,
    @SerialName("SKILL_FARMING")
    val farming: Double= 0.0,
    @SerialName("SKILL_ENCHANTING")
    val enchanting: Double = 0.0,
    @SerialName("SKILL_TAMING")
    val taming: Double = 0.0,
    @SerialName("SKILL_FORAGING")
    val foraging: Double = 0.0,
    @SerialName("SKILL_SOCIAL")
    val social: Double = 0.0,
    @SerialName("SKILL_CARPENTRY")
    val carpentry: Double= 0.0,
    @SerialName("SKILL_COMBAT")
    val combat: Double= 0.0,
){
    companion object{
        fun toLevel(skill: Double): Int{
            val levelThresholds = listOf(
                0L, 50L, 175L, 375L, 675L, 1175L, 1925L, 2925L, 4425L, 6425L,
                9925L, 14925L, 22425L, 32425L, 47425L, 67425L, 97425L, 147425L,
                222425L, 322425L, 522425L, 822425L, 1222425L, 1722425L, 2322425L,
                3022425L, 3822425L, 4722425L, 5722425L, 6822425L, 8022425L, 9322425L,
                10722425L, 12222425L, 13822425L, 15522425L, 17322425L, 19222425L,
                21222425L, 23322425L, 25522425L, 27822425L, 30222425L, 32722425L,
                35322425L, 38072425L, 40972425L, 44072425L, 47472425L, 51172425L,
                55172425L, 59472425L, 64072425L, 68972425L, 74172425L, 79672425L,
                85472425L, 91572425L, 97972425L, 104672425L, 111672425L
            )

            // Find the corresponding level
            for ((level, threshold) in levelThresholds.withIndex()) {
                if (skill < threshold) {
                    return level - 1
                }
            }
            // If the XP is greater than the highest threshold, return the max level
            return levelThresholds.size - 1
        }
    }


}
@Serializable
data class Collections(
    @SerialName("INK_SACK:3")
    val cocoabeans: Long = 0,
    @SerialName("CARROT_ITEM")
    val carrot: Long = 0,
    @SerialName("CACTUS")
    val cactus: Long = 0,
    @SerialName("RAW_CHICKEN")
    val rawchicken: Long = 0,
    @SerialName("SUGAR_CANE")
    val sugarcane: Long = 0,
    @SerialName("PUMPKIN")
    val pumpkin: Long = 0,
    @SerialName("WHEAT")
    val wheat: Long = 0,
    @SerialName("SEEDS")
    val seeds: Long = 0,
    @SerialName("MUSHROOM_COLLECTION")
    val mushroom: Long = 0,
    @SerialName("RABBIT")
    val rawrabbit: Long = 0,
    @SerialName("NETHER_STALK")
    val netherwart: Long = 0,
    @SerialName("MUTTON")
    val mutton: Long = 0,
    @SerialName("MELON")
    val melon: Long = 0,
    @SerialName("POTATO_ITEM")
    val potato: Long = 0,
    @SerialName("LEATHER")
    val leather: Long = 0,
    @SerialName("PORK")
    val rawporkchop: Long = 0,
    @SerialName("FEATHER")
    val feather: Long = 0,
    @SerialName("INK_SACK:4")
    val lapislazuli: Long = 0,
    @SerialName("REDSTONE")
    val redstone: Long = 0,
    @SerialName("UMBER")
    val umber: Long = 0,
    @SerialName("COAL")
    val coal: Long = 0,
    @SerialName("MYCEL")
    val mycelium: Long = 0,
    @SerialName("ENDER_STONE")
    val endstone: Long = 0,
    @SerialName("QUARTZ")
    val netherquartz: Long = 0,
    @SerialName("SAND")
    val sand: Long = 0,
    @SerialName("IRON_INGOT")
    val ironingot: Long = 0,
    @SerialName("GEMSTONE_COLLECTION")
    val gemstone: Long = 0,
    @SerialName("TUNGSTEN")
    val tungsten: Long = 0,
    @SerialName("OBSIDIAN")
    val obsidian: Long = 0,
    @SerialName("DIAMOND")
    val diamond: Long = 0,
    @SerialName("COBBLESTONE")
    val cobblestone: Long = 0,
    @SerialName("GLOWSTONE_DUST")
    val glowstonedust: Long = 0,
    @SerialName("GOLD_INGOT")
    val goldingot: Long = 0,
    @SerialName("GRAVEL")
    val gravel: Long = 0,
    @SerialName("HARD_STONE")
    val hardstone: Long = 0,
    @SerialName("MITHRIL_ORE")
    val mithril: Long = 0,
    @SerialName("EMERALD")
    val emerald: Long = 0,
    @SerialName("SAND:1")
    val redsand: Long = 0,
    @SerialName("ICE")
    val ice: Long = 0,
    @SerialName("GLACITE")
    val glacite: Long = 0,
    @SerialName("SULPHUR_ORE")
    val sulphur: Long = 0,
    @SerialName("NETHERRACK")
    val netherrack: Long = 0,
    @SerialName("ENDER_PEARL")
    val enderpearl: Long = 0,
    @SerialName("CHILI_PEPPER")
    val chilipepper: Long = 0,
    @SerialName("SLIME_BALL")
    val slimeball: Long = 0,
    @SerialName("MAGMA_CREAM")
    val magmacream: Long = 0,
    @SerialName("GHAST_TEAR")
    val ghasttear: Long = 0,
    @SerialName("SULPHUR")
    val gunpowder: Long = 0,
    @SerialName("ROTTEN_FLESH")
    val rottenflesh: Long = 0,
    @SerialName("SPIDER_EYE")
    val spidereye: Long = 0,
    @SerialName("BONE")
    val bone: Long = 0,
    @SerialName("BLAZE_ROD")
    val blazerod: Long = 0,
    @SerialName("STRING")
    val string: Long = 0,
    @SerialName("LOG_2")
    val acaciawood: Long = 0,
    @SerialName("LOG:1")
    val sprucewood: Long = 0,
    @SerialName("LOG:3")
    val junglewood: Long = 0,
    @SerialName("LOG:2")
    val birchwood: Long = 0,
    @SerialName("LOG")
    val oakwood: Long = 0,
    @SerialName("LOG_2:1")
    val darkoakwood: Long = 0,
    @SerialName("WATER_LILY")
    val lilypad: Long = 0,
    @SerialName("PRISMARINE_SHARD")
    val prismarineshard: Long = 0,
    @SerialName("INK_SACK")
    val inksac: Long = 0,
    @SerialName("RAW_FISH")
    val rawfish: Long = 0,
    @SerialName("RAW_FISH:3")
    val pufferfish: Long = 0,
    @SerialName("RAW_FISH:2")
    val clownfish: Long = 0,
    @SerialName("RAW_FISH:1")
    val rawsalmon: Long = 0,
    @SerialName("MAGMA_FISH")
    val magmafish: Long = 0,
    @SerialName("PRISMARINE_CRYSTALS")
    val prismarinecrystals: Long = 0,
    @SerialName("CLAY_BALL")
    val clay: Long = 0,
    @SerialName("SPONGE")
    val sponge: Long = 0,
    @SerialName("WILTED_BERBERIS")
    val wiltedberberis: Long = 0,
    @SerialName("METAL_HEART")
    val livingmetalheart: Long = 0,
    @SerialName("CADUCOUS_STEM")
    val caducousstem: Long = 0,
    @SerialName("AGARICUS_CAP")
    val agaricuscap: Long = 0,
    @SerialName("HEMOVIBE")
    val hemovibe: Long = 0,
    @SerialName("HALF_EATEN_CARROT")
    val halfeatencarrot: Long = 0,
    @SerialName("TIMITE")
    val timite: Long = 0,

)
