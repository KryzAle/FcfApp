package com.kryzcorp.kryzaleasus.fcf.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.kryzcorp.kryzaleasus.fcf.R;

/**
 * Created by KryzAleAsus on 29/7/2017.
 */

public class DecoracionActivity extends Activity {
    @Override public  void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoracion);
        Button botonAceptarCaracteristicas =(Button) findViewById(R.id.btnAceptarDecoracion);
        final CheckBox floreros = (CheckBox) findViewById(R.id.cbFloreros);
        final CheckBox globos = (CheckBox) findViewById(R.id.cbGlobos);
        final CheckBox cintas = (CheckBox) findViewById(R.id.cbCintas);

        botonAceptarCaracteristicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemServiciosSeleccionados = " " ;
                Double precioTotal = 0.0;

                if(floreros.isChecked()) {
                    precioTotal = precioTotal + 10.25;
                    itemServiciosSeleccionados = itemServiciosSeleccionados+" "+floreros.getText().toString();
                }
                if(globos.isChecked()) {
                    precioTotal = precioTotal + 3.40;
                    itemServiciosSeleccionados = itemServiciosSeleccionados+" "+globos.getText().toString();
                }
                if(cintas.isChecked()) {
                    precioTotal = precioTotal + 1.75;
                    itemServiciosSeleccionados = itemServiciosSeleccionados+" "+cintas.getText().toString();
                }
                String costoTotal = String.valueOf(precioTotal);
                Intent resultdata = new Intent();
                resultdata.putExtra("Test",costoTotal);
                resultdata.putExtra("Info",itemServiciosSeleccionados);
                resultdata.putExtra("identificador","5");
                setResult(MainActivity.RESULT_OK,resultdata);
                finish();
            }
        });
    }
}
