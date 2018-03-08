/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alta_persona;

import Modelo.Persona;
import Vista.VPrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class AltaPersona {
    
    public static ArrayList<Persona> listaPersona;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            listaPersona = new ArrayList();
            VPrincipal vd = new VPrincipal();
            vd.setVisible(true);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getClass());
        }
        
    }

    public static void crear(Persona p){
        listaPersona.add(p);
    }
    
    
}
