package com.example.danni.sql_practica;

/**
 * Created by danni on 31/10/2017.
 */

public class Libros {
    private String libro, autor, persona, telefono;
    private int id;

    public Libros() {
    }

    public Libros(String libro, String autor, String persona, String telefono, int id) {
        this.id = id;
        this.libro = libro;
        this.autor = autor;
        this.persona = persona;
        this.telefono = telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLibro() {
        return libro;
    }

    public String getAutor() {
        return autor;
    }

    public String getPersona() {
        return persona;
    }

    public String getTelefono() {
        return telefono;
    }
}
