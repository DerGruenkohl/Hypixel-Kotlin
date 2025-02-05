import java.io.File
import java.util.*

object Config {
    private val properties: Properties = Properties()

    init {
        val configFile = File("config.properties")
        if (configFile.exists()) {
            properties.load(configFile.inputStream())
        } else {
            throw IllegalStateException("Config file not found: ${configFile.absolutePath}")
        }
    }

    val apikey: String get() = properties.getProperty("apikey")
}
