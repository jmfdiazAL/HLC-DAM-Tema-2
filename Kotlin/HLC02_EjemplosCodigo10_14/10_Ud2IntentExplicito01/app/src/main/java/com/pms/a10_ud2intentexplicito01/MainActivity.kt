package com.pms.a10_ud2intentexplicito01

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    // objetos View del Layout
    var txtNombre: EditText? = null
    var btnHola: Button? = null

    //realmente, el totón, no es necesario declararlo, pues el evento onClick se controla desde el
    //método declarado en la propiedad del layout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // referencias a objetos del layout
        txtNombre = findViewById<View>(R.id.TxtNombre) as EditText
        //btnHola = (Button) findViewById(R.id.BtnHola);
    }

    /**
     * Funcionalidad o comportamiento al pulsar el botón BtnHola
     * @param v: botón btnHola
     */
    fun bHola(v: View?) {
        // intent para lanzar la activity SegundaActivity
        val inte2 = Intent(applicationContext,
                SegundaActivity::class.java)
        //Objeto bundle para pasar información a la activity que se lanza
        val bundatos = Bundle()
        // información pasada:
        // clave:"NOMBRE",
        // valor=txtNombre.getText().toString()
        bundatos.putString("NOMBRE", txtNombre!!.text.toString())
        // asocia información pasada al intent que lanzará la nueva activity
        inte2.putExtras(bundatos)
        // se lanza la activity asociada a este Intent
        startActivity(inte2)
    }
}