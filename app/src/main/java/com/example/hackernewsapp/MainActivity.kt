package com.example.hackernewsapp

import android.app.AlarmManager
import android.app.PendingIntent
import android.arch.persistence.room.Room
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.support.annotation.RequiresApi
import android.support.v4.app.FragmentActivity
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager
import android.view.View
import java.util.*

class MainActivity : FragmentActivity() {

//    private val db by lazy {
//        Room.databaseBuilder(this, MyAppDatabase::class.java, "hackerdb.db")
//    }

    private val alarmManager by lazy {
        getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alarmIntent = PendingIntent.getActivity(
            this,
            1234,
            Intent(this, MainActivity::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        //alarm gets fired at 10 p.m
        val calendar: Calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, 20)
        }

        alarmManager.setInexactRepeating(
            AlarmManager.RTC,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            alarmIntent
        )

        val fragmentManager = supportFragmentManager
        if (findViewById<View>(R.id.mainfrag) != null) {
            if (savedInstanceState != null) {
                return
            }
            fragmentManager.beginTransaction().add(R.id.mainfrag, HomeFragment()).commit()
        }
    }
    companion object {
       // lateinit var myAppDatabase: MyAppDatabase
       // lateinit var fragmentManager:FragmentManager
    }
}
