package com.pms.a05_ud2saludoedad

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SaludoEdad : AppCompatActivity() {
    var e = 0
    var toast: Toast? = null
    var str = ""
    var bSaludo: Button? = null
    var cajaNombre: EditText? = null
    var cajaEdad: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saludo_edad)


        //obtenemos la referencia a los EditText del layout
        cajaNombre = findViewById<View>(R.id.cajaNombre) as EditText
        cajaEdad = findViewById<View>(R.id.cajaEdad) as EditText
    }

    /**
     * Método para la funcionalidad del botón botonSaludo al hacer onClick
     */
    fun metodoSaludo(v: View?) {
        //En un try...catch evaluamos la Edad como entero
        try {
            // convertimos a Integer el valor del EditText cajaEdad
            e = cajaEdad!!.text.toString().toInt()
            // comprobamos el rango de la edad e
            str = if (e >= 18) " Eres mayor de edad" else if (e > 0) " Eres menor de edad" else " No has nacido"

            // mostramos un mensaje mediante una tostada
            toast = Toast.makeText(applicationContext, "Hola: " + str
                    + " con Edad: " + cajaEdad!!.text.toString(), Toast.LENGTH_LONG)
            toast?.show()
        } catch (nfe: NumberFormatException) {
            toast = Toast.makeText(applicationContext,
                    "Debe introducir un valor entero (en el rango correcto)", Toast.LENGTH_SHORT)
            toast?.show()
        }
    }
}