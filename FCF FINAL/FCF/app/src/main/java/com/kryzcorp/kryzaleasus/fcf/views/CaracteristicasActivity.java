package com.kryzcorp.kryzaleasus.fcf.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.kryzcorp.kryzaleasus.fcf.R;

/**
 * Created by KryzAleAsus on 29/7/2017.
 */

public class CaracteristicasActivity extends Activity {
    @Override public  void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracteristicas);

        Button botonAceptarCaracteristicas =(Button) findViewById(R.id.btnAceptarCaracteristicas);
        final EditText numeroSillas = (EditText) findViewById(R.id.txtNumeroSillas);
        final EditText numeroMesas = (EditText) findViewById(R.id.txtNumeroMesas);
        final RadioButton salon1 = (RadioButton) findViewById(R.id.rbSalon1);
        final RadioButton horario1 = (RadioButton) findViewById(R.id.rbHorario1);


        botonAceptarCaracteristicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemSalonSeleccionado ;
                String itemHorarioSeleccionado;
                Double precioTotal = Double.parseDouble(numeroMesas.getText().toString()) * 0.75 + Double.parseDouble(numeroSillas.getText().toString()) * 1.0;
                String costoTotal = String.valueOf(precioTotal);
                if(salon1.isChecked())
                    itemSalonSeleccionado = "Salon 1";
                else
                    itemSalonSeleccionado = "Salon 2";
                if(horario1.isChecked())
                    itemHorarioSeleccionado = "Horario 1";
                else
                    itemHorarioSeleccionado = "Horario 2";
                String informacionSeleccionada = "Numero de sillas: "+numeroSillas.getText().toString()+"\nNumero de Mesas: "+numeroMesas.getText().toString()+"\nSalon y Horario Seleccionado:\n"+itemSalonSeleccionado+","+itemHorarioSeleccionado;
                Intent resultdata = new Intent();
                resultdata.putExtra("Test",costoTotal);
                resultdata.putExtra("Info",informacionSeleccionada);
                resultdata.putExtra("identificador","1");
                setResult(MainActivity.RESULT_OK,resultdata);
                finish();
            }
        });

    }
}
