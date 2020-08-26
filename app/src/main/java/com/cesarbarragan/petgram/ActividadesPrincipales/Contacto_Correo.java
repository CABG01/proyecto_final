package com.cesarbarragan.petgram.ActividadesPrincipales;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toolbar;

import com.cesarbarragan.petgram.R;

import java.util.Objects;

public class Contacto_Correo extends AppCompatActivity {

    //@RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto__correo);

        android.widget.Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setActionBar(miActionBar);
        Objects.requireNonNull(getActionBar()).setDisplayHomeAsUpEnabled(true);


    }

    public void Enviarcorreo (View v){

        EditText etnombre = (EditText) findViewById(R.id.etNombre);
        EditText etcorreo = (EditText) findViewById(R.id.etCorreo);
        EditText etmensaje = (EditText) findViewById(R.id.etMensaje);



        Intent emailintent = new Intent(Intent.ACTION_SEND);
        emailintent.setData(Uri.parse("mailto:"));
        //emailintent.putExtra(Intent.EXTRA_EMAIL,etcorreo.getText().toString());
        emailintent.putExtra(Intent.EXTRA_EMAIL,"escarlet11@hotmail.com");
        emailintent.putExtra(Intent.EXTRA_CC, etcorreo.getText().toString());
        //emailintent.putExtra(Intent.ACTION_SENDTO,etcorreo.getText().toString());
        emailintent.putExtra(Intent.EXTRA_SUBJECT,"Mensaje de prueba de: "+ etnombre.getText().toString());
        emailintent.putExtra(Intent.EXTRA_TEXT, etmensaje.getText().toString());
        emailintent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailintent,"Email "));

    }

}