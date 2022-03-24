package com.n3rdvana.ageinminutescalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*
import android.app.DatePickerDialog as DatePickerDialog

class MainActivity : AppCompatActivity() {
        // Assign your imports as private outside the oncreate function, but within the main activity
    private var tvSelectedDate: TextView? = null
    private var tvMinutes: TextView? = null
    private val cal: Calendar = Calendar.getInstance()
        // Imports should only be able to be imported within a single activity. If they cross activities then they may cause crashes. This is why you declare them here.


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val datePickerButton:Button = findViewById(R.id.selectDateButton)
        tvSelectedDate = findViewById(R.id.TVselectedDate)
        tvMinutes = findViewById(R.id.minutes_since_birth)
        tvSelectedDate?.text = "${month+1}/${dayOfMonth}/${year}"

        datePickerButton.setOnClickListener {
            clickDatePicker()
        }
    }


    val year = cal.get(Calendar.YEAR)
    val month = cal.get(Calendar.MONTH)
    val dayOfMonth = cal.get(Calendar.DAY_OF_MONTH)

   // When you click the button, it will load a Calendar Prompt
   private fun clickDatePicker(){
        DatePickerDialog(this,
            // when you launch the date picker Dialog and Set the date ** On Date Set - >
            { _, selectedYear, selectedMonth, selectedDayOfMonth -> // This lambda expression passes the selectedYear, SelectedMonth and selectedDayOfMonth from the above DatePicker launch
                val selectedDate= "${selectedMonth+1}/${selectedDayOfMonth}/${selectedYear}"
                val currentDate = "${month+1}/${dayOfMonth}/${year}"

                tvSelectedDate?.text = selectedDate

                Toast.makeText(this, "$selectedDate, $currentDate", Toast.LENGTH_SHORT).show()

                val sdf = SimpleDateFormat("mm/dd/yy", Locale.CANADA)

                val formattedDate = sdf.parse(selectedDate)
                val formattedCurDate = sdf.parse(currentDate)

                val selectedDateInMinutes = (formattedDate.time / 60000)
                val currentDateInMinutes = (formattedCurDate.time / 60000)


                val calculatedMinutes = currentDateInMinutes - selectedDateInMinutes

                tvMinutes?.text = calculatedMinutes.toString()


            },
            year,
            month,
            dayOfMonth).show()
    }

}