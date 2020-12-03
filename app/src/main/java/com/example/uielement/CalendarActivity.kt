package com.example.uielement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView

class CalendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        val firstName = intent.getStringExtra("FirstName")
        val lastName = intent.getStringExtra("LastName")
        val age = intent.getStringExtra("Age")
        val emailAddress = intent.getStringExtra("Email")
        val phoneNumber = intent.getStringExtra("Phone")

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        calendarView?.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val birthdate = "" + dayOfMonth + "/" + (month + 1) + "/" + year
            val intent = Intent(this, FinalActivity::class.java)
            intent.putExtra("FirstName","$firstName")
            intent.putExtra("LastName","$lastName")
            intent.putExtra("Age","$age")
            intent.putExtra("Birthdate","$birthdate")
            intent.putExtra("Email","$emailAddress")
            intent.putExtra("Phone","$phoneNumber")

            startActivity(intent)
        }

    }
}