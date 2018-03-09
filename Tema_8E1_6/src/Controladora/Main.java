/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import GUI.vMostrar;
import GUI.vEvento;
import GUI.vMenu;
import MBD.AsistirBBDD;
import MBD.ZCABBDD;
import MBD.EmpresaBBDD;
import MBD.EventoBBDD;
import MBD.PersonaBBDD;
import MBD.ZConexionBBDD;
import UML.Empresa;
import UML.Evento;
import UML.Persona;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author v6222
 */
public class Main {

    public static Evento ev;
    public static Empresa em;
    public static Persona p;
    public static EventoBBDD eventoBBDD;
    public static EmpresaBBDD empresaBBDD;
    public static PersonaBBDD personaBBDD;
    public static AsistirBBDD asistirBBDD;
    public static ZCABBDD zcaBBDD;
    public static ZConexionBBDD zcBBDD;
    public static String directorio;
    public static String bd, usuario, contraseña, url;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        //directorio sentencias sql
        directorio = "src/Librerias/sql.xml";
        
        //datos del servidor
        bd = "t8e1";
        usuario = "root";
        contraseña = "usbw";
        url = "jdbc:mysql://localhost:3307/";
        
        //inicialización de valores
        eventoBBDD = new EventoBBDD();
        empresaBBDD = new EmpresaBBDD();
        personaBBDD = new PersonaBBDD();
        asistirBBDD = new AsistirBBDD();
        asistirBBDD = new AsistirBBDD();
        zcaBBDD = new ZCABBDD();
        
        //comprobar disponibilidad del servidor y sus tablas
        comprobarTablas();
        
        new vMenu();
    }
    
    public static void comprobarTablas(){
        try {
            //comprobar accesibilidad del servidor
            zcBBDD = new ZConexionBBDD();
            zcBBDD.getConnection();
            zcBBDD.desconectar();
            
            //comprobar la existencia de las tablas
            zcaBBDD.comprobar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
    }
    
    public static void vEventos(int n){
        new vEvento(n);
    }
    
    public static String st(String nombre){
        String dato = "";
        try {
            boolean salir = true, agregar = false;
            String fila;
            FileReader fr;
            fr = new FileReader(directorio);
            BufferedReader br;
            br = new BufferedReader(fr);
            while ((fila = br.readLine())!=null && salir) {
                String inicio = "<" + nombre + ">", fin = "</"+ nombre +">";
                if(fila.contains(inicio)){
                    agregar = true;
                    fila = "";
                }
                else if(fila.contains(fin)){
                    agregar = false;
                    salir = false;
                }
                if(agregar){
                    dato += fila + " ";
                }
            }
            fr.close();
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getClass());
        }
        
        return dato;
    }
    
    public static Evento consultar(String evento) throws Exception{
        ev = null;
        ev = eventoBBDD.consultar(evento);
        return ev;
    }
    
    public static ArrayList recibirEvento() throws Exception{
        ArrayList <Evento> listadoEvento = eventoBBDD.listar();
        return listadoEvento;
    }
    
    public static void añadir(String nombre, String lugar, int plaza, String fecha, String horaI, String horaF ) throws Exception{
        Evento evento = new Evento(nombre, lugar, fecha, horaI, horaF, plaza);
        eventoBBDD.añadir(evento);
    }
    
    public static void modificar(String nombre, String lugar, int plaza, String fecha, String horaI, String horaF) throws Exception{
        Evento evento = new Evento(nombre, lugar, fecha, horaI, horaF, plaza);
        eventoBBDD.modificar(evento);
    }
    
    public static void eliminar(String nombre) throws Exception{
        eventoBBDD.eliminar(nombre);
    }
    
    public static Empresa consultarEmpresa(String cif) throws Exception{
        em = null;
        em = empresaBBDD.consultar(cif);
        return em;
    }
    
    public static void añadirEmpresa(String cif, String nombre, String telefono, String direccion) throws Exception{
        Empresa emp = new Empresa(cif, nombre, telefono, direccion);
        empresaBBDD.añadir(emp);
    }
    
    public static Persona consultarPersona(String dni) throws Exception{
        p = null;
        p = personaBBDD.consultar(dni);
        return p;
    }
    
    public static void añadirPersona(String dni, String nombre, String apellidos, String direccion, String telefono, int edad, String empresa) throws Exception{
        p = new Persona(nombre, apellidos, dni, direccion, telefono, edad, empresa);
        personaBBDD.añadir(p);
    }
    
    public static String asistir(String evento) throws Exception{
        ev = null;
        ev = eventoBBDD.consultar(evento);
        return asistirBBDD.añadir(p, ev);
    }
    
    public static void vMostrar() throws Exception{
        String dato = asistirBBDD.listado();
        new vMostrar(dato);
    }
    
    public static void reabrir(JDialog v, int dato){
        v.dispose();
        new vEvento(dato);
    }
    
    public static void cerrar(JDialog v){
        v.dispose();
    }
    
    public static void salir(JFrame v){
        v.dispose();
        System.exit(0);
    }
}
