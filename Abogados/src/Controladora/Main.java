/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import javax.persistence.Persistence;
import UBD.*;
import UML.*;
import Vista.*;

/**
 *
 * @author v6222
 */
public class Main {

    private int n;
    /**
     * @param args the command line arguments
     */
    
    private static AbogadosJpaController abogadoBD;
    private static CasosJpaController casoBD;
    private static ClientesJpaController clienteBD;
    
    private static Abogados abo;
    private static Clientes clie;
    private static Casos caso;
    
    public static String abrir(int n){
        String dato = "";
        switch(n){
            case 1:
                dato = "Alta/Modificación ";
                break;
                
            case 2:
                dato = "Baja ";
                break;
                
        }
        
        return dato;
    }
    
    public static void vAbogado(int n){
        
        new Abogado(n, abrir(n));
        
    }
    
    public static void vCaso(int n){
        
        new Caso(n, abrir(n));
        
    }
    
    public static void vCliente(int n){
        
        new Cliente(n, abrir(n));
        
    }
    
    public static void vProceso(){
        
        new Lleva();
        
    }
    
    public static Abogados consultarAbogado(String dni) throws Exception{
        abo = null;
        abo = abogadoBD.findAbogados(dni);
        return abo;
    }
    
    public static void crearAbogado(String dni, String nombre, String ape1, String ape2, String dir) throws Exception{
        
        abo = new Abogados(dni, nombre, ape1, ape2, dir);
        abogadoBD.create(abo);
        
    }
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        abogadoBD = new AbogadosJpaController(Persistence.createEntityManagerFactory("AbogadosPU"));
        casoBD = new CasosJpaController(Persistence.createEntityManagerFactory("AbogadosPU"));
        clienteBD = new ClientesJpaController(Persistence.createEntityManagerFactory("AbogadosPU"));
        
        new Principal();
    }
    
}
