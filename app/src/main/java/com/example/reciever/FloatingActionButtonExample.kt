package com.example.reciever

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class FloatingActionButtonExample : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floating_action_button_example)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { view->
            Snackbar.make(view,"Replace with your own Action",Snackbar.LENGTH_LONG).setAction("Action",null).show()
        }
    }
}