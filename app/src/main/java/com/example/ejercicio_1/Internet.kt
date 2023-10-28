package com.example.ejercicio_1

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Internet : AppCompatActivity() {
    private lateinit var botonBusquedaInternet: Button
    private lateinit var botonHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internet)

        val botonHome = findViewById<Button>(R.id.botonHome)



        botonHome.setOnClickListener {
            super.onBackPressedDispatcher.onBackPressed()
        }
    }

}