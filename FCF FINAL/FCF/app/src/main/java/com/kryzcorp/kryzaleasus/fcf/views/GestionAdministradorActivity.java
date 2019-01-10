package com.kryzcorp.kryzaleasus.fcf.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kryzcorp.kryzaleasus.fcf.R;

/**
 * Created by santy on 26/7/2017.
 */

public class GestionAdministradorActivity extends Activity{
    @Override public  void  onCreate(Bundle savedInstanceState){
        Boolean validar = true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_administrador);
    }
    public void lanzarConsultarLocal(View view){
        Intent i = new Intent(this,ConsultarLocalActivity.class);
        startActivity(i);
    }
}


