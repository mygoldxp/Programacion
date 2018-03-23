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
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

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
    private static Llevar llevaBD;
    
    private static Abogados abo;
    private static Clientes clie;
    private static Casos caso;
    
    private static ArrayList <Abogados> listaAbogado;
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
    
    public static void vProceso(int n){
        
        new Lleva(n, abrir(n));
        
    }
    
    public static void vBuscar(int n){
        
        new Buscar(n);
        
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
    
    public static void modificarAbogado(String dni, String nombre, String ape1, String ape2, String dir) throws Exception{
        
        abo = new Abogados(dni, nombre, ape1, ape2, dir);
        //abogadoBD.edit(abo);
        abogadoBD.editar(abo);
        
    }
    
    public static void eliminarAbogado(String dni) throws Exception{
        
        abogadoBD.destroy(dni);
        
    }
    
    public static Clientes consultarCliente(String dni) throws Exception{
        clie = null;
        clie = clienteBD.findClientes(dni);
        return clie;
    }
    
    public static void crearCliente(String dni, String nombre, String ape1, String ape2, String dir, String tel) throws Exception{
        
        clie = new Clientes(dni, nombre, ape1, ape2, dir, tel);
        clienteBD.create(clie);
        
    }
    
    public static void modificarCliente(String dni, String nombre, String ape1, String ape2, String dir, String tel) throws Exception{
        
        clie = new Clientes(dni, nombre, ape1, ape2, dir, tel);
        //clienteBD.edit(clie);
        clienteBD.editar(clie);
    }
    
    public static void eliminarCliente(String dni) throws Exception{
        
        clienteBD.destroy(dni);
        
    }
    
    public static Casos consultarCaso(String numero) throws Exception{
        caso = null;
        caso = casoBD.findCasos(numero);
        return caso;
    }
    
    public static void crearCaso(String numero, Date fechaI, Date fechaF, String estado) throws Exception{
        caso = new Casos(numero, fechaI, fechaF, estado, clie);
        casoBD.create(caso);
        
    }
    
    public static void modificarCaso(String numero, Date fechaI, Date fechaF, String estado) throws Exception{
        caso = new Casos(numero, fechaI, fechaF, estado, clie);
        //casoBD.edit(caso);
        casoBD.editar(caso);
    }
    
    public static void eliminarCaso(String numero) throws Exception{
        
        casoBD.destroy(numero);
        
    }
    
    public static void consultarLlevar(Casos caso) throws Exception{
        listaAbogado = new ArrayList();
        listaAbogado = llevaBD.buscarListaAbogados(caso); 
    }
       
    public static void annadirLlevarAbogado(){
        llevaBD.annadirAbogado(abo, caso);
    }
    
    public static void eliminarLlevarAbogado(){
        llevaBD.quitarAbogado(abo, caso);
    }
      
    public static ArrayList <Abogados> listarAbogado(String dni, String nombre, String ape1, String ape2 ) throws Exception{
        listaAbogado = new ArrayList();
        abo = new Abogados(dni, nombre, ape1, ape2, "");
        listaAbogado = abogadoBD.buscarListaAbogados(abo); 
        return listaAbogado;
    }
    
    public static ArrayList <Clientes> listarClientes(String dni, String nombre, String ape1, String ape2, String telf ) throws Exception{
        ArrayList <Clientes> lClie = new ArrayList();
        clie = new Clientes(dni, nombre, ape1, ape2, "", telf);
        listaAbogado = clienteBD.buscarListaAbogados(clie); 
        return lClie;
    }
    
    public static ArrayList <Casos> listarCasos(String exp, String estado) throws Exception{
        ArrayList <Casos> lCaso = new ArrayList();
        caso = new Casos(exp, estado);
        listaAbogado = llevaBD.buscarListaAbogados(caso); 
        return lCaso;
    }
    
    public static void cerrar(JDialog dato){
        dato.dispose();
    }

    public static Llevar getLlevaBD() {
        return llevaBD;
    }

    public static void setLlevaBD(Llevar llevaBD) {
        Main.llevaBD = llevaBD;
    }

    public static Abogados getAbo() {
        return abo;
    }

    public static void setAbo(Abogados abo) {
        Main.abo = abo;
    }

    public static Clientes getClie() {
        return clie;
    }

    public static void setClie(Clientes clie) {
        Main.clie = clie;
    }

    public static Casos getCaso() {
        return caso;
    }

    public static void setCaso(Casos caso) {
        Main.caso = caso;
    }

    public static ArrayList<Abogados> getListaAbogado() {
        return listaAbogado;
    }

    public static void setListaAbogado(ArrayList<Abogados> listaAbogado) {
        Main.listaAbogado = listaAbogado;
    }
    
    
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        abogadoBD = new AbogadosJpaController(Persistence.createEntityManagerFactory("AbogadosPU"));
        casoBD = new CasosJpaController(Persistence.createEntityManagerFactory("AbogadosPU"));
        clienteBD = new ClientesJpaController(Persistence.createEntityManagerFactory("AbogadosPU"));
        llevaBD = new Llevar(Persistence.createEntityManagerFactory("AbogadosPU"));
        new Principal();
    }
    
}
