package com.foxhole.guard

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.foxhole.core.runtime.DynamicProtocolHoppingPolicy

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tv = TextView(this)
        tv.text = "FoxholeGuard Active\nPolicy: " + DynamicProtocolHoppingPolicy().getCurrentProtocol()
        setContentView(tv)
    }
}