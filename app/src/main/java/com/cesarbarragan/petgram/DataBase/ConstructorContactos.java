package com.cesarbarragan.petgram.DataBase;

import android.content.ContentValues;
import android.content.Context;

import com.cesarbarragan.petgram.POJO.ContactoPerritos;
import com.cesarbarragan.petgram.R;

import java.util.ArrayList;

public class ConstructorContactos {

    private static final int Like=1;
    private Context context;
    public ConstructorContactos (Context context){
        this.context = context;
    }

    public ArrayList<ContactoPerritos> obtenerDatos(){
       /* ArrayList<ContactoPerritos> contactoPerritos = new ArrayList<>();

        contactoPerritos.add(new ContactoPerritos("Spike", R.drawable.perrito1,0));
        contactoPerritos.add(new ContactoPerritos("Nina", R.drawable.perrito2,1));
        contactoPerritos.add(new ContactoPerritos("Huesito", R.drawable.perrito3,2));
        contactoPerritos.add(new ContactoPerritos("Oso", R.drawable.perrito4,3));
        contactoPerritos.add(new ContactoPerritos("Precioso", R.drawable.perrito5,4));
        contactoPerritos.add(new ContactoPerritos("Comelon", R.drawable.perrito6,5));
        contactoPerritos.add(new ContactoPerritos("Blastois", R.drawable.perrito7,6));
        contactoPerritos.add(new ContactoPerritos("Rino", R.drawable.perrito8,7));
        return contactoPerritos;*/

       BaseDatos db = new BaseDatos(context);
       insertarContacto(db);
       return db.ObtenerTodosLosContactos();

    }

    public void insertarContacto (BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.Tabla_Contactos_Nombre, "Spike");
        contentValues.put(ConstantesBaseDatos.Tabla_contactos_Foto, R.drawable.perrito1);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.Tabla_Contactos_Nombre, "Nina");
        contentValues.put(ConstantesBaseDatos.Tabla_contactos_Foto, R.drawable.perrito2);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.Tabla_Contactos_Nombre, "Huesito");
        contentValues.put(ConstantesBaseDatos.Tabla_contactos_Foto, R.drawable.perrito3);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.Tabla_Contactos_Nombre, "Oso");
        contentValues.put(ConstantesBaseDatos.Tabla_contactos_Foto, R.drawable.perrito4);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.Tabla_Contactos_Nombre, "Precioso");
        contentValues.put(ConstantesBaseDatos.Tabla_contactos_Foto, R.drawable.perrito5);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.Tabla_Contactos_Nombre, "Comelon");
        contentValues.put(ConstantesBaseDatos.Tabla_contactos_Foto, R.drawable.perrito6);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.Tabla_Contactos_Nombre, "Blastois");
        contentValues.put(ConstantesBaseDatos.Tabla_contactos_Foto, R.drawable.perrito7);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.Tabla_Contactos_Nombre, "Rino");
        contentValues.put(ConstantesBaseDatos.Tabla_contactos_Foto, R.drawable.perrito8);
        db.insertarContacto(contentValues);

    }


    public void darLike (ContactoPerritos contactoPerritos){

        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.Tabla_Likes_ID_Contactos, contactoPerritos.getId());
        contentValues.put(ConstantesBaseDatos.Tabla_Likes_Numero_Likes, Like);
        db.insertarLike(contentValues);

    }

    public int obtenerLike (ContactoPerritos contactoPerritos){

        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikes(contactoPerritos);

    }

}
