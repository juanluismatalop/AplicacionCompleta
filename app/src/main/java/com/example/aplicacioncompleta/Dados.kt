package com.example.aplicacioncompleta

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Dados : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados)

        val btnLanzarDado = findViewById<Button>(R.id.btn_lanzar_dado)

        btnLanzarDado.setOnClickListener {
            animateVasos()
            lanzarDados()
        }
    }

    private fun animateVasos() {
        val vaso1 = findViewById<ImageView>(R.id.vaso1)
        val vaso2 = findViewById<ImageView>(R.id.vaso2)

        val shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake)
        vaso1.startAnimation(shakeAnimation)
        vaso2.startAnimation(shakeAnimation)
    }

    private fun lanzarDados() {
        val dado1 = findViewById<ImageView>(R.id.dado1)
        val dado2 = findViewById<ImageView>(R.id.dado2)

        val diceImages = listOf(
            R.drawable.dado1,
            R.drawable.dado2,
            R.drawable.dado3,
            R.drawable.dado4,
            R.drawable.dado5,
            R.drawable.dado6
        )

        val randomDado1 = Random.nextInt(6)
        val randomDado2 = Random.nextInt(6)

        dado1.setImageResource(diceImages[randomDado1])
        dado2.setImageResource(diceImages[randomDado2])

        val resultado = "Dado 1: ${randomDado1 + 1}, Dado 2: ${randomDado2 + 1}"
        Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show()
    }
}

