package com.tech.assignment02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.addmovie)
        button1.setOnClickListener{
            val intent = Intent(this, AddMovies::class.java)
            startActivity(intent)
        }

        val button2 = findViewById<Button>(R.id.searchmovie)
        button2.setOnClickListener{
            val intent = Intent(this, SearchMovies::class.java)
            startActivity(intent)
        }

        val button3 = findViewById<Button>(R.id.searchactor)
        button3.setOnClickListener{
            val intent = Intent(this, SearchActors::class.java)
            startActivity(intent)
        }
    }
}