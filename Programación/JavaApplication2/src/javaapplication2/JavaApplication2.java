/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import javax.swing.JOptionPane;
/**
 *
 * @author v6222
 */
public class JavaApplication2 {
    private static String str="";
    private static int n=0;
    private static boolean p=false;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            n = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el nÃºmero."));
    str=JOptionPane.showInputDialog(null, "Â¿Quieres demostrar el ejercicio 21 o el 22?");
    if (str.equalsIgnoreCase("21")) Ej21();

    else if (str.equalsIgnoreCase("22")) Ej22();
    }
    public static void Ej21() {
        
        Engine();
        JOptionPane.showMessageDialog(null, p);
        if (p==true) 
        {
            JOptionPane.showMessageDialog(null, "Tu nÃºmero es primo!");
                    }
        else {JOptionPane.showMessageDialog(null, "Tu numero no es primo.");}
    }
    
    public static void Ej22() {
        
    }
    
    public static void Engine() {
        int cnt=2;
        boolean f=false;
        p=false;
        do
        {
            
            if ((n%cnt) == 0) f=true;
            else f=true;
            cnt++;
        } while (cnt<n);
        if (f==false) p=true;
    }
}
