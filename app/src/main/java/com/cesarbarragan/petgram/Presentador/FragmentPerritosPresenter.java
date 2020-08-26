package com.cesarbarragan.petgram.Presentador;

import android.content.Context;

import com.cesarbarragan.petgram.Adaptadores.ContactoAdaptador;
import com.cesarbarragan.petgram.DataBase.ConstructorContactos;
import com.cesarbarragan.petgram.Fragments.IFrafmentPerritosView;
import com.cesarbarragan.petgram.POJO.ContactoPerritos;

import java.util.ArrayList;

public class FragmentPerritosPresenter implements IFragmentPerritosPresenter {

    private IFrafmentPerritosView iFrafmentPerritosView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<ContactoPerritos> contactoPerritos;

    public FragmentPerritosPresenter(IFrafmentPerritosView iFrafmentPerritosView, Context context) {
        this.iFrafmentPerritosView = iFrafmentPerritosView;
        this.context = context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        contactoPerritos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iFrafmentPerritosView.inicializarAdaptadorRV(iFrafmentPerritosView.CrearContactoAdaptador(contactoPerritos));
        iFrafmentPerritosView.genearLinearLayoutVertical();
    }
}
