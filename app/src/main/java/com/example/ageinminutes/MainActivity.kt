package com.example.ageinminutes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDate("TODO")
        setAge(0)
    }

    private fun setDate(date: String) { // TODO change to actual date type
        val dateView = findViewById<TextView>(R.id.selected_date)
        dateView.text = date
    }

    private fun setAge(age: Int) {
        val ageView = findViewById<TextView>(R.id.your_age_in_minutes)
        ageView.text = age.toString()
    }
}