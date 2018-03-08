/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

/**
 *
 * @author Jon
 */
public class Cliente extends Persona {
    String telefono;

    public Cliente() {
    }

    public Cliente(String telefono) {
        this.telefono = telefono;
    }

    public Cliente(String telefono, int cod, String nombre, String apellidos) {
        super(cod, nombre, apellidos);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    
}
