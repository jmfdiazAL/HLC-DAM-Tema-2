package com.pms.a11_ud2intentexplicito02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int cod = 1; // código de petición al lanzar la Activity que espera resultados
    EditText txtNombre;
    Button btnHola; // realmente no es necesario, pues no se hace referencia directa a él

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // referencias a objetos view
        txtNombre = (EditText) findViewById(R.id.TxtNombre);
        //btnHola = (Button) findViewById(R.id.BtnHola);

    }

    /**
     * Comportamiento al pulsar el botón Hola
     * @param v: botoón btnHola
     */
    public void botonHola (View v){
        // intent para lanzar la activity Frmmensaje
        Intent intent = new Intent(getApplicationContext(),
                SegundaActivity.class);
        // Objeto para pasar información a la activity que se lanza
        // (activity llamada)
        Bundle bundle = new Bundle();
        // información pasada: clave:"NOMBRE",
        // valor=txtNombre.getText().toString()
        bundle.putString("NOMBRE", txtNombre.getText().toString());
        // asocia información pasada al intent que lanzará la nueva
        // activity
        intent.putExtras(bundle);

        /****** startActivityForResult() ******/
        // se lanza la activity asociada a este Intent ESPERANDO
        // RESULTADO
        startActivityForResult(intent, cod);
    }

    /**
     *  método a implementar si la Activiy espera un resultado
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //comprobamos el código de petición y el código de resultado
        if (requestCode == cod && resultCode == RESULT_OK) { // si es correcto
            //obtenemos la información de vuelta
            String res = data.getExtras().getString("RESULTADO");

            // mostramos resultado devuelto
            Toast toast = Toast.makeText(getApplicationContext(), "Recibido:  "
                    + res, Toast.LENGTH_LONG);
            toast.show();
        }

    }
}

