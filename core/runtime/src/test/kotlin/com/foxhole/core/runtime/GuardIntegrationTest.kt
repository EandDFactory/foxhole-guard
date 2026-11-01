package com.foxhole.core.runtime

import org.junit.Assert.assertTrue
import org.junit.Test

class GuardIntegrationTest {
    @Test
    fun testEngineStartup() {
        val policy = DynamicProtocolHoppingPolicy()
        val engine = ProtocolHoppingEngine(policy)
        assertTrue(engine != null)
    }
}
