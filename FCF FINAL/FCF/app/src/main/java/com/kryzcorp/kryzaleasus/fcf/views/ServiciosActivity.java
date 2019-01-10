package com.kryzcorp.kryzaleasus.fcf.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.kryzcorp.kryzaleasus.fcf.R;

/**
 * Created by KryzAleAsus on 29/7/2017.
 */

public class ServiciosActivity extends Activity {
    @Override public  void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        Button botonAceptarCaracteristicas =(Button) findViewById(R.id.btnAceptarServicios);
        final CheckBox meseros = (CheckBox) findViewById(R.id.cbMeseros);
        final CheckBox musica = (CheckBox) findViewById(R.id.cbMusica);
        final CheckBox cristaleria = (CheckBox) findViewById(R.id.cbCristaleria);

        botonAceptarCaracteristicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemServiciosSeleccionados = " " ;
                Double precioTotal = 0.0;
                if(meseros.isChecked()) {
                    precioTotal = precioTotal + 45.00;
                    itemServiciosSeleccionados = itemServiciosSeleccionados+" "+meseros.getText().toString();
                }
                if(musica.isChecked()) {
                    precioTotal = precioTotal + 50.50;
                    itemServiciosSeleccionados = itemServiciosSeleccionados+" "+musica.getText().toString();
                }
                if(cristaleria.isChecked()) {
                    precioTotal = precioTotal + 30.75;
                    itemServiciosSeleccionados = itemServiciosSeleccionados+" "+cristaleria.getText().toString();
                }
                String costoTotal = String.valueOf(precioTotal);
                Intent resultdata = new Intent();
                resultdata.putExtra("Test",costoTotal);
                resultdata.putExtra("Info",itemServiciosSeleccionados);
                resultdata.putExtra("identificador","4");
                setResult(MainActivity.RESULT_OK,resultdata);
                finish();
            }
        });
    }
}
