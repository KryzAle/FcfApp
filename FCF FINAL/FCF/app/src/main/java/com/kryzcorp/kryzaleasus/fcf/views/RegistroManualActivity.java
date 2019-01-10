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

public class RegistroManualActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_manual);

    }

    public void LanzarMain(View view) {

        EditText nombre = (EditText) findViewById(R.id.txtNombre);
        EditText mail = (EditText) findViewById(R.id.txtMail);
        EditText telefono = (EditText) findViewById(R.id.txtTelefono);
        EditText direccion = (EditText) findViewById(R.id.txtDireccion);

        if (nombre.getText().toString().equals("")|| telefono.getText().toString().equals("")|| direccion.getText().toString().equals("")|| mail.getText().toString().equals("") ) {
            Toast.makeText(this, "Ha dejado campos vacios",
                    Toast.LENGTH_LONG).show();
        }else{
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("name",nombre.getText().toString());
            i.putExtra("mail",mail.getText().toString());
            i.putExtra("tlf",telefono.getText().toString());
            i.putExtra("direccion",direccion.getText().toString());
            startActivity(i);
        }


    }



}