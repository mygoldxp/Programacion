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
public class Teatro {
    
    int idTeatro;
    String nombre, direccion;
    boolean estado;
    ArrayList <Obra> listaObra;

    public Teatro() {
    }

    public Teatro(int idTeatro, String nombre, String direccion, boolean estado) {
        this.idTeatro = idTeatro;
        this.nombre = nombre;
        this.direccion = direccion;
        this.estado = estado;
        listaObra = new ArrayList();
    }

    public int getIdTeatro() {
        return idTeatro;
    }

    public void setIdTeatro(int idTeatro) {
        this.idTeatro = idTeatro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ArrayList<Obra> getListaObra() {
        return listaObra;
    }

    public void setListaObra(Obra obra) {
        listaObra.add(obra);
    }

    
    
    
}
