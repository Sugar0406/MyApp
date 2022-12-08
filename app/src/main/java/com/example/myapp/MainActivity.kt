package com.example.myapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import java.util.*





class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("lifecycle", "onCreate")

        val addButton = findViewById<Button>(R.id.AddButton)
        addButton.setOnClickListener{
            addtodo()
        }

        val deadline = findViewById<TextView>(R.id.DeadlineTextview)
        deadline.setOnClickListener{
            choosedate(deadline)
        }

    }

    fun choosedate(textView :TextView) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, { _, year, month, day ->
            run {
                val date = setDateFormat(year, month, day)
                textView.text = date
            }
        }, year, month, day).show()
    }

    private fun setDateFormat(year: Int, month: Int, day: Int): String {
        return "$year / $month / $day"
    }

    private fun addtodo(){
        val inputToDo = findViewById<TextView>(R.id.InputToDo)
        val toDo = inputToDo.text.toString()
        if(toDo == ""){
            Toast.makeText(this, "Please input Task Name", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "$toDo Add!", Toast.LENGTH_SHORT).show()
        }



    }
}