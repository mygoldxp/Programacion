/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.util.ArrayList;

/**
 *
 * @author 1gprogexa15
 */
public class Pelicula {
    String titulo, genero;
    ArrayList <Persona> listaActores;
    Persona guinistaEscrito;
    Persona directorDirigido;

    public Pelicula() {
    }

    public Pelicula(String titulo, String genero) {
        this.titulo = titulo;
        this.genero = genero;
        listaActores = new ArrayList();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ArrayList<Persona> getListaActores() {
        return listaActores;
    }

    public void setListaActores(ArrayList<Persona> listaActores) {
        this.listaActores = listaActores;
    }



    public Persona getGuinistaEscrito() {
        return guinistaEscrito;
    }

    public void setGuinistaEscrito(Persona guinistaEscrito) {
        this.guinistaEscrito = guinistaEscrito;
    }

    public Persona getDirectorDirigido() {
        return directorDirigido;
    }

    public void setDirectorDirigido(Persona directorDirigido) {
        this.directorDirigido = directorDirigido;
    }

    
    
}
