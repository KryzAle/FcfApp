package com.kryzcorp.kryzaleasus.fcf.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.kryzcorp.kryzaleasus.fcf.R;

/**
 * Created by KryzAleAsus on 29/7/2017.
 */

public class PlatillosActivity extends Activity {
    @Override public  void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platillos);
        Button botonAceptarCaracteristicas =(Button) findViewById(R.id.btnAceptarPlatillos);
        final RadioButton sopa1 = (RadioButton) findViewById(R.id.rbSopa1);
        final RadioButton sopa2 = (RadioButton) findViewById(R.id.rbSopa2);
        final RadioButton sopa3 = (RadioButton) findViewById(R.id.rbSopa3);

        final RadioButton principal1 = (RadioButton) findViewById(R.id.rbPrincipal1);
        final RadioButton principal2 = (RadioButton) findViewById(R.id.rbPrincipal2);
        final RadioButton principal3 = (RadioButton) findViewById(R.id.rbPrincipal3);
        final RadioButton principal4 = (RadioButton) findViewById(R.id.rbPrincipal4);
        final RadioButton principal5 = (RadioButton) findViewById(R.id.rbPrincipal5);
        final RadioButton principal6 = (RadioButton) findViewById(R.id.rbPrincipal6);

        final RadioButton postre1 = (RadioButton) findViewById(R.id.rbPostre1);
        final RadioButton postre2 = (RadioButton) findViewById(R.id.rbPostre2);

        botonAceptarCaracteristicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemSopaSeleccionada = " ";
                String itemPrincipalSeleccionado = " " ;
                String itemPostreSeleccionado = " " ;
                Double precioTotal = 100.00;
                String costoTotal = String.valueOf(precioTotal);
                if(sopa1.isChecked())
                    itemSopaSeleccionada = sopa1.getText().toString();
                if(sopa2.isChecked())
                    itemSopaSeleccionada = sopa2.getText().toString();
                if(sopa3.isChecked())
                    itemSopaSeleccionada = sopa3.getText().toString();
                if(principal1.isChecked())
                    itemPrincipalSeleccionado = principal1.getText().toString();
                if(principal2.isChecked())
                    itemPrincipalSeleccionado = principal2.getText().toString();
                if(principal3.isChecked())
                    itemPrincipalSeleccionado = principal3.getText().toString();
                if(principal4.isChecked())
                    itemPrincipalSeleccionado = principal4.getText().toString();
                if(principal5.isChecked())
                    itemPrincipalSeleccionado = principal5.getText().toString();
                if(principal6.isChecked())
                    itemPrincipalSeleccionado = principal6.getText().toString();
                if(postre1.isChecked())
                    itemPostreSeleccionado = postre1.getText().toString();
                if(postre2.isChecked())
                    itemPostreSeleccionado = postre2.getText().toString();
                itemPrincipalSeleccionado = "Sopa: "+itemSopaSeleccionada+"\nPlato Principal: "+itemPrincipalSeleccionado+"\nPostre: "+itemPostreSeleccionado;
                Intent resultdata = new Intent();
                resultdata.putExtra("Test",costoTotal);
                resultdata.putExtra("Info",itemPrincipalSeleccionado);
                resultdata.putExtra("identificador","3");
                setResult(MainActivity.RESULT_OK,resultdata);
                finish();
            }
        });
    }
}