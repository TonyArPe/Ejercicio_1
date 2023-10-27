package com.example.ejercicio_1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Llamar : AppCompatActivity() {
    private lateinit var botonRealizaLlamada: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_llamar)

        val btnMakeCall = findViewById<Button>(R.id.botonLlamar)

        btnMakeCall.setOnClickListener {
            val phoneNumber = "611496339" // Reemplaza con el número al que deseas llamar
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNumber")
            startActivity(intent)
        }
    }
}