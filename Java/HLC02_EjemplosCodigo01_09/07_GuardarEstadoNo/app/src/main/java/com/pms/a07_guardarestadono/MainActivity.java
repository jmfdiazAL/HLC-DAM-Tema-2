package com.pms.a07_guardarestadono;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int contador=0;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //referenciamos la vista TextView del layout
        texto=(TextView) findViewById(R.id.text);
    }

    /**
     * Comportamiento del botón suma
     * @param view: botón suma
     */

    public void onClickSuma(View view){
        //incrementa 1 el contador
        contador++;
        //asigna el valor del contador al TextView
        texto.setText(String.valueOf(contador));
    }

}
