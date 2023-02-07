package com.example.sprawdzaniehasla

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
private lateinit var sprawdzenie: Button
private lateinit var porownanietextu: TextView
private lateinit var duzalitera: TextView
private lateinit var cyfry: TextView
private lateinit var znakispecjal: TextView
private val regexDuza = Regex(".*[A-Z].*")
private val regexSpecjalne = Regex(pattern = ".*[!@#$%^&*()_+].*")
private val regexCyfry = Regex(pattern = ".*[0-9].*")
private val sukceskolor = Color.parseColor("#59FF11")
private val niepowodzeniekolor = Color.parseColor("#FF0000")

@SuppressLint("ResourceAsColor")
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    sprawdzenie = findViewById(R.id.zatwierdzeniabutton)
    porownanietextu = findViewById(R.id.sprawdzaczpkrywajacychhasel)
    duzalitera = findViewById(R.id.sprawdzaczduzejlitery)
    cyfry = findViewById(R.id.sprawdzaczlliczby)
    znakispecjal = findViewById(R.id.sprawdzaczznakuspecjalnego)

    sprawdzenie.setOnClickListener {
        val pass1 = findViewById<EditText>(R.id.buttonwprowadzenia).text.toString()
        val pass2 = findViewById<EditText>(R.id.buttonpotwierdzenia).text.toString()

        duzalitera.setTextColor(if (regexDuza.matches(pass1)) sukceskolor else niepowodzeniekolor)
        cyfry.setTextColor(if (regexCyfry.matches(pass1)) sukceskolor else niepowodzeniekolor)
        znakispecjal.setTextColor(if (regexSpecjalne.matches(pass1)) sukceskolor else niepowodzeniekolor)
        porownanietextu.setTextColor(if (pass1 == pass2) sukceskolor else niepowodzeniekolor)
    }
}}


