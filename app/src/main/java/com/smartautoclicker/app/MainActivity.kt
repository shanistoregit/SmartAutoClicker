package com.smartautoclicker.app

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.accessibility.AccessibilityManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var txtStatus: TextView
    private lateinit var btnAccessibility: Button
    private lateinit var btnStart: Button
    private lateinit var btnStop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        txtStatus = findViewById(R.id.txtStatus)
        btnAccessibility = findViewById(R.id.btnAccessibility)
        btnStart = findViewById(R.id.btnStart)
        btnStop = findViewById(R.id.btnStop)

        btnAccessibility.setOnClickListener {
            startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
        }

        btnStart.setOnClickListener {
            txtStatus.text = "Automation Ready"
        }

        btnStop.setOnClickListener {
            txtStatus.text = "Automation Stopped"
        }
    }

    override fun onResume() {
        super.onResume()
        updateAccessibilityStatus()
    }

    private fun updateAccessibilityStatus() {
        val manager = getSystemService(ACCESSIBILITY_SERVICE) as AccessibilityManager

        val enabled = manager
            .getEnabledAccessibilityServiceList(
                AccessibilityServiceInfo.FEEDBACK_ALL_MASK
            )
            .any {
                it.resolveInfo.serviceInfo.packageName == packageName
            }

        if (enabled) {
            txtStatus.text = "Accessibility Service: ON"
            btnStart.isEnabled = true
            btnStop.isEnabled = true
        } else {
            txtStatus.text = "Accessibility Service: OFF"
            btnStart.isEnabled = false
            btnStop.isEnabled = false
        }
    }
}
