package com.pms.a04_ud2saludo4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Implementa la interfaz OnClickListener como parte de la Activity y
// recoge los eventos en el método onClick().
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos una referencia al botón del layout
        Button boton = (Button)findViewById(R.id.botonSaludo);
        //La propia clase se encarga de recoger los eventos
        boton.setOnClickListener(this);
    }

    // Método a implementar para el comportamiento onClick del botón para saludar
    @Override

    public void onClick(View v) {
        if(v.getId() == R.id.botonSaludo){
            //obtenemos una referencia al EditText del layout
            EditText cajaSaludo = (EditText)findViewById(R.id.cajaSaludo);
            //Crea un objeto Toast con el mensaje apropiado
            Toast tostada = Toast.makeText(getApplicationContext(), "Hola: "+cajaSaludo.getText().toString(), Toast.LENGTH_LONG);
            //Visualiza o muestra el objeto tostada
            tostada.show();
        }
    }
}