/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios_Tema_6_Relaciones;

import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class Ejercicios_Tema_6_Relaciones {
    public static void main(String[] args) {
        boolean continuar = true;
        do{
            try{
                String y = JOptionPane.showInputDialog("Ejercicio:");
                if(y.equals("") || y.isEmpty()){
                    continuar = false;
                }
                else{
                    int x = Integer.parseInt(y);
                    switch(x) {
                        case 1:
                            Ejercicio_1.Ejercicio1();
                            break;
                        case 2:
                            //Ejercicio_2.Ejercicio2();
                            break;
                        case 3:
                            //Ejercicio_3.Ejercicio3();
                            break;
                        case 4:
                            //Ejercicio_4.Ejercicio4();
                            break;
                        
                        default:
                            continuar= false;
                            break;
                    }
                }        
            }
            catch( NullPointerException e){
                continuar = false;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El valor ha de ser numérico.");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Hay un error " + e.getCause());
            }
        }
        while(continuar);
    }
}
