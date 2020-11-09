package com.pms.a07_guardarestadono

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var contador = 0
    var texto: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //referenciamos la vista TextView del layout
        texto = findViewById<View>(R.id.text) as TextView
    }

    /**
     * Comportamiento del botón suma
     * @param view: botón suma
     */
    fun onClickSuma(view: View?) {
        //incrementa 1 el contador
        contador++
        //asigna el valor del contador al TextView
        texto!!.text = contador.toString()
    }
}