package com.example.church

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val card1 = findViewById<CardView>(R.id.card1)

        card1.setOnClickListener {
            val intent = Intent(this, UpcomingEventsActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Upcoming events",Toast.LENGTH_SHORT).show()
        }

        val card2 = findViewById<CardView>(R.id.card2)

        card2.setOnClickListener {
            val intent = Intent(this, HymnCategoryActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Hymns",Toast.LENGTH_SHORT).show()
        }

        val card3 = findViewById<CardView>(R.id.card3)

        card3.setOnClickListener {
            Toast.makeText(this, "Prayers",Toast.LENGTH_SHORT).show()
        }

        val card4 = findViewById<CardView>(R.id.card4)

        card4.setOnClickListener {
            Toast.makeText(this, "Matangazo",Toast.LENGTH_SHORT).show()
        }

        val button = findViewById<Button>(R.id.buttonContribute)

        button.setOnClickListener {

            Toast.makeText(this, "Contribution",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ContributionActivity::class.java)
            startActivity(intent)
        }


    }
}