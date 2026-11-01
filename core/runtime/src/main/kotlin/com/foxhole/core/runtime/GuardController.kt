package com.foxhole.core.runtime

import android.util.Log

class GuardController(private val engine: ProtocolHoppingEngine) {
    companion object {
        private const val TAG = "GuardController"
    }

    fun startProtection() {
        Log.i(TAG, "Starting Foxhole Guard protection layer...")
        engine.initialize()
    }
}
