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
public class Analista extends Empleado{
    
    int personasACargo;

    public Analista() {
    }

    public Analista(String nombre, String dni, int edad, boolean casado, double salario, int personasACargo) {
        super(nombre, dni, edad, casado, salario);
        this.personasACargo = personasACargo;
    }
    
    @Override
    public void aumentarSalario(int cantidad){
        salario = salario / 100 * (cantidad+5) + salario;
    }
    
    
}
