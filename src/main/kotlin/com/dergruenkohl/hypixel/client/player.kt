package com.dergruenkohl.hypixel.client

import com.dergruenkohl.hypixel.data.player.PlayerReply
import com.dergruenkohl.hypixel.data.profile.ProfileMember
import com.dergruenkohl.hypixel.data.profile.ProfileReply
import com.dergruenkohl.hypixel.data.profile.ProfilesReply
import com.dergruenkohl.hypixel.exceptions.HypixelException

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
suspend fun HypixelClient.getProfileReply(uuid: String, profileID: String): ProfileReply {
    val profile: ProfileReply = this.makeAuthenticatedRequest<ProfileReply>("skyblock/profile", "profile" to profileID)
    if (!profile.success) {
        throw HypixelException("Failed to get profile")
    }
    return profile
}

suspend fun HypixelClient.getProfileMember(uuid: String, profileID: String): ProfileMember {
    val profile = this.getProfileReply(uuid, profileID)
    if (!profile.success) {
        throw HypixelException("Failed to get profile")
    }
    return profile.profile?.members?.first {
        it.uuid.replace("-", "") == uuid.replace("-", "")
    }?: throw HypixelException("Failed to get member")
}
