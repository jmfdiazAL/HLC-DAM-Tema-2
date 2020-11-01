package com.pms.a05_ud2saludoedad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SaludoEdad extends AppCompatActivity {

    int e;
    Toast toast;
    String str = "";
    Button bSaludo;
    EditText cajaNombre, cajaEdad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo_edad);


        //obtenemos la referencia a los EditText del layout
        cajaNombre = (EditText) findViewById(R.id.cajaNombre);
        cajaEdad = (EditText) findViewById(R.id.cajaEdad);
    }

    /**
     * Método para la funcionalidad del botón botonSaludo al hacer onClick
     */
    public void metodoSaludo(View v){
        //En un try...catch evaluamos la Edad como entero
        try {
            // convertimos a Integer el valor del EditText cajaEdad
            e = Integer.parseInt(cajaEdad.getText().toString());
            // comprobamos el rango de la edad e
            if (e >= 18)
                str = " Eres mayor de edad";
            else if (e > 0)
                str = " Eres menor de edad";
            else
                str = " No has nacido";

            // mostramos un mensaje mediante una tostada
            toast = Toast.makeText(getApplicationContext(), "Hola: " + str
                    + " con Edad: " + cajaEdad.getText().toString(), Toast.LENGTH_LONG);
            toast.show();

        } catch (NumberFormatException nfe) {
            toast = Toast.makeText(getApplicationContext(),
                    "Debe introducir un valor entero (en el rango correcto)", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

}
