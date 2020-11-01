package com.pms.a09_intentexplicito00;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Actividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
    }

    /* Comportamiento Onclick botón PrimeraActivity, indicado nombre método en XML*/
    public void PrimeraActivity(View v) {

        //Objeto Intent explícito
        Intent i1 = new Intent(getApplicationContext(), MainActivity.class);
        /* a) Lanza la Activitividad 1 y pone otra instancia de ella en la pila o back stack*/
        startActivity(i1);

        /* b) O bien, para no crear otra instancia en la pila de MainActivity,
        finalizamos la Activity2 con finnish() y así se hace visible la anterior
        */
        // finaliza la Activity actual
        //finish();
    }


    /* Comportamiento Onclick botón TerceraActivity, indicado nombre método en XML*/
    public void TerceraActivity(View v) {
        /*Objeto Intent explícito */
        Intent i3 = new Intent(getApplicationContext(), Actividad3.class);
        /*Lanza la Activity3*/
        startActivity(i3);

    }
}
