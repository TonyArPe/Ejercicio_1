package com.example.ejercicio_1

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

class Internet : AppCompatActivity() {
    private lateinit var botonBusquedaInternet: Button
    private lateinit var botonHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internet)

        val botonHome = findViewById<Button>(R.id.botonHome)

        botonBusquedaInternet.setOnClickListener {
            abrirNavegador(this, "www.google.com")
        }


        botonHome.setOnClickListener {
            super.onBackPressedDispatcher.onBackPressed()
        }
    }

}

fun abrirNavegador(context: Context, url: String) {
    val webpage: Uri = Uri.parse(url)
    val intent = Intent(Intent.ACTION_VIEW, webpage)

    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    } else {
        mostrarError(context)
    }
}

fun mostrarError(context: Context) {
    Toast.makeText(context, "No se puede abrir la URL", Toast.LENGTH_SHORT).show()
}