package com.dergruenkohl.hypixel.client

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

class HypixelClient(private val apiKey: String) {
    val module = SerializersModule {
        contextual(ProfileMemberDeserializer)
    }

    val json = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
        serializersModule = module
    }

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
    internal suspend inline fun < reified T> makeRequest(url: String, vararg parameters: Pair<String, String>): T{
        return client.get{
            url(url)
            parameters.forEach { (key, value) ->
                parameter(key, value)
            }
        }.body<T>()
    }
    internal suspend inline fun <reified T> makeAuthenticatedRequest(url: String, vararg parameters: Pair<String, String>): T{
        return client
            .request{
                url(url)
                parameters.forEach { (key, value) ->
                    parameter(key, value)
                }
                header("API-Key", apiKey)
            }
            .body<T>()
    }

    fun close() {
        client.close()
    }

}