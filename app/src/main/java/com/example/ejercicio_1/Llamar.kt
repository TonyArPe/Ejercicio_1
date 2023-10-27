package com.example.ejercicio_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Llamar : AppCompatActivity() {
    private lateinit var botonRealizaLlamada: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_llamar)
    }
}