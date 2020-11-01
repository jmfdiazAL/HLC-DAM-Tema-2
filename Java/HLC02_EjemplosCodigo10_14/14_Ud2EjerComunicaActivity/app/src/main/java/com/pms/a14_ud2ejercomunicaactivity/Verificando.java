package com.pms.a14_ud2ejercomunicaactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Verificando extends AppCompatActivity {

    private String nombre;
    private int edad;

    private TextView mensaje; // TextView para el mensaje hola....

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificando);

        //Recoge información que ha mandado la actividad 'comunica' con el intent
        Bundle info = getIntent().getExtras();
        nombre = info.getString("NOMBRE");
        edad = info.getInt("EDAD");

        mensaje = (TextView) findViewById(R.id.textView1);
        mensaje.setText("Hola "+nombre + " ¿Aceptas las condiciones?");
    }

    /**
     * Método onlClick del botón Apceptar
     * @param v : View botón aceptar
     */

    public void aceptar (View v)
    {
        // mandar información de vuelta a la actividad que llamó a esta
        String resul="";

        // comprobamos el rango de la edad e
        if (edad >= 18)
            resul = " Aceptado sin restricciones";
        else if (edad > 0)
            resul = " Aceptado con restricciones";
        else
            resul = " No Aceptado. No has nacido";
        Intent intent = new Intent ();
        intent.putExtra("RESULTADO", resul);
        setResult(RESULT_OK, intent);
        finish(); //finaliza y cierra la Activity
    }


    /**
     * Método onClick del botón Rechazar
     * @param v : View botón rechazar
     */
    public void rechazar (View v)
    {
        // mandar información de vuelta a la actividad que llamo a esta
        Intent intent = new Intent();
        intent.putExtra("RESULTADO", "Rechazado");
        setResult(RESULT_OK, intent);
        finish(); // Finaliza y cierra la Activity
    }
}
