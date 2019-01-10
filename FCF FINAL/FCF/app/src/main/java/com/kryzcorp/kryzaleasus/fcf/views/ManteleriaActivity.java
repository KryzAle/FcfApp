package com.kryzcorp.kryzaleasus.fcf.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.kryzcorp.kryzaleasus.fcf.R;

/**
 * Created by KryzAleAsus on 29/7/2017.
 */

public class ManteleriaActivity extends Activity {
    @Override public  void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manteleria);

        Button botonAceptarCaracteristicas =(Button) findViewById(R.id.btnAceptarManteleria);
        final RadioButton crema = (RadioButton) findViewById(R.id.rbCrema);
        final RadioButton rosado = (RadioButton) findViewById(R.id.rbRosado);
        final RadioButton rojo = (RadioButton) findViewById(R.id.rbRojo);

        botonAceptarCaracteristicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemColorSeleccionado = " " ;
                Double precioTotal = 100.00;
                String costoTotal = String.valueOf(precioTotal);
                if(crema.isChecked())
                    itemColorSeleccionado = "Crema";
                if(rosado.isChecked())
                    itemColorSeleccionado = "Rosado";
                if(rojo.isChecked())
                    itemColorSeleccionado = "Rojo";
                Intent resultdata = new Intent();
                resultdata.putExtra("Test",costoTotal);
                resultdata.putExtra("Info",itemColorSeleccionado);
                resultdata.putExtra("identificador","2");
                setResult(MainActivity.RESULT_OK,resultdata);
                finish();
            }
        });
    }
}
