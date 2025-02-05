package com.dergruenkohl.hypixel.client

import hypixel.data.guild.GuildReply

suspend fun HypixelClient.getGuildByPlayer(uuid: String): GuildReply {
    return this.makeAuthenticatedRequest("guild", "player" to uuid)
}
suspend fun HypixelClient.getGuildByName(name: String): GuildReply {
    return this.makeAuthenticatedRequest("guild", "name" to name)
}
suspend fun HypixelClient.getGuildById(id: String): GuildReply {
    return this.makeAuthenticatedRequest("guild", "id" to id)
}