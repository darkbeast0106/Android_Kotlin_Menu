package com.darkbeast0106.menu

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class NevMegadasaActivity : AppCompatActivity() {

    lateinit var editTextNev: EditText
    lateinit var buttonMentes: Button
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nev_megadasa)
        init()
        buttonMentes.setOnClickListener {
            val nev = editTextNev.text.toString().trim()
            if (nev.isEmpty()) {
                Toast.makeText(this, "Név megadása kötelező", Toast.LENGTH_SHORT).show()
            } else {
                editor.putString("nev", nev)
                editor.apply()
                val masikActivityre = Intent(this, MainActivity::class.java)
                startActivity(masikActivityre)
                finish()
            }
        }
    }

    fun init() {
        editTextNev = findViewById(R.id.edit_text_nev)
        buttonMentes = findViewById(R.id.button_mentes)
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }
}