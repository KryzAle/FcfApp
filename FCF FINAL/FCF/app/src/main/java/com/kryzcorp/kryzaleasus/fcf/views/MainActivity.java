package com.kryzcorp.kryzaleasus.fcf.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kryzcorp.kryzaleasus.fcf.R;
import com.kryzcorp.kryzaleasus.fcf.controllers.MainController;
import com.kryzcorp.kryzaleasus.fcf.interfaces.IApplicationListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.BufferUnderflowException;

import de.hdodenhof.circleimageview.CircleImageView;

import static java.net.Proxy.Type.HTTP;

public class MainActivity extends AppCompatActivity {
    private MainController mMainController;
    double precioTotalReserva=00.00;
    String informaciondeCliente= " ";
    String informaciondeCaracteristicas = " ";
    String informaciondeManteleria = " ";
    String informaciondePlatillos = " ";
    String informaciondeServicios = " ";
    String informaciondeDecoracion = " ";
    Integer tipoLogin=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView precioTotal = (TextView) findViewById(R.id.txtCostoTotal);
        String precio = String.valueOf(precioTotalReserva);
        precioTotal.setText(precio);
        final TextView textViewName = (TextView)findViewById(R.id.text_view_user_name);
        final CircleImageView imageViewPhoto = (CircleImageView)findViewById(R.id.image_view_user_photo);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btnEnviar);

        final CheckBox cbCaracteristicas = (CheckBox) findViewById(R.id.cbCaracteristicas);
        final CheckBox cbManteleria = (CheckBox) findViewById(R.id.cbManteleria);
        final CheckBox cbPlatillo = (CheckBox) findViewById(R.id.cbPlatillos);
        final CheckBox cbServicios = (CheckBox) findViewById(R.id.cbServicios);
        final CheckBox cbDecoracion = (CheckBox) findViewById(R.id.cbDecoracion);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbCaracteristicas.isChecked() && cbManteleria.isChecked() && cbPlatillo.isChecked() && cbPlatillo.isChecked() && cbServicios.isChecked() && cbDecoracion.isChecked() ){
                    informaciondeCaracteristicas = informaciondeCliente+"\nCaracteristicas Generales: \n"+informaciondeCaracteristicas+"\nColor de Manteleria: "+informaciondeManteleria+
                            "\nPlatillos Seleccionados: \n"+informaciondePlatillos+"\nServicios Seleccionados: "+informaciondeServicios+"\nDecoracion seleccionada: "+informaciondeDecoracion;
                    try {
                        crearFichero(informaciondeCaracteristicas);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setData(Uri.parse("mailto:"));
                    emailIntent.setType("text/plain");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[] {"saloneventosfcf@hotmail.com"});
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT,"RESERVA");
                    emailIntent.putExtra(Intent.EXTRA_TEXT,informaciondeCaracteristicas);
                    startActivity(Intent.createChooser(emailIntent,"Enviar Correo/Guardar en Archivo"));
                }
                else{
                    generarToast("Datos incompletos");
                }

            }
        });
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        if(extras == null) {
            this.mMainController = new MainController(new IApplicationListener() {
                @Override
                public void onTaskCompleted() {
                    textViewName.setText("Bienvenido: " + MainActivity.this.mMainController.getUserName());
                    Glide.with(MainActivity.this).load(MainActivity.this.mMainController.getUserPhoto()).dontAnimate().into(imageViewPhoto);
                    informaciondeCliente = "Hola, mi nombre de usuario de Facebook es: "+MainActivity.this.mMainController.getUserName()+"\nEstoy haciendo " +
                            "una reserva con la siguiente informacion:\n";
                }

                @Override
                public void onFailedToCompleteTask(String error) {
                    Toast.makeText(MainActivity.this, getString(R.string.error_message) + error, Toast.LENGTH_LONG).show();
                }
            });
        }
        else
        {
            String nombre = extras.getString("name");
            String mail = extras.getString("mail");
            String tlf = extras.getString("tlf");
            String direc = extras.getString("direccion");
            generarToast("Bienvenido: "+nombre);
            textViewName.setText("Bienvenido: "+nombre);
            informaciondeCliente = "Hola, mi nombre es: "+nombre+"\nMi informacion de contacto es:\nDireccion de correo: "+mail+"\nTelefono: "+tlf+"\nDireccion: "+direc+"\nEstoy haciendo " +
                    "una reserva con la siguiente informacion:\n";
            tipoLogin=1;
        }
    }
    public void generarToast(String mensaje){
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
    }

    public void onLogOutButtonClick( View view ){
        if (tipoLogin==0)
        logOut();
        else
            finish();
    }

    @Override
    public void onBackPressed(){

        logOut();

    }

    private void logOut(){

        this.mMainController.logOut();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();

    }
    public void lanzarCaracteristicas(View view){
        Intent i = new Intent(this,CaracteristicasActivity.class);
        startActivityForResult(i,0);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            TextView precioTotal = (TextView) findViewById(R.id.txtCostoTotal);
            String retornado = data.getStringExtra("Test");
            String retornado2 = data.getStringExtra("Info");
            String retornado3 = data.getStringExtra("identificador");
            Integer identify = Integer.parseInt(retornado3);
            Double valorRetornado = Double.parseDouble(retornado);
            precioTotalReserva = precioTotalReserva + valorRetornado;
            retornado = String.valueOf(precioTotalReserva);
            precioTotal.setText("$"+retornado);
            switch (identify) {
                case 1:
                    Toast.makeText(this, retornado2, Toast.LENGTH_LONG).show();
                    informaciondeCaracteristicas = retornado2;
                    Button btnCaracteristicas = (Button) findViewById(R.id.btnCaracteristicas);
                    CheckBox cbCaracteristicas = (CheckBox) findViewById(R.id.cbCaracteristicas);
                    btnCaracteristicas.setEnabled(false);
                    cbCaracteristicas.setChecked(true);
                    break;
                case 2:
                    Toast.makeText(this, retornado2, Toast.LENGTH_LONG).show();
                    informaciondeManteleria = retornado2;
                    Button btnManteleria = (Button) findViewById(R.id.btnManteleria);
                    CheckBox cbManteleria = (CheckBox) findViewById(R.id.cbManteleria);
                    btnManteleria.setEnabled(false);
                    cbManteleria.setChecked(true);
                    break;
                case 3:
                    Toast.makeText(this, retornado2, Toast.LENGTH_LONG).show();
                    informaciondePlatillos = retornado2;
                    Button btnPlatillos = (Button) findViewById(R.id.btnPlatillos);
                    CheckBox cbPlatillos = (CheckBox) findViewById(R.id.cbPlatillos);
                    btnPlatillos.setEnabled(false);
                    cbPlatillos.setChecked(true);
                    break;
                case 4:
                    Toast.makeText(this, retornado2, Toast.LENGTH_LONG).show();
                    informaciondeServicios = retornado2;
                    Button btnServicios = (Button) findViewById(R.id.btnServicios);
                    CheckBox cbServicios = (CheckBox) findViewById(R.id.cbServicios);
                    btnServicios.setEnabled(false);
                    cbServicios.setChecked(true);
                    break;
                case 5:
                    Toast.makeText(this, retornado2, Toast.LENGTH_LONG).show();
                    informaciondeDecoracion = retornado2;
                    Button btnDecoracion = (Button) findViewById(R.id.btnDecoracion);
                    CheckBox cbDecoracion = (CheckBox) findViewById(R.id.cbDecoracion);
                    btnDecoracion.setEnabled(false);
                    cbDecoracion.setChecked(true);
                    break;
            }
        }
    }
    public void lanzarManteleria(View view){
        Intent i = new Intent(this,ManteleriaActivity.class);
        startActivityForResult(i,1);

    }
    public void lanzarPlatillos(View view){
        Intent i = new Intent(this,PlatillosActivity.class);
        startActivityForResult(i,2);
    }
    public void lanzarServicios(View view){
        Intent i = new Intent(this,ServiciosActivity.class);
        startActivityForResult(i,3);
    }
    public void lanzarDecoracion(View view){
        Intent i = new Intent(this,DecoracionActivity.class);
        startActivityForResult(i,4);
    }

    public void crearFichero(String informacionFinal) throws IOException {

        FileOutputStream outputStream = null;
        File file = new File("reservacion.txt");

        try {
            outputStream = openFileOutput("reservacion.txt",MODE_PRIVATE);
            outputStream.write (informacionFinal.getBytes());
            Toast.makeText(this,"Exito Creando el archivo", Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
        }
    }
}
