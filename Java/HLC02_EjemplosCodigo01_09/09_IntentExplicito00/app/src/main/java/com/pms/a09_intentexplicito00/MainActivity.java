package com.pms.a09_intentexplicito00;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }// fin onCreate()

    /**
     * Comportamiento del botón al hacer click
     */
    public void SegundaActivity(View v) {
        // Declara un Intent explícito
        Intent i2 = new Intent(getApplicationContext(), Actividad2.class);
        //Lanza la Activity2 mediante el intent i2
        startActivity(i2);
    }
}
