package com.example.ejercicio_1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private lateinit var botonLlamar: ImageButton
    private lateinit var botonAlarma: ImageButton
    private lateinit var botonInternet: ImageButton
    private lateinit var botonMusica: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         botonLlamar = findViewById<ImageButton>(R.id.botonLlamada)
        botonInternet = findViewById<ImageButton>(R.id.botonInternet)
        botonMusica = findViewById<ImageButton>(R.id.botonMusica)

        botonLlamar.setOnClickListener{ view ->
            var intentLlamar = Intent(this, Llamar::class.java)
            startActivity(intentLlamar)
        }
        botonInternet.setOnClickListener{ view ->
            var intentInternet = Intent(this, Internet::class.java)
            startActivity(intentInternet)
        }
        botonMusica .setOnClickListener{ view ->
            var intentMusica= Intent(this, Musica::class.java)
            startActivity(intentMusica)
        }

    }
}