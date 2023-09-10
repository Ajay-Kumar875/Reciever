package com.example.reciever

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tv:TextView
    lateinit var br:BatteryReceiver
    lateinit var receiver:AirplaneModeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv= findViewById(R.id.tv)
        br= BatteryReceiver(tv,this)

        registerReceiver(br, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
        receiver= AirplaneModeChangeReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver,it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(br)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}