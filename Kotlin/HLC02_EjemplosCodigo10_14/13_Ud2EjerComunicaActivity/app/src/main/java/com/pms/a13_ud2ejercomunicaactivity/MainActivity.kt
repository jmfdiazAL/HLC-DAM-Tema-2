package com.pms.a13_ud2ejercomunicaactivity

import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import com.pms.a13_ud2ejercomunicaactivity.R
import android.content.Intent
import com.pms.a13_ud2ejercomunicaactivity.Verificando
import android.widget.TextView
import android.app.Activity
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val cod = 1 // código acordado al lanzar una Activity esperando respuesta
    private var campo_nombre // EditText que guardará el nombre
            : EditText? = null
    private var nombre // Nombre obtenido
            : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Método asociado al evento de onClick del botón Verificar
     * @param view
     */
    fun verificar(view: View?) {
        //Referencia al EditText del layout
        campo_nombre = findViewById<View>(R.id.editText1) as EditText
        // se guarda el nombre del EditText campo_nombre
        nombre = campo_nombre!!.text.toString()
        if (nombre!!.length == 0) {
            showToast("Debe introducir un nombre")
        } else {
            lanzaActivityVerificando()
        }
    }

    private fun lanzaActivityVerificando() {
        // intent explícito para lanzar la actividad "Verificando"
        val intent = Intent(this, Verificando::class.java)

        // objeto Bundle para añadir el dato  'nombre' asociado a la clave 'NOMBRE'
        val extras = Bundle()
        extras.putString("NOMBRE", nombre)
        //añade la información del bundle al intent
        intent.putExtras(extras)

        // lanza la actividad asociada al intent esperando un resultado de vuelta y
        // asociando un código de petición
        startActivityForResult(intent, cod)
    }
    /**********  Comprobando resultados devueltos  */
    /**
     * Método que comprueba la información devuelta por la actividad lanzada esperando resultados
     * @param requestCode: código de petición
     * @param resultCode: código de resutado
     * @param data: intent de vuelta
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //referencia al TextView del layout
        val resultado = findViewById<View>(R.id.etiqueta_resultado) as TextView

        //comprueba el código de petición y el código de resultado
        if (requestCode == cod && resultCode == RESULT_OK) {
            // obtiene la información del intent con los resultados devueltos
            val res = data!!.extras.getString("RESULTADO")

            //muestra el resultado devuelto en el TextView
            resultado.text = "El resultado es: $res"
        }
    }

    protected fun showToast(msg: String?) {
        val toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG)
        toast.show()
    }
}