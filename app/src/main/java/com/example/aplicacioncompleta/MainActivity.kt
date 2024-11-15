package com.example.aplicacioncompleta

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLlamar = findViewById<Button>(R.id.btnLlamar)
        val btnChistes = findViewById<Button>(R.id.btnChistes)
        val btnAlarma = findViewById<Button>(R.id.btnAlarma)
        val btnDados = findViewById<Button>(R.id.btnDados)

        btnLlamar.setOnClickListener {
            val intent = Intent(this, Llamada::class.java)
            startActivity(intent)
        }

        btnChistes.setOnClickListener {
            val intent = Intent(this, Chistes::class.java)
            startActivity(intent)
        }

        btnAlarma.setOnClickListener {
            val intent = Intent(this, Alarma::class.java)
            startActivity(intent)
        }

        btnDados.setOnClickListener {
            val intent = Intent(this, Dados::class.java)
            startActivity(intent)
        }
    }
}
