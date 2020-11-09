package com.pms.a02_ud2saludo2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /* No es necesario referenciar la botón del layout, pues el evento onClick
       lo implementamos directamente mediante el método indicado en el layout
        */
        //referencia al componente botón descrito en el layout
        //Button bSaludo = (Button) this.findViewById(R.id.botonSaludo);
    }

    /**
     * comportamiento del botón Saludo al hacer onClick sobre él
     * método asociado al evento onClick en el layout del botón
     * android:onClick="metodoSaludo"
     */
    fun metodoSaludo(v: View?) {
        //obtenemos una referencia al componente EditText descrito en el layout
        val cajaSaludo = findViewById<View>(R.id.cajaSaludo) as EditText
        //Declara un objeto Toast y compone el mensaje "Hola"+el nombre del EditText
        val tostada = Toast.makeText(applicationContext, "Hola  :" +
                cajaSaludo.text.toString(), Toast.LENGTH_LONG)
        //se muestra la tostada
        tostada.show()
    }
}