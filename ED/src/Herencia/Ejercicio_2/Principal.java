/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.Ejercicio_2;

import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class Principal {
    
    public static void main(String args[]){
        
        Empleado empleado1 = new Empleado("Jon","DNI234", 28, false, 100.99);
        Analista analista1 = new Analista("Unai", "DNI8888", 18, false, 10, 5);
        Programador programador1 = new Programador("Alex", "DNI2222", 19, true, 9, 12,"Java");
        
        JOptionPane.showMessageDialog(null, empleado1);
        JOptionPane.showMessageDialog(null, analista1);
        JOptionPane.showMessageDialog(null, programador1);
        analista1.Aumento(Double.parseDouble(JOptionPane.showInputDialog("% de aumento:")));
        JOptionPane.showMessageDialog(null, analista1);
        
    }
    
}
