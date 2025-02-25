package com.dergruenkohl.hypixel.client

import com.dergruenkohl.hypixel.cache.MemoryCache
import com.dergruenkohl.hypixel.data.profile.ProfileMemberDeserializer
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes
/*
 * Class to interact with the Hypixel API, responses are cached for 30 mins by default
 */
class HypixelClient(private val apiKey: String, private val cacheTimeout: Duration = 30.minutes) {
    private val module = SerializersModule {
        contextual(ProfileMemberDeserializer)
    }

    private val json = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
        serializersModule = module
    }
    private val cache = MemoryCache(cacheTimeout)


    private val client by lazy {
        HttpClient(CIO) {
            defaultRequest {
                url("https://api.hypixel.net/v2/")
            }
            install(Logging)
            install(HttpRequestRetry) {
                retryOnServerErrors(3)
                retryOnException(3, true)
            }
            install(ContentNegotiation) {
                json(json)
            }

        }
    }
    internal suspend inline fun <reified T : Any> makeRequest(url: String, vararg parameters: Pair<String, String>): T {
        val cacheKey = url + parameters.joinToString()
        val cachedResponse = cache.get(cacheKey)
        if (cachedResponse != null) {
            return cachedResponse as T
        }

        val response: T = client.get {
            url(url)
            parameters.forEach { (key, value) ->
                parameter(key, value)
            }
        }.body()

        cache.set(cacheKey, response)
        return response
    }

    internal suspend inline fun <reified T : Any> makeAuthenticatedRequest(url: String, vararg parameters: Pair<String, String>): T {
        val cacheKey = url + parameters.joinToString() + apiKey
        val cachedResponse = cache.get(cacheKey)
        if (cachedResponse != null) {
            println("got cached response")
            return cachedResponse as T
        }

        val response: T = client.request {
            url(url)
            parameters.forEach { (key, value) ->
                parameter(key, value)
            }
            header("API-Key", apiKey)
        }.body()

        cache.set(cacheKey, response)
        return response
    }

    fun close() {
        client.close()
    }

}