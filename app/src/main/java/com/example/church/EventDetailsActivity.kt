package com.example.church

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class EventDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details)

        val bt = findViewById<LinearLayout>(R.id.bt_event)
        bt.setOnClickListener {
            val intent = Intent(this, UpcomingEventsActivity::class.java)
            startActivity(intent)
        }
    }
}