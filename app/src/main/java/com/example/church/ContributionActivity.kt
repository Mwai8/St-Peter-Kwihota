package com.example.church

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView

class ContributionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contribution)

        val card1 = findViewById<CardView>(R.id.card_one)

        card1.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Offering", Toast.LENGTH_SHORT).show()
        }

        val card2 = findViewById<CardView>(R.id.card_two)

        card2.setOnClickListener {
            Toast.makeText(this, "Tithe", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }

        val card3 = findViewById<CardView>(R.id.card_three)

        card3.setOnClickListener {
            Toast.makeText(this, "Donation", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }

        val card4 = findViewById<CardView>(R.id.card_four)

        card4.setOnClickListener {
            Toast.makeText(this, "Groups", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }

        val card5 = findViewById<CardView>(R.id.card_five)

        card5.setOnClickListener {
            Toast.makeText(this, "Development", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }

        val card6 = findViewById<CardView>(R.id.card_six)

        card6.setOnClickListener {
            Toast.makeText(this, "Thanksgiving", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }
    }
}