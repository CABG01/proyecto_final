package com.cesarbarragan.petgram.Fragments;

import com.cesarbarragan.petgram.Adaptadores.ContactoAdaptador;
import com.cesarbarragan.petgram.POJO.ContactoPerritos;

import java.util.ArrayList;

public interface IFrafmentPerritosView {

    public void genearLinearLayoutVertical ();

    public ContactoAdaptador CrearContactoAdaptador (ArrayList<ContactoPerritos> contactoPerritos);

    public void inicializarAdaptadorRV (ContactoAdaptador adaptador);

}
