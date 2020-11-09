package com.pms.a13_ud2ejercomunicaactivity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

class Verificando : AppCompatActivity() {
    private var nombre: String? = null
    private var mensaje // Textview para el mensaje hola....
            : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verificando)

        //Recoge información que ha mandado la actividad 'comunica' con el intent
        val info = intent.extras
        nombre = info.getString("NOMBRE")
        mensaje = findViewById<View>(R.id.textView1) as TextView
        mensaje!!.text = "Hola $nombre"
    }

    /**
     * Método onlClick del botón Apceptar
     * @param v : View botón aceptar
     */
    fun aceptar(v: View?) {
        // mandar información de vuelta a la actividad que llamó a esta
        val intent = Intent()
        intent.putExtra("RESULTADO", "Aceptado")
        setResult(RESULT_OK, intent)
        finish() // finaliza y cierra la Activity
    }

    /**
     * Método onClick del botón Rechazar
     * @param v : View botón rechazar
     */
    fun rechazar(v: View?) {
        // mandar información de vuelta a la actividad que llamo a esta
        val intent = Intent()
        intent.putExtra("RESULTADO", "Rechazado")
        setResult(RESULT_OK, intent)
        finish() // finaliza y cierra la Activity
    }
}