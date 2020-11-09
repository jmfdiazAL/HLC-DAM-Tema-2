package com.pms.a10_ud2intentexplicito01

class MainActivity : AppCompatActivity() {
    // objetos View del Layout
    var txtNombre: EditText? = null
    var btnHola: android.widget.Button? = null

    //realmente, el totón, no es necesario declararlo, pues el evento onClick se controla desde el
    //método declarado en la propiedad del layout
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // referencias a objetos del layout
        txtNombre = findViewById<android.view.View>(R.id.TxtNombre) as EditText?
        //btnHola = (Button) findViewById(R.id.BtnHola);
    }

    /**
     * Funcionalidad o comportamiento al pulsar el botón BtnHola
     * @param v: botón btnHola
     */
    fun bHola(v: android.view.View?) {

        //1) intent para lanzar la activity SegundaActivity
        val inte2 = Intent(getApplicationContext(),
                SegundaActivity::class.java)


        //2) Se añade información EXTRA mediante a) un objeto Bundle o  b) el propio Intent

        //a) PASANDO información EXTRA con un OBJETO Bundle (colección de parejas  clave-valor)

        //Objeto bundle para pasar información a la activity que se lanza
        val bundatos = Bundle()
        // información pasada:
        // clave:"NOMBRE",
        // valor=txtNombre.getText().toString()
        bundatos.putString("NOMBRE", txtNombre.getText().toString())
        // asocia información pasada al intent que lanzará la nueva activity
        inte2.putExtras(bundatos)

        /*    //b) PASANDO información EXTRA mediante el propio Intent (parejas clave-valoe)

        // información pasada:
        // clave:"NOMBRE",
        // valor=txtNombre.getText().toString()
       inte2.putExtra("NOMBRE", txtNombre.getText().toString());

*/
        //3) se lanza la activity asociada a este Intent con los Extra añadidos, si los hay
        startActivity(inte2)
    }
}