package com.pms.a10_ud2intentexplicito01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pms.a10_ud2intentexplicito01.R
import android.widget.TextView

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        //referencia a la View TextView del layout XML
        val txtMensaje = findViewById<View>(R.id.TxtMensaje) as TextView

        //obtiene la información pasada por la activity llamadora (MainActivity) en un objeto Bundle
        val bundle = intent.extras

        //visualiza la información pasada extrayendo el valor asociado a la clave
        txtMensaje.text = "Hola " + bundle.getString("NOMBRE")
    }
}