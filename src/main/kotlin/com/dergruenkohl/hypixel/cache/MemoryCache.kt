package com.dergruenkohl.hypixel.cache

import io.github.reactivecircus.cache4k.Cache
import kotlin.time.Duration

class MemoryCache(timeout: Duration) {
    private val cache = Cache.Builder<String, Any>()
        .expireAfterWrite(timeout)
        .build()

    fun get(key: String): Any? {
        return cache.get(key)
    }

    fun set(key: String, value: Any) {
        cache.put(key, value)
    }
}