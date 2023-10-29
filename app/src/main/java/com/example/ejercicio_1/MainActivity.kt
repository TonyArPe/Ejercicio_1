package com.example.ejercicio_1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private lateinit var botonLlamar: ImageButton
    private lateinit var botonAlarmas: ImageButton
    private lateinit var botonInternet: ImageButton
    private lateinit var botonMusica: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         botonLlamar = findViewById<ImageButton>(R.id.botonLlamada)
        botonInternet = findViewById<ImageButton>(R.id.botonInternet)
        botonMusica = findViewById<ImageButton>(R.id.botonMusica)
        botonAlarmas = findViewById<ImageButton>(R.id.botonAlarma)

        botonLlamar.setOnClickListener{ view ->
            var intentLlamar = Intent(this, Llamar::class.java)
            startActivity(intentLlamar)
        }
        val imageButton: ImageButton = findViewById(R.id.botonInternet)
        imageButton.setOnClickListener {
            openChrome()
        }
        botonMusica.setOnClickListener{ view ->
            var intentMusica= Intent(this, Musica::class.java)
            startActivity(intentMusica)
        }
        botonAlarmas.setOnClickListener{ view ->
            var intentAlarma= Intent(this, Alarma::class.java)
            startActivity(intentAlarma)
        }

    }

    private fun openChrome() {
        val url = "https://www.google.com"
        val chromePackage = "com.android.chrome" // Paquete de Google Chrome

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.setPackage(chromePackage) // Establece el paquete de Chrome

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            // Si Chrome no está instalado, abre en el navegador predeterminado
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
    }
}