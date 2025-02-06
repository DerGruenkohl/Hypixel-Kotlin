import com.dergruenkohl.hypixel.client.HypixelClient
import com.dergruenkohl.hypixel.client.getGuildById
import com.dergruenkohl.hypixel.client.getGuildByName
import com.dergruenkohl.hypixel.client.getGuildByPlayer
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class GuildTests {
    private val client = HypixelClient(Config.apikey)

    @Test
    fun testGetGuildByPlayer() {
        runBlocking {
            val response = client.getGuildByPlayer("e1e8e316f9414911b8f011dd887f8a92")
            val r2 = client.getGuildByPlayer("65542bfb24a84fe9b62cc755afd72937")
            assert(response.success)
            assert(r2.success)
        }
    }
    @Test
    fun testGetGuildByName() {
        runBlocking {
            val response = client.getGuildByName("Bakacord")
            assert(response.success)
        }
    }
    @Test
    fun testGetGuildById() {
        runBlocking {
            val respone = client.getGuildById("606387958ea8c962c0d579ba")
            assert(respone.success)
        }
    }
    @Test
    fun getIllegalGuild(){
        runBlocking {
            val response = client.getGuildByPlayer("e1e8e")
            assert(!response.success)
        }
    }
}