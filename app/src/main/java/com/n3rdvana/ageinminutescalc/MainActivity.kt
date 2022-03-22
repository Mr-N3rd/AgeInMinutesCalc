package com.n3rdvana.ageinminutescalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*
import android.app.DatePickerDialog as DatePickerDialog

class MainActivity : AppCompatActivity() {
        // Assign your imports as private outside the oncreate function, but within the main activity
    private var tvSelectedDate: TextView? = null
    private val cal: Calendar = Calendar.getInstance()
        // Imports should only be able to be imported within a single activity. If they cross activities then they may cause crashes. This is why you declare them here.


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val datePickerButton:Button = findViewById(R.id.selectDateButton)
        tvSelectedDate = findViewById(R.id.TVselectedDate)



        datePickerButton.setOnClickListener {
            clickDatePicker()
        }
    }




    val year = cal.get(Calendar.YEAR)
    val month = cal.get(Calendar.MONTH)
    val dayOfWeek = cal.get(Calendar.DAY_OF_MONTH)

   // When you click the button, it will load a Calendar Prompt
    fun clickDatePicker(){
        DatePickerDialog(this,

            // when you launch the date picker Dialog and Set the date ** On Date Set - >
            { _, selectedYear, selectedMonth, selectedDayOfMonth -> // This lambda expression passes the selectedYear, SelectedMonth and selectedDayOfMonth from the above DatePicker launch
                val selectedDate= "${selectedDayOfMonth}/${selectedMonth+1}/${selectedYear}"
                tvSelectedDate?.text = selectedDate
                val sdf = SimpleDateFormat("mm/dd/yy", Locale.CANADA)
                val formattedDate = sdf.parse(selectedDate)
//                val getCurrentDate = cal.get(Calendar.getInstance())
                val currentYear = cal.get(Calendar.YEAR)
                val currentMonth = cal.get(Calendar.MONTH)
                val currentDayOfMonth = cal.get(Calendar.DAY_OF_MONTH)
                val currentDate = "${currentYear}/${currentMonth}/${currentDayOfMonth}"
                val formattedCurDate = sdf.parse("${Calendar.getInstance()}")
//                val selectedDateInMinutes = (formattedDate.time / 60000)
                val currentDateInMinutes = (formattedCurDate.time / 60000)
//                Log.i("selectedDateInMinutes", "$selectedDateInMinutes")
                Log.i("FormattedCurDate", "$formattedCurDate")
            },
            year,
            month,
            dayOfWeek).show()
    }

}