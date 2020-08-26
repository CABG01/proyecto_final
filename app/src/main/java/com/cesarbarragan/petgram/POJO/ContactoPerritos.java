package com.cesarbarragan.petgram.POJO;

public class ContactoPerritos {

    private int id;
    private String nombrePerrito;
    private int likes;
    private int foto;


    public ContactoPerritos(String nombrePerrito, int foto, int likes) {
        this.nombrePerrito = nombrePerrito;
        this.foto = foto;
        this.likes = likes;
    }

    public ContactoPerritos() {

    }

    public String getNombrePerrito() {
        return nombrePerrito;
    }

    public void setNombrePerrito(String nombrePerrito) {
        this.nombrePerrito = nombrePerrito;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
