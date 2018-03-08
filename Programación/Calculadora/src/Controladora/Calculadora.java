/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Vista.calculadora;
import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class Calculadora {

    private static double total=0;
    private static int y = 0;
    private static calculadora calc;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        calc = new calculadora();
        calc.setVisible(true);
    }
    
    public static double calcular(double valor, int x){
        double fin=0;
        switch(y){
            case 0:
                total = valor;
                break;
            case 1:
                if(total == 0){
                    total = valor;
                }
                else{
                    total = total + valor;
                }
                break;
            case 2:
                if(total == 0){
                    total = valor;
                }
                else{
                    total = total - valor;
                }
                break;
            case 3:
                if(total == 0){
                    total = valor;
                }
                else{
                    total = total * valor;
                }
                break;
            case 4:
                if(total == 0){
                    total = valor;
                }
                else{
                    total = total / valor;
                }
                break;
            case 5:
                
                break;
            
        }
        y = x;
        if(y==5){
            fin = total;
        }
        return total;
    }
}
