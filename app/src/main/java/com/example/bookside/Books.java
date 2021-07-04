package com.example.bookside;

import java.io.Serializable;

public class Books implements Serializable {
    public int id;
    public  int Desc;
    public String titulo;
    public String Autor;
    public int portada;


    public Books(int id, int desc, String titulo, String autor, int portada) {
        this.id = id;
        Desc = desc;
        this.titulo = titulo;
        Autor = autor;
        this.portada = portada;
    }


    public int getDesc() {
        return Desc;
    }

    public void setDesc(int desc) {
        Desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public int getPortada() {
        return portada;
    }

    public void setPortada(int portada) {
        this.portada = portada;
    }
}
