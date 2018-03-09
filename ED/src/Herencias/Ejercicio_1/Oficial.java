/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencias.Ejercicio_1;

/**
 *
 * @author v6222
 */
public class Oficial extends  Operario {
    
    public Oficial() {
	super();
    }
    
    public Oficial(String Nombre) {
	super(Nombre);
}
    
        public String toString() {
        return "Empleado " + nombre + " -> Oficial";
    }
}
