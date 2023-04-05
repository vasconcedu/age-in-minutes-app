package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
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
    private var yearToday: Int = 0
    private var monthToday: Int = 0
    private var dayToday: Int = 0

    // This method formats given Calendar date as "MM/dd/yyyy"
    private fun formatDate(year: Int, month: Int, day: Int): String {
        return "${
            String.format("%02d", month + 1)
        }/${
            String.format("%02d", day)
        }/${
            String.format("%04d", year)
        }"
    }

    // This method returns the number of minutes since given date
    private fun minutesSince(year: Int, month: Int, day: Int): Long {
        val sdf = SimpleDateFormat("MM/dd/yyyy")
        val selectedDateSdf = sdf.parse("$month/$day/$year")?.time
        val todaySdf = sdf.parse("$monthToday/$dayToday/$yearToday")?.time
        return (todaySdf!! - selectedDateSdf!!) / 60000 // Dividing by 60000 converts ms to minutes
    }

    private fun setupButton() {
        val button = findViewById<Button>(R.id.select_date_button)

        // When the button is clicked a DatePickerDialog is shown
        button.setOnClickListener {
            val dpd = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    // When a date is selected:
                    //  1. The date view is updated accordingly
                    //  2. The age in minutes is calculated and the age view is updated accordingly
                    date = formatDate(selectedYear, selectedMonth, selectedDay)
                    age = minutesSince(selectedYear, selectedMonth, selectedDay)
                },
                yearToday,
                monthToday,
                dayToday
            )
            dpd.datePicker.maxDate = System.currentTimeMillis()
            dpd.show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get current date
        calendar = Calendar.getInstance()
        yearToday = calendar.get(Calendar.YEAR)
        monthToday = calendar.get(Calendar.MONTH)
        dayToday = calendar.get(Calendar.DAY_OF_MONTH)

        // Initial date is today
        date = formatDate(yearToday, monthToday, dayToday)

        // Initial age is 0
        age = 0L

        // Setup button click event listener
        setupButton()
    }
}