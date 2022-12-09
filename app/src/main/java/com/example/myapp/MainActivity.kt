package com.example.myapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
//import androidx.room.Room
//import com.example.myapp.data.TaskDataBase
import java.util.*





class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val deadlineDate = findViewById<TextView>(R.id.DeadlineDateTextview)
        deadlineDate.setOnClickListener {
            chooseDate(deadlineDate)
        }

        val deadlineTime = findViewById<TextView>(R.id.DeadlineTimeTextview)
        deadlineTime.setOnClickListener {
            chooseTime(deadlineTime)
        }

        val addButton = findViewById<Button>(R.id.AddButton)
        addButton.setOnClickListener {
            addToDo(deadlineDate, deadlineTime)
        }

        val layout = findViewById<ConstraintLayout>(R.id.ConstraintLayout)
        layout.background.alpha = 150
    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show()
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show()
        }
    }





    private fun chooseDate(deadlineDate :TextView) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        @Suppress("NAME_SHADOWING")
        DatePickerDialog(this, { _, year, month, day ->
            run {
                val date = setDateFormat(year, month, day)
                deadlineDate.text = date
            }
        }, year, month, day).show()
    }

    private fun chooseTime(deadlineTime: TextView){
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        @Suppress("NAME_SHADOWING")
        TimePickerDialog(this, {
                _, hour, minute->  deadlineTime.text = setTimeFormat(hour, minute)
        }, hour, minute, true).show()

    }

    private fun setDateFormat(year: Int, month: Int, day: Int): String {
        return "$year / $month / $day"
    }

    private fun setTimeFormat(hour: Int, minute: Int): String {
        return "$hour : $minute"
    }

    private fun addToDo(deadlineDate :TextView, deadlineTime: TextView){
        val inputToDo = findViewById<TextView>(R.id.InputToDo)
        val toDo = inputToDo.text.toString()
        val date = deadlineDate.text.toString()
        val time = deadlineTime.text.toString()
        println("$date , $time")


        if(toDo == ""){
            Toast.makeText(this, "Please input Task Name", Toast.LENGTH_SHORT).show()
        }
        else if(date == "Deadline" ){
            Toast.makeText(this, "Please Choose Date for the task", Toast.LENGTH_SHORT).show()
        }
        else if(time == "Choose Time" ){
            Toast.makeText(this, "Please Choose Time for the task", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "$toDo ADD!", Toast.LENGTH_LONG).show()
        }



    }
}