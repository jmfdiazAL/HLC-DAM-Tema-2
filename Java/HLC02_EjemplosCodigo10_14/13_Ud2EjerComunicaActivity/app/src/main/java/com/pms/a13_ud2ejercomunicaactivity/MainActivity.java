package com.pms.a13_ud2ejercomunicaactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int cod = 1; // código acordado al lanzar una Activity esperando respuesta
    private EditText campo_nombre; // EditText que guardará el nombre
    private String nombre;// Nombre obtenido


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Método asociado al evento de onClick del botón Verificar
     * @param view
     */
    public void verificar (View view) {
        //Referencia al EditText del layout
        campo_nombre= (EditText) findViewById(R.id.editText1);
        // se guarda el nombre del EditText campo_nombre
        nombre = campo_nombre.getText().toString();
        if(nombre.length()==0){
            showToast("Debe introducir un nombre");

        }else {
            lanzaActivityVerificando();

        }
    }

    private void lanzaActivityVerificando(){
        // intent explícito para lanzar la actividad "Verificando"
        Intent intent = new Intent(this, Verificando.class);

        // objeto Bundle para añadir el dato  'nombre' asociado a la clave 'NOMBRE'
        Bundle extras = new Bundle();
        extras.putString("NOMBRE", nombre);
        //añade la información del bundle al intent
        intent.putExtras(extras);

        // lanza la actividad asociada al intent esperando un resultado de vuelta y
        // asociando un código de petición
        startActivityForResult(intent, cod);

    }

    /**********  Comprobando resultados devueltos *********/

    /**
     * Método que comprueba la información devuelta por la actividad lanzada esperando resultados
     * @param requestCode: código de petición
     * @param resultCode: código de resutado
     * @param data: intent de vuelta
     */
    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        //referencia al TextView del layout
        TextView resultado = (TextView) findViewById(R.id.etiqueta_resultado);

        //comprueba el código de petición y el código de resultado
        if(requestCode==cod && resultCode==RESULT_OK) {
            // obtiene la información del intent con los resultados devueltos
            String res = data.getExtras().getString("RESULTADO");

            //muestra el resultado devuelto en el TextView
            resultado.setText("El resultado es: " + res);
        }
    }
    protected void showToast(String msg) {
        Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
        toast.show();
    }
}
