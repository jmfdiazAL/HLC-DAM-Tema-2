package com.pms.a10_ud2intentexplicito01

class SegundaActivity : AppCompatActivity() {
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        //referencia a la View TextView del layout XML
        val txtMensaje: TextView = findViewById<android.view.View>(R.id.TxtMensaje) as TextView

        //a) Obteniendo información extra del Intent usando un objeto Bundle

        //1º)obtiene la información pasada por la activity llamadora (MainActivity)
        //en un objeto Bundle (extrae la información del Intent y la deja en un Bundle)
        val bundle: Bundle = getIntent().getExtras()

        //2º)visualiza la información pasada extrayendo el valor asociado a la clave
        txtMensaje.setText("Hola " + bundle.getString("NOMBRE"))

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