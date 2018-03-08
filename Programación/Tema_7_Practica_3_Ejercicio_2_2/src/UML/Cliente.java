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
public class Cliente {
    
    String nombre, apellidos, telefono, email;
    boolean tipoFamilia;
    ArrayList <Hijos> hijos;

    public Cliente() {
    }
    
    public Cliente(String nombre, String apellidos, String telefono, String email, boolean tipoFamilia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.tipoFamilia = tipoFamilia;
        hijos = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isTipoFamilia() {
        return tipoFamilia;
    }

    public void setTipoFamilia(boolean tipoFamilia) {
        this.tipoFamilia = tipoFamilia;
    }


    public ArrayList<Hijos> getHijos() {
        return hijos;
    }

    public void setHijos(Hijos hijos) {
        this.hijos.add(hijos);
    }
}
