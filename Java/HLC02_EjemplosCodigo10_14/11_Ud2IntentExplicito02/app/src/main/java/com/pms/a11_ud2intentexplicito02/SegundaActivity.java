package com.pms.a11_ud2intentexplicito02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        //referencia a la View del XML
        TextView txtMensaje = (TextView)findViewById(R.id.TxtMensaje);

        //obiene la informacion pasada por la activity llamadora (la MainActivity o Activity1)
        Bundle bundle = getIntent().getExtras();

        //visualiza la información pasada
        txtMensaje.setText("Hola " + bundle.getString("NOMBRE"));

        /********* devolviendo resultados *********/

        Intent intent = new Intent();
        intent.putExtra("RESULTADO", "valor devuelto desde segunda Activity");

        setResult(RESULT_OK, intent);

    }
}
