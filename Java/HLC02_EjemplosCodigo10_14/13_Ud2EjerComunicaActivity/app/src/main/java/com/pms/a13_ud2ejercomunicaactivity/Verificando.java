package com.pms.a13_ud2ejercomunicaactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Verificando extends AppCompatActivity {

    private String nombre;

    private TextView mensaje; // Textview para el mensaje hola....

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificando);

        //Recoge información que ha mandado la actividad 'comunica' con el intent
        Bundle info = getIntent().getExtras();
        nombre = info.getString("NOMBRE");

        mensaje = (TextView) findViewById(R.id.textView1);
        mensaje.setText("Hola "+nombre);
    }

    /**
     * Método onlClick del botón Apceptar
     * @param v : View botón aceptar
     */

    public void aceptar (View v)
    {
        // mandar información de vuelta a la actividad que llamó a esta
        Intent intent = new Intent ();
        intent.putExtra("RESULTADO", "Aceptado");
        setResult(RESULT_OK, intent);
        finish(); // finaliza y cierra la Activity
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
        finish(); // finaliza y cierra la Activity
    }
}
