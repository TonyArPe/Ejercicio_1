package com.example.ejercicio_1

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Alarma: AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var alarmManager: AlarmManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarma)

        sharedPreferences = getSharedPreferences("AlarmPreferences", Context.MODE_PRIVATE)
        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val button5min: Button = findViewById(R.id.button_5min)
        val button10min: Button = findViewById(R.id.button_10min)
        val button15min: Button = findViewById(R.id.button_15min)
        val button20min: Button = findViewById(R.id.button_20min)

        fun toggleAlarm(timeInMillis: Long, button: Button) {
            val alarmIntent = Intent(this, Alarma::class.java)
            val pendingIntent = PendingIntent.getBroadcast(
                this,
                timeInMillis.toInt(),
                alarmIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )

            val isAlarmOn = sharedPreferences.getBoolean(timeInMillis.toString(), false)

            if (isAlarmOn) {
                alarmManager.cancel(pendingIntent)
                sharedPreferences.edit().putBoolean(timeInMillis.toString(), false).apply()
                button.text = "Activar"
            } else {
                val currentTime = System.currentTimeMillis()
                alarmManager.setExact(
                    AlarmManager.RTC_WAKEUP,
                    currentTime + timeInMillis,
                    pendingIntent
                )
                sharedPreferences.edit().putBoolean(timeInMillis.toString(), true).apply()
                button.text = "Desactivar"
            }
        }

        button5min.setOnClickListener {
            toggleAlarm(5 * 60 * 1000, button5min)
        }

        button10min.setOnClickListener {
            toggleAlarm(10 * 60 * 1000, button10min)
        }

        button5min.setOnClickListener {
            toggleAlarm(15 * 60 * 1000, button15min)
        }

        button10min.setOnClickListener {
            toggleAlarm(20 * 60 * 1000, button20min)
        }
    }
}