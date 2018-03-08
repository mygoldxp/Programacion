/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.util.ArrayList;

/**
 *
 * @author v6222
 */
public class Obra {
    
    int idObra;
    String nombre;
    Director director;
    ArrayList <Actuacion> listaActuacion;

    public Obra() {
    }

    public Obra(int idObra, String nombre, Director director) {
        this.idObra = idObra;
        this.nombre = nombre;
        this.director = director;
        listaActuacion = new ArrayList();
    }

    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public ArrayList<Actuacion> getListaActuacion() {
        return listaActuacion;
    }

    public void setListaActuacion(Actuacion actuacion) {
        listaActuacion.add(actuacion);
    }


    
    
        
}
