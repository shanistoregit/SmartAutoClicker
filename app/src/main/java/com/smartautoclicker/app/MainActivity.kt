package com.smartautoclicker.app

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(50, 80, 50, 80)
        }

        val title = TextView(this).apply {
            text = "Smart Auto Clicker"
            textSize = 24f
        }

        val subtitle = TextView(this).apply {
            text = "General Android UI Automation Framework"
            textSize = 16f
        }

        val accessibilityButton = Button(this).apply {
            text = "Open Accessibility Settings"
            setOnClickListener {
                startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
            }
        }

        layout.addView(title)
        layout.addView(subtitle)
        layout.addView(accessibilityButton)

        setContentView(layout)
    }
}
