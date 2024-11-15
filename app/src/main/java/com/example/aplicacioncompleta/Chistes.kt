package com.example.aplicacioncompleta

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import java.util.Locale

class Chistes : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech
    private var lastClickTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chistes)

        tts = TextToSpeech(this, this)

        val chistes = listOf(
            "¡Hasta luego, Lucas!",
            "¡Te das cuen!",
            "Fistro pecador de la pradera.",
            "¡Cómor! ¿Te quieres ir pa siempre?",
            "¡Por la gloria de mi madre!",
            "Que fuerrrrrrte me parece.",
            "No puedo, no puedo... ¡me va a dar algo!",
            "Al ataquerl, al ataquerl.",
            "Eres más lento que un desfile de cojos.",
            "Fistro duodenarl, pecador."
        )

        val btnChiste = findViewById<Button>(R.id.btn_chiste)
        val txtChiste = findViewById<TextView>(R.id.chiste)

        btnChiste.setOnClickListener {
            val currentTime = System.currentTimeMillis()

            if (currentTime - lastClickTime < 500) {
                val chisteAleatorio = chistes[Random.nextInt(chistes.size)]
                txtChiste.text = chisteAleatorio
                speak(chisteAleatorio)
            } else {
                speak(btnChiste.text.toString())
            }
            lastClickTime = currentTime
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts.language = Locale("es", "ES")
        }
    }

    private fun speak(text: String) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::tts.isInitialized) {
            tts.stop()
            tts.shutdown()
        }
    }
}

