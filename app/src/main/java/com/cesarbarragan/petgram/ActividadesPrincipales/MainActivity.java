package com.cesarbarragan.petgram.ActividadesPrincipales;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import com.cesarbarragan.petgram.Adaptadores.ViewFragmentAdapter;
import com.cesarbarragan.petgram.Fragments.FragmentDetallePerritos;
import com.cesarbarragan.petgram.Fragments.FragmentPerritos;
import com.cesarbarragan.petgram.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private TabLayout tabLayout;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        android.widget.Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setActionBar(miActionBar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        setUpViewPager();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.mContacto:
                Intent x = new Intent(this, Contacto_Correo.class);
                startActivity(x);
                break;

            case R.id.mAcercaDe:
                Intent y = new Intent(this, AcercaDe.class);
                startActivity(y);
                break;

                /*
            case R.id.mTopPerritos:
                Intent Intent = new Intent(this, Topperritos.class);
                startActivity(Intent);
                break;

                 */

        }
        return super.onOptionsItemSelected(item);
    }


    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new FragmentPerritos());
        fragments.add(new FragmentDetallePerritos());

        return fragments;
    }

    public void setUpViewPager (){

        viewPager.setAdapter(new ViewFragmentAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_dog_hose);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog_face);

    }


    public void IraSegundaActividad (View v){
        Intent Intent = new Intent(this, Topperritos.class);
        startActivity(Intent);
}




}