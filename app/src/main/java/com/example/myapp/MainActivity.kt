package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

//import kotlinx.android.synthetic.main.activity_main

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.AddButton)
        addButton.setOnClickListener{
            val inputToDo = findViewById<TextView>(R.id.InputToDo)
            val toDo = inputToDo.text.toString()
            Log.d("MainActivity","$toDo Add !!" )
        }

    }

//    override fun onPause() {
//        super.onPause()
//        println("onPause")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//    }
}