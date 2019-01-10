package com.kryzcorp.kryzaleasus.fcf.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kryzcorp.kryzaleasus.fcf.R;

/**
 * Created by santy on 25/7/2017.
 */

public class AdministradorActivity extends Activity {
    @Override public  void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administrador);
    }
    public void LanzarGestionAdministrador(View view){

       final EditText txtUsuario = (EditText) findViewById(R.id.txtUsuario);
       final EditText txtContrasena = (EditText) findViewById(R.id.txtContrasena);

        if(txtUsuario.getText().toString().equalsIgnoreCase("S") && txtContrasena.getText().toString().equalsIgnoreCase("L")){
            Intent i = new Intent(this,GestionAdministradorActivity.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "Usuario o Contraseña Incorrectos",
                    Toast.LENGTH_LONG).show();
        }

    }
}
