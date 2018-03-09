/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturatxt;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Jon
 */
public class LecturaTXT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            boolean salir = true, agregar = false;
            String fila, dato ="", nombre = "persona";
            FileReader fr = new FileReader("src/dato.xml");
            BufferedReader br = new BufferedReader(fr);
            while ((fila = br.readLine())!=null && salir) {
                if(fila.equals("<" + nombre + ">")){
                    agregar = true;
                    fila = "";
                }
                else if(fila.equals("</" + nombre + ">")){
                    agregar = false;
                }
                if(agregar){
                    dato += fila + " ";
                }
            }
            JOptionPane.showMessageDialog(null, dato);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getClass());
        }
        
    }
    
}
