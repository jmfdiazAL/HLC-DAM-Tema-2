package com.pms.a11_ud2intentexplicito02

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)
        //referencia a la View del XML
        val txtMensaje = findViewById<View>(R.id.TxtMensaje) as TextView

        //obiene la informacion pasada por la activity llamadora (la MainActivity o Activity1)
        val bundle = intent.extras

        //visualiza la información pasada
        txtMensaje.text = "Hola " + bundle.getString("NOMBRE")
        /********* devolviendo resultados  */
        val intent = Intent()
        intent.putExtra("RESULTADO", "valor devuelto desde segunda Activity")
        setResult(RESULT_OK, intent)
    }
}