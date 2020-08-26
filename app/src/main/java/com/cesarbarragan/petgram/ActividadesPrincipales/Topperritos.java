package com.cesarbarragan.petgram.ActividadesPrincipales;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cesarbarragan.petgram.Adaptadores.ContactoAdaptador;
import com.cesarbarragan.petgram.POJO.ContactoPerritos;
import com.cesarbarragan.petgram.R;

import java.util.ArrayList;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Topperritos extends AppCompatActivity {

    ArrayList<ContactoPerritos> contactoPerritos;
    private RecyclerView ListadeContactos;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topperritos);


        android.widget.Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setActionBar(miActionBar);


        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getActionBar()).setDisplayHomeAsUpEnabled(true);
        

        InicializarContactos();

        ListadeContactos = (RecyclerView) findViewById(R.id.rvContactos2);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        ListadeContactos.setLayoutManager(llm);

        InicializarAdaptador();

    }

  //  public boolean onCreateOptionsMenu(Menu menu) {
  //      getMenuInflater().inflate(R.menu.menu_opciones, menu);
  //      return true;
  //  }

    public void InicializarAdaptador(){
        ContactoAdaptador contactoAdaptador = new ContactoAdaptador(contactoPerritos,this);
        ListadeContactos.setAdapter(contactoAdaptador);
    }


    public void InicializarContactos(){
        contactoPerritos = new ArrayList<>();

        //contactoPerritos.add(new ContactoPerritos("Spike", R.drawable.perrito1,0));
        //contactoPerritos.add(new ContactoPerritos("Nina", R.drawable.perrito2,1));
        //contactoPerritos.add(new ContactoPerritos("Huesito", R.drawable.perrito3,2));
        contactoPerritos.add(new ContactoPerritos("Oso", R.drawable.perrito4,3));
        contactoPerritos.add(new ContactoPerritos("Precioso", R.drawable.perrito5,4));
        contactoPerritos.add(new ContactoPerritos("Comelon", R.drawable.perrito6,5));
        contactoPerritos.add(new ContactoPerritos("Blastois", R.drawable.perrito7,6));
        contactoPerritos.add(new ContactoPerritos("Rino", R.drawable.perrito8,7));
    }

}