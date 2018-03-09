package Herencias.Clase_Padre_Empleado_1;

import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class Empleado {
    
    protected String nombre;
    
    public Empleado(){
       
    }
    public String devolver(){
        String x = "Empleado " + nombre;
        return x;
    }
    public Empleado(String nombre){
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return "Empleado " + nombre;
    }
    
}
