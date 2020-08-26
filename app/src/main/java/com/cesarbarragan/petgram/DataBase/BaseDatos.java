package com.cesarbarragan.petgram.DataBase;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.cesarbarragan.petgram.POJO.ContactoPerritos;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.Nombre_BaseDatos, null, ConstantesBaseDatos.Version_BaseDatos);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String querryCrearTablaContacto = "CREATE TABLE "   + ConstantesBaseDatos.Tabla_Contactos + "(" +
                ConstantesBaseDatos.Tabla_Contactos_ID      + " INTEGER PRIMARY KEY," +
                ConstantesBaseDatos.Tabla_Contactos_Nombre  + " TEXT, " +
                ConstantesBaseDatos.Tabla_contactos_Foto    + " INTEGER " +
                ")";

        String querryCrearTablaLikes = "CREATE TABLE " + ConstantesBaseDatos.Tabla_Likes + "(" +
                ConstantesBaseDatos.Tabla_Likes_ID              + " INTEGER PRIMARY KEY," +
                ConstantesBaseDatos.Tabla_Likes_ID_Contactos    + " INTEGER, " +
                ConstantesBaseDatos.Tabla_Likes_Numero_Likes    + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.Tabla_Likes_ID_Contactos + ") " +
                "REFERENCES " + ConstantesBaseDatos.Tabla_Contactos + "(" +ConstantesBaseDatos.Tabla_Contactos_ID +")"+
        ")";


        sqLiteDatabase.execSQL(querryCrearTablaContacto);
        sqLiteDatabase.execSQL(querryCrearTablaLikes);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.Tabla_Contactos);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.Tabla_Likes);
        onCreate(sqLiteDatabase);

    }

    public ArrayList<ContactoPerritos> ObtenerTodosLosContactos (){

        ArrayList<ContactoPerritos> contactoPerritos = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.Tabla_Contactos;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery (query, null);

        while (registros.moveToNext()){
            ContactoPerritos contactoActual = new ContactoPerritos();
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombrePerrito(registros.getString(1));
            contactoActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT (" + ConstantesBaseDatos.Tabla_Likes_Numero_Likes + ") as likes " +
                    " FROM " + ConstantesBaseDatos.Tabla_Likes +
                    " WHERE " + ConstantesBaseDatos.Tabla_Likes_ID_Contactos + "=" + contactoActual.getId();



            Cursor registroLikes = db.rawQuery(queryLikes,null);
            if (registroLikes.moveToNext()){
                contactoActual.setLikes(registroLikes.getInt(0));
            } else {
                contactoActual.setLikes(0);
            }

            contactoPerritos.add(contactoActual);

        }

        db.close();

        return contactoPerritos;

    }


    public void insertarContacto (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.Tabla_Contactos,null,contentValues);
        db.close();

    }


    public void insertarLike (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.Tabla_Likes,null,contentValues);
        db.close();

    }

    public int obtenerLikes (ContactoPerritos contactoPerritos){
        int Likes = 0;

        String query = "SELECT COUNT (" + ConstantesBaseDatos.Tabla_Likes_Numero_Likes + ")" +
                " FROM " + ConstantesBaseDatos.Tabla_Likes +
                " WHERE " + ConstantesBaseDatos.Tabla_Likes_ID_Contactos + "=" + contactoPerritos.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        if (registros.moveToNext()){

            Likes=registros.getInt(0);

        }

        db.close();

        return  Likes;

    }

}
