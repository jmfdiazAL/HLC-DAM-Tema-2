package com.pms.a08_guardarestadosi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int contador=0;
    TextView texto;

    @Override
    protected void onCreate(Bundle estado) {
        super.onCreate(estado);
        setContentView(R.layout.activity_main);

        //referencia a las vistas del layout
        texto=(TextView) findViewById(R.id.text);

  /*

	//*****también se puede restaurar el estado mediante esta otra forma ************
	//no habrá que usar el método onRestoreInstanceState
	if(estado!=null){
		contador = estado.getInt("posicion");
		texto.setText(String.valueOf(contador));
	}
	//*****************

   */

    }

    /**
     * Comportamiento del botón Suma
     * @param view: botón Suma
     */
    public void onClickSuma(View view){
        contador++;
        texto.setText(String.valueOf(contador));

    }

    //Llamado cuando la actividad pasará a segundo plano o se va a destruir
    @Override
    protected void onSaveInstanceState(Bundle estado){
        super.onSaveInstanceState(estado);
        estado.putInt("posicion", contador);

    }

    //llamado cuando la actividad va a ser restaurada
    @Override
    protected void onRestoreInstanceState(Bundle estado){
        super.onRestoreInstanceState(estado);
        contador = estado.getInt("posicion");
        texto.setText(String.valueOf(contador));
    }



}
