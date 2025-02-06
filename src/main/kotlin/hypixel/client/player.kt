package com.dergruenkohl.hypixel.client

import com.dergruenkohl.hypixel.data.player.PlayerReply
import hypixel.data.profile.ProfileData
import hypixel.data.profile.ProfileMember
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
suspend fun HypixelClient.getSelectedProfileReply(uuid: String): ProfileReply? {
    val profileId = this.getSelectedProfileID(uuid) ?: return null

    return this.makeAuthenticatedRequest<ProfileReply>("skyblock/profile", "profile" to profileId)
}
suspend fun HypixelClient.getSelectedProfileMember(uuid: String): ProfileMember? {
    val reply = this.getSelectedProfileReply(uuid) ?: return null
    if (!reply.success) return null
    return reply.profile?.members?.first {
        it.uuid.replace("-", "") == uuid.replace("-", "")
    }?: return null
}
