/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class Persona {

    /**
     * @param args the command line arguments
     */
    public void main(String[] args) {
        Personas Persona1 = new Personas("Marron", "Negro", 173d, 75d, "Alex","jajaja", 15);
        
        Personas Persona2 = new Personas("Blanco", "Negro", 170d, 80d, "Unai","Puelles López", 18);
        
        String nombre1= Persona1.getNombre();
        String nombre2= Persona2.getNombre();
        JOptionPane.showMessageDialog(null, nombre1 + nombre2);

        
        String dato = JOptionPane.showInputDialog("Intro fecha:");
                if(hol(dato)== true){
                JOptionPane.showMessageDialog(null, "ok");
                }else{
                JOptionPane.showMessageDialog(null, "jaja");
                }
                
        
    }
 public static boolean funcionar(){
     String gg="holal";
        try{
        JOptionPane.showMessageDialog(null, gg.charAt(4));
        SimpleDateFormat fecha = new SimpleDateFormat();
        fecha.setLenient(false);
        fecha.parse(gg);
    }
    catch(Exception e){
        return false;
    }
    return true;
 }   
 
 
 
 public static boolean hol(String entrada){
     SimpleDateFormat nunca = new SimpleDateFormat();
     nunca.setLenient(false);

     try{
          nunca.parse(entrada);
          
     }
     catch(Exception e){
        return false;
         
     }
    return true;
    
}
}
