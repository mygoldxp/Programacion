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
    
    private static ArrayList <Abogados> listaAbogado;
    private static ArrayList <Casos> listaCaso;
    
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
        
        new CasoAbogados(n, abrir(n));
        
    }
    
    public static void vBuscar(int n){
        
        new Buscar(n);
        
    }
    
    public static void vAbogadoCaso(int n){
        
        new AbogadoCasos(n, abrir(n));
        
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
    
    public static void modificarAbogado() throws Exception{

        abogadoBD.edit(abo);
        
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
    
    public static void modificarCliente() throws Exception{
        clienteBD.edit(clie);
    }
    
    public static void eliminarCliente(String dni) throws Exception{
        
        clienteBD.destroy(dni);
        
    }
    
    public static Casos consultarCaso(String numero) throws Exception{
        caso = null;
        caso = casoBD.findCasos(numero);
        return caso;
    }
    
    public static void crearCaso(String num, Date fechaI, Date fechaF, String estado) throws Exception{
        caso = new Casos(num, fechaI, fechaF, estado, clie);
        casoBD.create(caso);      
    }
    
    public static void modificarCaso() throws Exception{
        caso.setClientedni(clie);
        casoBD.edit(caso);
    }
    
    public static void modificarCasoSinCambiarClientes() throws Exception{
        casoBD.edit(caso);
    }
    
    public static void eliminarCaso(String numero) throws Exception{
        
        casoBD.destroy(numero);    
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
        lClie = clienteBD.buscarListaClientes(clie); 
        return lClie;
    }
    
    public static ArrayList <Casos> listarCasos(String exp, String estado) throws Exception{
        ArrayList <Casos> lCaso = new ArrayList();
        caso = new Casos(exp, estado);
        lCaso = casoBD.buscarListaCasos(caso); 
        return lCaso;
    }

    public static void cerrar(JDialog dato){
        dato.dispose();
    }
    
    // SETTERS Y GETTERS


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

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public static AbogadosJpaController getAbogadoBD() {
        return abogadoBD;
    }

    public static void setAbogadoBD(AbogadosJpaController abogadoBD) {
        Main.abogadoBD = abogadoBD;
    }

    public static CasosJpaController getCasoBD() {
        return casoBD;
    }

    public static void setCasoBD(CasosJpaController casoBD) {
        Main.casoBD = casoBD;
    }

    public static ClientesJpaController getClienteBD() {
        return clienteBD;
    }

    public static void setClienteBD(ClientesJpaController clienteBD) {
        Main.clienteBD = clienteBD;
    }

    public static ArrayList<Casos> getListaCaso() {
        return listaCaso;
    }

    public static void setListaCaso(ArrayList<Casos> listaCaso) {
        Main.listaCaso = listaCaso;
    }
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        abogadoBD = new AbogadosJpaController(Persistence.createEntityManagerFactory("AbogadosPU"));
        casoBD = new CasosJpaController(Persistence.createEntityManagerFactory("AbogadosPU"));
        clienteBD = new ClientesJpaController(Persistence.createEntityManagerFactory("AbogadosPU"));
        new Principal();
    }
    
}
