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
public class Operario extends Empleado {

    public Operario() {
    }

    public Operario(String nombre) {
        super(nombre);
    }
    
    @Override
    public String toString() {
        return super.toString() + "-> Operario";
    }
}
