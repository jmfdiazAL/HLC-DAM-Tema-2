package com.pms.a12_ud2intentimplicito;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // variables
    Intent in = null;
    //Button bNavegar, bMapa, bDial, bCall; //no son necesarios pues no hay Listener para el onClick


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    public void iNavegador(View v) {
        String link = "http://www.iesalandalus.org";
        in = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(in);
    }

    /**
     * Funcionalidad al pulsar el botón Abrir localización
     *
     * @param v: botón del layout
     */
    public void iMapas(View v) {

        String dir = "Calle+Argollones+Almería";
        in = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + dir));
        startActivity(in);
    }

    /**
     * Funcionalidad al pulsar el botón Abrir el DIAL
     *
     * @param v: botón del layout
     */
    public void iDial(View v) {
        String tlf = "950275201";
        in = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tlf));
        startActivity(in);

    }

    /**
     * Funcionalidad al pulsar el botón Realizar llamada
     *
     * @param v: botón del layout
     */
    // se necesita en el manifiesto el permiso
    // <uses-permission android:name="android.permission.CALL_PHONE" />
    public void iCall(View v) {

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
        callPhoneNumber(); //añadido debajo

    }

    /**
     * Método que comprueba el API o SDK para lanzar una llamada telefónica
     * solicitando permiso expreso del usuario según API sea >22 o menor
     */
    public void callPhoneNumber() {
        try {
            if (Build.VERSION.SDK_INT > 22) {    //comprobar si tenemos el permiso CALL_PHONE
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //la app solicita permiso al usuario de manera explícita con un código identificativo de petición
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 101);

                    return;
                }

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + "920222222"));
                startActivity(callIntent);

            } else {//si el API oSDK <= 21 -- ya se indicado el permiso en el manifiesto
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + "950275209"));
                startActivity(callIntent);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
