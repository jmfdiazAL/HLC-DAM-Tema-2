package com.pms.a03_ud2saludo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //obtenemos una referencia al botón del layout
        Button bSaludo= (Button)findViewById(R.id.botonSaludo);

        //Funcionalidad al pulsar el botón
        //implementada mediante la interfaz OnClickListener (escuchador de eventos)
        bSaludo.setOnClickListener(new View.OnClickListener(){
            //redefinimos el método onClick()
            @Override
            public void onClick(View v){
                //obtenemos una referencia al EditText del layout
                EditText cajaSaludo = (EditText)findViewById(R.id.cajaSaludo);
                //Crea un objeto Toast con el mensaje apropiado
                Toast tostada = Toast.makeText(getApplicationContext(),
                        "Hola: "+cajaSaludo.getText().toString(), Toast.LENGTH_LONG);
                //Visualiza o muestra el objeto tostada
                tostada.show();
            }
        });


    }
}
