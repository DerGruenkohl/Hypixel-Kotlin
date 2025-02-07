package hypixel

import com.dergruenkohl.hypixel.client.*
import com.dergruenkohl.hypixel.data.player.PlayerReply
import hypixel.data.profile.ProfileMember
import hypixel.data.profile.ProfileReply
import kotlinx.coroutines.runBlocking

class HypixelClientWrapper(private val client: HypixelClient) {
    fun getPlayer(uuid: String): PlayerReply = runBlocking {
        client.getPlayer(uuid)
    }

    fun getSelectedProfileID(uuid: String): String? = runBlocking {
        client.getSelectedProfileID(uuid)
    }

    fun getSelectedProfileReply(uuid: String): ProfileReply? = runBlocking {
        client.getSelectedProfileReply(uuid)
    }
    fun getSelectedProfileMember(uuid: String): ProfileMember? = runBlocking {
        client.getSelectedProfileMember(uuid)
    }
}