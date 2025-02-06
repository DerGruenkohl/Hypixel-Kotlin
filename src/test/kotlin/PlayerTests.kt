import com.dergruenkohl.hypixel.client.HypixelClient
import com.dergruenkohl.hypixel.client.getPlayer
import com.dergruenkohl.hypixel.client.getSelectedProfile
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class PlayerTests {
    private val client = HypixelClient(Config.apikey)

    @Test
    fun testPlayer() {
        runBlocking {
            val response1 = client.getPlayer("e1e8e316f9414911b8f011dd887f8a92")
            val response2 = client.getPlayer("5dc0e9a05b7b41828f96b2edd80f3db4")
            assert(response1.success && response2.success)
        }

    }
    @Test
    fun testProfile(){
        runBlocking {
            val response = client.getSelectedProfile("f2a924b8c1624f37b2b38ce35b6e271a")
            println(response)
            assert(response != null && response.success)
        }
    }
}