package com.pms.a02_ud2saludo2;

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
       /* No es necesario referenciar la botón del layout, pues el evento onClick
       lo implementamos directamente mediante el método indicado en el layout
        */
        //referencia al componente botón descrito en el layout
        //Button bSaludo = (Button) this.findViewById(R.id.botonSaludo);

    }

    /**
     * comportamiento del botón Saludo al hacer onClick sobre él
     * método asociado al evento onClick en el layout del botón
     * android:onClick="metodoSaludo"
     */
    public void metodoSaludo(View v) {
        //obtenemos una referencia al componente EditText descrito en el layout
        EditText cajaSaludo = (EditText) findViewById(R.id.cajaSaludo);
        //Declara un objeto Toast y compone el mensaje "Hola"+el nombre del EditText
        Toast tostada = Toast.makeText(getApplicationContext(), "Hola  :" +
                cajaSaludo.getText().toString(), Toast.LENGTH_LONG);
        //se muestra la tostada
        tostada.show();
    }
}
