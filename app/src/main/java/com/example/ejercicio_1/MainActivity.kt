package com.example.ejercicio_1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var botonLlamar: Button
    private lateinit var botonAlarma: Button
    private lateinit var botonInternet: Button
    private lateinit var botonMusica: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         botonLlamar = findViewById<Button>(R.id.botonLlamada)

        botonLlamar.setOnClickListener{ view ->
            var intentLlamar = Intent(this, Llamar::class.java)
            startActivity(intentLlamar)
        }


    }
}