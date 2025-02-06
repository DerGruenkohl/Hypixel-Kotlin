package com.dergruenkohl.hypixel.client

import com.dergruenkohl.hypixel.data.player.PlayerReply
import hypixel.data.profile.ProfileData
import hypixel.data.profile.ProfileReply
import hypixel.data.profile.ProfilesReply

suspend fun HypixelClient.getPlayer(uuid: String): PlayerReply {
    return this.makeAuthenticatedRequest("player", "uuid" to uuid)
}

suspend fun HypixelClient.getSelectedProfileID(uuid: String): String? {
    return this.makeAuthenticatedRequest<ProfilesReply>(
        "skyblock/profiles",
        "uuid" to uuid
    ).profiles.firstOrNull { it.selected == true }?.profileID
}
suspend fun HypixelClient.getSelectedProfile(uuid: String): ProfileReply? {
    val profileId = this.getSelectedProfileID(uuid) ?: return null

    return this.makeAuthenticatedRequest<ProfileReply>("skyblock/profile", "profile" to profileId)
}
