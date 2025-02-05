package com.dergruenkohl.hypixel.client

import com.dergruenkohl.hypixel.data.player.PlayerReply

suspend fun HypixelClient.getPlayer(uuid: String): PlayerReply {
    return this.makeAuthenticatedRequest("player", "uuid" to uuid)
}