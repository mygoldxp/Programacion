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
public class Empleado {
    String nombre, dni;
    int edad;
    boolean casado;
    double salario;

    public Empleado() {
    }

    public Empleado(String nombre, String dni, int edad, boolean casado, double salario) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.casado = casado;
        this.salario = salario;
    }
    
    public String categoria(){
        if(edad <= 21){
            return "Principiante";
        }
        else if(edad >= 22 && edad <=35){
            return "Intermedio";
        }
        else{
            return "Senior";
        }
    }

    @Override
    public String toString() {
        return nombre + "\n" + dni + "\n" + edad + "\n" + casado + "\n" + salario + "\n";
    }
    
    public void aumentarSalario(int cantidad){
        salario = salario / 100 * cantidad + salario;
    }
    
    
}
