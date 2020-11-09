package com.pms.a14_ud2ejercomunicaactivity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val cod = 1 // código acordado al lanzar una Activity esperando respuesta
    private var campo_nombre // EditText que guardará el nombre
            : EditText? = null
    private var campo_edad // EditText que guardará la edad
            : EditText? = null
    private var nombre // Nombre obtenido
            : String? = null
    private var edad //Edad obtenida
            = 0
    private var fallaedad = 0
    private var fallanombre // Para controlar si falla la edad o nombre
            = 0

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
        campo_nombre = findViewById<View>(R.id.editTextNombre) as EditText
        // se guarda el nombre del EditText campo_nombre
        nombre = campo_nombre!!.text.toString()
        //Referencia al EditText del layout
        campo_edad = findViewById<View>(R.id.editTextEdad) as EditText

        // se presupone NO falla edad ni nombre
        fallaedad = 0
        fallanombre = 0

        //comprabamos el valor introducido
        if (nombre!!.length == 0) {
            showToast("Debe introducir un nombre")
            fallaedad = 1
        }
        //En un try...catch evaluamos la Edad como entero
        try {
            // convertimos a Integer el valor del EditText cajaEdad
            edad = campo_edad!!.text.toString().toInt()
        } catch (nfe: NumberFormatException) {
            fallaedad = 1
            showToast("Debe introducir un entero en el rango correcto")
        }

        //si no falla edad y nombre
        if (fallaedad == 0 && fallanombre == 0) {
            lanzaActivityVerificando()
        }
    }

    private fun lanzaActivityVerificando() {
        // intent explícito para lanzar la actividad "Verificando"
        val intent = Intent(this, Verificando::class.java)

        // objeto Bundle para añadir
        // el dato  'nombre' asociado a la clave 'NOMBRE'
        // el dato 'edad' asoiado a la clave 'EDAD'
        val extras = Bundle()
        extras.putString("NOMBRE", nombre)
        extras.putInt("EDAD", edad)
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