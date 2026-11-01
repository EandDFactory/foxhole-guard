package com.foxhole.core.runtime

import java.util.concurrent.atomic.AtomicReference

/**
 * مدیریت چرخش پویا و هوشمند پروتکل‌ها و مسیرها (Dynamic Protocol & Route Hopping)
 * برای جلوگیری از شناسایی الگو توسط سیستم‌های فیلترینگ DPI.
 */
class DynamicProtocolHoppingPolicy(
    private val availableProtocols: List<String> = listOf("REALITY", "GRPC", "XHTTP", "TLS"),
    private val intervalMs: Long = 300_000L // هر ۵ دقیقه یک‌بار چرخش پویا
) {
    private val currentProtocolIndex = AtomicReference(0)
    private var lastHoppingTimestamp: Long = System.currentTimeMillis()

    fun shouldHop(): Boolean {
        val now = System.currentTimeMillis()
        if (now - lastHoppingTimestamp >= intervalMs) {
            lastHoppingTimestamp = now
            return true
        }
        return false
    }

    fun nextProtocol(): String {
        val nextIndex = (currentProtocolIndex.get() + 1) % availableProtocols.size
        currentProtocolIndex.set(nextIndex)
        return availableProtocols[nextIndex]
    }

    fun peekCurrentProtocol(): String {
        return availableProtocols[currentProtocolIndex.get()]
    }
}
