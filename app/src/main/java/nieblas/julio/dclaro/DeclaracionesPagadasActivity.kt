package nieblas.julio.dclaro

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import nieblas.julio.dclaro.R.id.btn_declaracionp

class DeclaracionesPagadasActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_declaraciones_pagadas)


        val btn_declaracionp: Button = findViewById(btn_declaracionp)
        btn_declaracionp.setOnClickListener{
            val intent: Intent = Intent(this, DeclaracionesCerosActivity::class.java)
            startActivity(intent)

        }
    }
}