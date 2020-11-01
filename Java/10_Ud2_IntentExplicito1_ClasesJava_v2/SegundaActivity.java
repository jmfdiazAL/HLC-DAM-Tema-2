package com.pms.a10_ud2intentexplicito01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        //referencia a la View TextView del layout XML
        TextView txtMensaje = (TextView)findViewById(R.id.TxtMensaje);

        //a) Obteniendo información extra del Intent usando un objeto Bundle

        //1º)obtiene la información pasada por la activity llamadora (MainActivity)
        //en un objeto Bundle (extrae la información del Intent y la deja en un Bundle)
        Bundle bundle = getIntent().getExtras();

        //2º)visualiza la información pasada extrayendo el valor asociado a la clave
        txtMensaje.setText("Hola " + bundle.getString("NOMBRE"));

  /*
        //b) Obteniendo información extra usando el propio Intent

        //1º)obtiene el Intent con el que ha sido lanzada esta Activity
        Intent intres =getIntent();
        //2º)Obtiene el valor asociado a la clave 'NOMBRE' pasado mediante el Intent
        String mensaje =intres.getExtras().getString("NOMBRE");
        //3º)visualiza la información pasada en el TextView correspondiente
        txtMensaje.setText("Hola " + mensaje);
*/
    }
}
