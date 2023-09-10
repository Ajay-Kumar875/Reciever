package com.example.reciever

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.Toast

class BroadCastRecieverDemo1 : AppCompatActivity() {
    lateinit var wifiSwitch:Switch
    lateinit var wifiManager:WifiManager

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broad_cast_reciever_demo1)

        wifiSwitch=findViewById(R.id.wifiSwitch)
        wifiManager=applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiSwitch.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                wifiManager.isWifiEnabled=true
                wifiSwitch.text="Wifi is ON"
            }else{
                wifiManager.isWifiEnabled=false
                wifiSwitch.text="Wifi is OFF"
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val intentFilter=IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(wifiStateReceiver,intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(wifiStateReceiver)
    }
    private val wifiStateReceiver:BroadcastReceiver=object:
    BroadcastReceiver(){
        override fun onReceive(context: Context,intent: Intent) {
            when(intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN))
            {
                WifiManager.WIFI_STATE_ENABLED->{
                    wifiSwitch.isChecked=true
                    wifiSwitch.text="Wifi is ON"
                    Toast.makeText(this@BroadCastRecieverDemo1,"Wifi is On",Toast.LENGTH_LONG).show()
                }
                WifiManager.WIFI_STATE_DISABLED->{
                    wifiSwitch.isChecked=false
                    wifiSwitch.text="Wifi is OFF"
                    Toast.makeText(this@BroadCastRecieverDemo1,"Wifi is Off",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}