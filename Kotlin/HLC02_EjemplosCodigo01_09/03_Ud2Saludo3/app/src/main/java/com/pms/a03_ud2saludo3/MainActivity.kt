package com.pms.a03_ud2saludo3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //obtenemos una referencia al botón del layout
        val bSaludo = findViewById<View>(R.id.botonSaludo) as Button

        //Funcionalidad al pulsar el botón
        //implementada mediante la interfaz OnClickListener (escuchador de eventos)
        bSaludo.setOnClickListener { //obtenemos una referencia al EditText del layout
            val cajaSaludo = findViewById<View>(R.id.cajaSaludo) as EditText
            //Crea un objeto Toast con el mensaje apropiado
            val tostada = Toast.makeText(applicationContext,
                    "Hola: " + cajaSaludo.text.toString(), Toast.LENGTH_LONG)
            //Visualiza o muestra el objeto tostada
            tostada.show()
        }
    }
}