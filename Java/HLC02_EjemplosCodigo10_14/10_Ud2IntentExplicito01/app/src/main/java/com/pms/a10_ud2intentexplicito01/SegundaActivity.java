package com.pms.a10_ud2intentexplicito01;

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

        //obtiene la información pasada por la activity llamadora (MainActivity) en un objeto Bundle
        Bundle bundle = getIntent().getExtras();

        //visualiza la información pasada extrayendo el valor asociado a la clave
        txtMensaje.setText("Hola " + bundle.getString("NOMBRE"));
    }
}
