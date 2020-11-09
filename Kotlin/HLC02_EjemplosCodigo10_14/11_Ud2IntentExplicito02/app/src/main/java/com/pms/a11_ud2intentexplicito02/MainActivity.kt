package com.pms.a11_ud2intentexplicito02

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var cod = 1 // código de petición al lanzar la Activity que espera resultados
    var txtNombre: EditText? = null
    var btnHola // realmente no es necesario, pues no se hace referencia directa a él
            : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // referencias a objetos view
        txtNombre = findViewById<View>(R.id.TxtNombre) as EditText
        //btnHola = (Button) findViewById(R.id.BtnHola);
    }

    /**
     * Comportamiento al pulsar el botón Hola
     * @param v: botoón btnHola
     */
    fun botonHola(v: View?) {
        // intent para lanzar la activity Frmmensaje
        val intent = Intent(applicationContext,
                SegundaActivity::class.java)
        // Objeto para pasar información a la activity que se lanza
        // (activity llamada)
        val bundle = Bundle()
        // información pasada: clave:"NOMBRE",
        // valor=txtNombre.getText().toString()
        bundle.putString("NOMBRE", txtNombre!!.text.toString())
        // asocia información pasada al intent que lanzará la nueva
        // activity
        intent.putExtras(bundle)
        /****** startActivityForResult()  */
        // se lanza la activity asociada a este Intent ESPERANDO
        // RESULTADO
        startActivityForResult(intent, cod)
    }

    /**
     * método a implementar si la Activiy espera un resultado
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //comprobamos el código de petición y el código de resultado
        if (requestCode == cod && resultCode == RESULT_OK) { // si es correcto
            //obtenemos la información de vuelta
            val res = data!!.extras.getString("RESULTADO")

            // mostramos resultado devuelto
            val toast = Toast.makeText(applicationContext, "Recibido:  "
                    + res, Toast.LENGTH_LONG)
            toast.show()
        }
    }
}