package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private var date: String = ""
        set(value) {
            field = value
            val dateView = findViewById<TextView>(R.id.selected_date)
            dateView.text = value
        }

    private var age: Long = 0L
        set(value) {
            field = value
            val ageView = findViewById<TextView>(R.id.your_age_in_minutes)
            ageView.text = value.toString()
        }

    private lateinit var calendar: Calendar

    private fun formatDate(year: Int, month: Int, day: Int): String {
        return "$month/$day/$year"
    }

    private fun minutesSince(year: Int, month: Int, day: Int): Long {
        return 0L // TODO implement
    }

    private fun setupButton() {
        val button = findViewById<Button>(R.id.select_date_button)
        button.setOnClickListener {
            DatePickerDialog(
                this,
                { _, year, month, day ->
                    date = formatDate(year, month + 1, day)
                    age = minutesSince(year, month, day)
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Need this to get current date
        calendar = Calendar.getInstance()

        // Initial date is today
        date = formatDate(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH) + 1,
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        // Initial age is 0
        age = 0L

        // Setup button click event listener
        setupButton()
    }
}