package com.example.ageinminutes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var date: String = "" // TODO change to actual date type
        set (value) {
            field = value
            val dateView = findViewById<TextView>(R.id.selected_date)
            dateView.text = value
        }

    private var age: Int = 0
        set(value) {
            field = value
            val ageView = findViewById<TextView>(R.id.your_age_in_minutes)
            ageView.text = value.toString()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        date = "TODO"
        age = 0
    }
}