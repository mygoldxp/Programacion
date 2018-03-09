/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencias.Clase_Padre_Empleado_1;

/**
 *
 * @author v6222
 */
public class Operario extends Empleado{
    
    public Operario() {
        super();
    }
    
    public Operario(String Nombre) {
	super(Nombre);
	}
    

        public String toString() {
        return "Empleado " + nombre + " -> Operario";
    }
}
