package com.pms.a04_ud2saludo4

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

//Implementa la interfaz OnClickListener como parte de la Activity y
// recoge los eventos en el método onClick().
class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Obtenemos una referencia al botón del layout
        val boton = findViewById<View>(R.id.botonSaludo) as Button
        //La propia clase se encarga de recoger los eventos
        boton.setOnClickListener(this)
    }

    // Método a implementar para el comportamiento onClick del botón para saludar
    override fun onClick(v: View) {
        if (v.id == R.id.botonSaludo) {
            //obtenemos una referencia al EditText del layout
            val cajaSaludo = findViewById<View>(R.id.cajaSaludo) as EditText
            //Crea un objeto Toast con el mensaje apropiado
            val tostada = Toast.makeText(applicationContext, "Hola: " + cajaSaludo.text.toString(), Toast.LENGTH_LONG)
            //Visualiza o muestra el objeto tostada
            tostada.show()
        }
    }
}