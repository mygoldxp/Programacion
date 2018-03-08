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
public class Programador extends Empleado {
    
    int lineasDeCodigoPorHora;
    String lenguajeDominante;
    
    public Programador() {
    }

    public Programador(String nombre, String dni, int edad, boolean casado, double salario, int lineasDeCodigoPorHora, String lenguajeDominante) {
        super(nombre, dni, edad, casado, salario);
        this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
        this.lenguajeDominante = lenguajeDominante;
    }

    
    
}
