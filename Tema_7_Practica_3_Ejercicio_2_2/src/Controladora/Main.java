/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import GUI.Principal;
import UML.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jon
 */
public class Main {

    public static ArrayList<Cliente> listaCliente;
    
    public static Cliente cliente;
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        listaCliente = new ArrayList();
        Principal prin = new Principal();
        prin.setVisible(true);
    }
    
    public static void agregar(String nombre, String apellidos, String telefono, String correo, boolean familia){
        cliente = new Cliente(nombre, apellidos, telefono, correo, familia);
        listaCliente.add(cliente);
    }
    
    public static void agregarH(String nombre, String fecha){
        Hijos hijo = new Hijos(nombre, fecha);
        cliente.setHijos(hijo);
    }
    
    public static void completado(javax.swing.JFrame ventana){
        ventana.dispose();
        JOptionPane.showMessageDialog(null, "Inscripción Completada.");
        ventana = new Principal();
        ventana.setVisible(true);
    }
    
    public static void ver(javax.swing.JFrame ventana){
        ventana.dispose();
        
        String dato = "";
        String familia = "";
        
        for(Cliente e : listaCliente){
            if(e.isTipoFamilia()){
                familia = "Familiar";
            }
            else{
                familia = "Individual";
            }
            
            dato += "\n" + e.getNombre() + ", " + e.getApellidos() + ", " + e.getTelefono() + ", " + e.getEmail() + ", " + familia + "\n";
            dato = e.getHijos().stream().map((h) -> "--->" + h.getNombre() + ", " + h.getFecha() + "\n").reduce(dato, String::concat);
        }
        System.out.print("Datos:" + dato );
        System.exit(0);
    }
    
}
