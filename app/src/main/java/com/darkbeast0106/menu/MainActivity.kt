package com.darkbeast0106.menu

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var buttonNev: Button
    lateinit var buttonInfo: Button
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        buttonNev.setOnClickListener {
            val masikActivityre = Intent(this, NevMegadasaActivity::class.java)
            startActivity(masikActivityre)
            finish()
        }
        buttonInfo.setOnClickListener {
            val seged = sharedPreferences.getString("nev", "Nincs megadva név")
            Toast.makeText(this, seged, Toast.LENGTH_SHORT).show()
        }
    }

    fun init() {
        buttonNev = findViewById(R.id.button_nev)
        buttonInfo = findViewById(R.id.button_info)
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)
    }
}