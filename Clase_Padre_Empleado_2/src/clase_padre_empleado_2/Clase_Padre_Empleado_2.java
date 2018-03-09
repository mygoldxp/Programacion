/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase_padre_empleado_2;

import UML.Analista;
import UML.Empleado;
import UML.Programador;

/**
 *
 * @author Jon
 */
public class Clase_Padre_Empleado_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Empleado E1 = new Empleado("Rafa", "11111111A", 30, true, 1500d);
        Programador D1 = new Programador("Rafa", "11111111A", 30, true, 1500d, 100, "Java");
        Analista OP1 = new Analista("Rafa", "11111111A", 30, true, 1500d, 5);
        
        E1.aumentarSalario(10);
        System.out.println(E1);
        D1.aumentarSalario(10);
        System.out.println(D1);
        OP1.aumentarSalario(10);
        System.out.println(OP1);
    }
    
}
