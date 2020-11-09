package com.pms.a09_intentexplicito00

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    } // fin onCreate()

    /**
     * Comportamiento del botón al hacer click
     */
    fun SegundaActivity(v: View?) {
        // Declara un Intent explícito
        val i2 = Intent(applicationContext, Actividad2::class.java)
        //Lanza la Activity2 mediante el intent i2
        startActivity(i2)
    }
}