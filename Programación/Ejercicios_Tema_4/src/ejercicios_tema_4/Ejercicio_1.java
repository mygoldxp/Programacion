
package ejercicios_tema_4;

import java.util.Arrays;
import javax.swing.JOptionPane;


public class Ejercicio_1 {
    
    static int x = 10;
    public static void Ejercicio1(){
        float miArray [] = new float [x];
        for(int c = 0; c<x; c++){
            int v=0;
            do{
                v=1;
                try{
                    miArray[c] = Float.parseFloat(JOptionPane.showInputDialog("Intro número:"));
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "El valor ha de ser numérico.");
                    v=0;
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getClass() + e.getMessage());
                    v=0;
                }
            }
            while(v!=1);
        }
        Arrays.sort(miArray);
        JOptionPane.showMessageDialog(null, "El número mayor es " + miArray[x-1] + " y el número menor es " + miArray[0] + ".");
    }
}
