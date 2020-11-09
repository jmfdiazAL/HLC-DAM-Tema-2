package com.pms.a09_intentexplicito00

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class Actividad2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)
    }

    /* Comportamiento Onclick botón PrimeraActivity, indicado nombre método en XML*/
    fun PrimeraActivity(v: View?) {

        //Objeto Intent explícito
        val i1 = Intent(applicationContext, MainActivity::class.java)
        /* a) Lanza la Activitividad 1 y pone otra instancia de ella en la pila o back stack*/startActivity(i1)

        /* b) O bien, para no crear otra instancia en la pila de MainActivity,
        finalizamos la Activity2 con finnish() y así se hace visible la anterior
        */
        // finaliza la Activity actual
        //finish();
    }

    /* Comportamiento Onclick botón TerceraActivity, indicado nombre método en XML*/
    fun TerceraActivity(v: View?) {
        /*Objeto Intent explícito */
        val i3 = Intent(applicationContext, Actividad3::class.java)
        /*Lanza la Activity3*/startActivity(i3)
    }
}