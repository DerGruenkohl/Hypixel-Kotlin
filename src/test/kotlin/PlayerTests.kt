import com.dergruenkohl.hypixel.client.*
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
            val response = client.getSelectedProfileReply("f2a924b8c1624f37b2b38ce35b6e271a")
            val r2 = client.getSelectedProfileReply("5e22209b-e586-4a08-8761-aa6bde56a090")

            val r3 = client.getSelectedProfileMember("f2a924b8c1624f37b2b38ce35b6e271a")
            val r4 = client.getSelectedProfileMember("5e22209b-e586-4a08-8761-aa6bde56a090")
            assert(response != null && response.success)
            assert(r2 != null && r2.success)
            assert(r3 != null)
            assert(r4 != null)
        }
    }
}