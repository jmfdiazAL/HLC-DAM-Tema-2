package com.pms.a08_guardarestadosi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var contador = 0
    var texto: TextView? = null
    override fun onCreate(estado: Bundle?) {
        super.onCreate(estado)
        setContentView(R.layout.activity_main)

        //referencia a las vistas del layout
        texto = findViewById<View>(R.id.text) as TextView

        /*

	// *****también se puede restaurar el estado mediante esta otra forma ************
	//no habrá que usar el método onRestoreInstanceState
	if(estado!=null){
		contador = estado.getInt("posicion");
		texto.setText(String.valueOf(contador));
	}
	// *****************

   */
    }

    /**
     * Comportamiento del botón Suma
     * @param view: botón Suma
     */
    fun onClickSuma(view: View?) {
        contador++
        texto!!.text = contador.toString()
    }

    //Llamado cuando la actividad pasará a segundo plano o se va a destruir
    override fun onSaveInstanceState(estado: Bundle) {
        super.onSaveInstanceState(estado)
        estado.putInt("posicion", contador)
    }

    //llamado cuando la actividad va a ser restaurada
    override fun onRestoreInstanceState(estado: Bundle) {
        super.onRestoreInstanceState(estado)
        contador = estado.getInt("posicion")
        texto!!.text = contador.toString()
    }
}