package com.pms.a06_ud2ciclovidaactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CicloVidaActivity extends AppCompatActivity {

   //método que se ejecuta al crear la Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_vida);

        Toast.makeText(this,  " onCreate", Toast.LENGTH_SHORT).show();
    }
    //Método que inicia la acticity pero aún no se puede interactuar con ella
    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(this,  " onStart", Toast.LENGTH_SHORT).show();
    }
    //Método que se ejecuta cuando se reinicia la Activity desde la pila
    @Override
    public void onRestart() {
        super.onRestart();
        Toast.makeText(this,  " onRestart", Toast.LENGTH_SHORT).show();
    }
    //Método que se ejecuta cuando la Activity es visible y el usuario puede interactuar con ella
    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(this,  " onResume", Toast.LENGTH_SHORT).show();
    }
    //Método que se eejcuta cuando otra Activity pasa a primer plano, pero la actual aún es visible
    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(this,  " onPause", Toast.LENGTH_SHORT).show();
    }
    //Método que se ejecuta cuando la Activity pasa a segundo plano y no es visible
    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(this,  " onStop", Toast.LENGTH_SHORT).show();
    }
    //Métodod que se ejecuta al destruir a una Activity
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,  " onDestroy", Toast.LENGTH_SHORT).show();
    }
}
