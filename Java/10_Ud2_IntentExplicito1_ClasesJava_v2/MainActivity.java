package com.pms.a10_ud2intentexplicito01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // objetos View del Layout
    EditText txtNombre;
    Button btnHola;
    //realmente, el totón, no es necesario declararlo, pues el evento onClick se controla desde el
    //método declarado en la propiedad del layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // referencias a objetos del layout
        txtNombre = (EditText) findViewById(R.id.TxtNombre);
        //btnHola = (Button) findViewById(R.id.BtnHola);
    }

    /**
     * Funcionalidad o comportamiento al pulsar el botón BtnHola
     * @param v: botón btnHola
     */
    public void bHola (View v) {

        //1) intent para lanzar la activity SegundaActivity
        Intent inte2 = new Intent(getApplicationContext(),
                SegundaActivity.class);


        //2) Se añade información EXTRA mediante a) un objeto Bundle o  b) el propio Intent

        //a) PASANDO información EXTRA con un OBJETO Bundle (colección de parejas  clave-valor)

        //Objeto bundle para pasar información a la activity que se lanza
        Bundle bundatos = new Bundle();
        // información pasada:
        // clave:"NOMBRE",
        // valor=txtNombre.getText().toString()
        bundatos.putString("NOMBRE", txtNombre.getText().toString());
        // asocia información pasada al intent que lanzará la nueva activity
        inte2.putExtras(bundatos);

   /*    //b) PASANDO información EXTRA mediante el propio Intent (parejas clave-valoe)

        // información pasada:
        // clave:"NOMBRE",
        // valor=txtNombre.getText().toString()
       inte2.putExtra("NOMBRE", txtNombre.getText().toString());

*/
        //3) se lanza la activity asociada a este Intent con los Extra añadidos, si los hay
        startActivity(inte2);



    }
}
