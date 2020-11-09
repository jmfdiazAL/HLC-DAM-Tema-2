package com.pms.a12_ud2intentimplicito

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {
    // variables
    var `in`: Intent? = null

    //Button bNavegar, bMapa, bDial, bCall; //no son necesarios pues no hay Listener para el onClick
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Referenciamos los botones del layout -- no es necesario pues no se referencian directamente
        // bNavegar =(Button)this.findViewById(R.id.botonUrl);
        // bMapa =(Button)this.findViewById(R.id.botonMapa);
        // bDial = (Button)this.findViewById(R.id.botonDial);
        // bCall = (Button)this.findViewById(R.id.botonCall);
    }

    /**
     * Funcionalidad al pulsar el botón Abrir navegador
     *
     * @param v: botón del layout
     */
    fun iNavegador(v: View?) {
        val link = "http://www.iesalandalus.org"
        `in` = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(`in`)
    }

    /**
     * Funcionalidad al pulsar el botón Abrir localización
     *
     * @param v: botón del layout
     */
    fun iMapas(v: View?) {
        val dir = "Calle+Argollones+Almería"
        `in` = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$dir"))
        startActivity(`in`)
    }

    /**
     * Funcionalidad al pulsar el botón Abrir el DIAL
     *
     * @param v: botón del layout
     */
    fun iDial(v: View?) {
        val tlf = "950275201"
        `in` = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$tlf"))
        startActivity(`in`)
    }

    /**
     * Funcionalidad al pulsar el botón Realizar llamada
     *
     * @param v: botón del layout
     */
    // se necesita en el manifiesto el permiso
    // <uses-permission android:name="android.permission.CALL_PHONE" />
    fun iCall(v: View?) {

        /*
        String tlf="950275209";
        in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+tlf));
        try {
            startActivity(in);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), "No encuentro aplicación para la llamada.",
                    Toast.LENGTH_SHORT).show();
        }
        */
        callPhoneNumber() //añadido debajo
    }

    /**
     * Método que comprueba el API o SDK para lanzar una llamada telefónica
     * solicitando permiso expreso del usuario según API sea >22 o menor
     */
    fun callPhoneNumber() {
        try {
            if (Build.VERSION.SDK_INT > 22) {    //comprobar si tenemos el permiso CALL_PHONE
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //la app solicita permiso al usuario de manera explícita con un código identificativo de petición
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 101)
                    return
                }
                val callIntent = Intent(Intent.ACTION_CALL)
                callIntent.data = Uri.parse("tel:" + "920222222")
                startActivity(callIntent)
            } else { //si el API oSDK <= 21 -- ya se indicado el permiso en el manifiesto
                val callIntent = Intent(Intent.ACTION_CALL)
                callIntent.data = Uri.parse("tel:" + "950275209")
                startActivity(callIntent)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}