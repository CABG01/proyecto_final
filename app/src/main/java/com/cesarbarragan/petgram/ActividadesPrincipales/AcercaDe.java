package com.cesarbarragan.petgram.ActividadesPrincipales;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toolbar;

import com.cesarbarragan.petgram.R;

import java.util.Objects;

public class AcercaDe extends AppCompatActivity {

    //@RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        android.widget.Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setActionBar(miActionBar);
        Objects.requireNonNull(getActionBar()).setDisplayHomeAsUpEnabled(true);


    }
}