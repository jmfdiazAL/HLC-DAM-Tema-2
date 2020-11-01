package com.pms.a14_ud2ejercomunicaactivity;

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
    private EditText campo_edad; // EditText que guardará la edad
    private String nombre;// Nombre obtenido
    private int edad; //Edad obtenida
    private int fallaedad, fallanombre; // Para controlar si falla la edad o nombre
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
        campo_nombre= (EditText) findViewById(R.id.editTextNombre);
        // se guarda el nombre del EditText campo_nombre
        nombre = campo_nombre.getText().toString();
        //Referencia al EditText del layout
        campo_edad= (EditText) findViewById(R.id.editTextEdad);

        // se presupone NO falla edad ni nombre
        fallaedad=0;
        fallanombre=0;

        //comprabamos el valor introducido
        if(nombre.length()==0){
            showToast("Debe introducir un nombre");
            fallaedad=1;
        };
        //En un try...catch evaluamos la Edad como entero
        try {
            // convertimos a Integer el valor del EditText cajaEdad
            edad = Integer.parseInt(campo_edad.getText().toString());

        } catch (NumberFormatException nfe) {
            fallaedad=1;
            showToast("Debe introducir un entero en el rango correcto");
        }

        //si no falla edad y nombre
        if(fallaedad==0 && fallanombre==0){
            lanzaActivityVerificando();
        }
    }

    private void lanzaActivityVerificando(){
        // intent explícito para lanzar la actividad "Verificando"
        Intent intent = new Intent(this, Verificando.class);

        // objeto Bundle para añadir
        // el dato  'nombre' asociado a la clave 'NOMBRE'
        // el dato 'edad' asoiado a la clave 'EDAD'
        Bundle extras = new Bundle();
        extras.putString("NOMBRE", nombre);
        extras.putInt("EDAD", edad);
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
