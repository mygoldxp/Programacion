/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import GUI.*;
import MBD.*;
import UML.*;
import java.util.Date;
import java.time.LocalTime;
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
    public static ArrayList <Evento> listadoEvento;
    public static String bd, usuario, contraseña, url;
    public static int n = 0;
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args){
        // TODO code application logic here
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
        listadoEvento = new ArrayList();
        new vMenu();
    }

    public static void vEventos(int n){
        new vEvento(n);
    }
    
    public static Evento consultar(String evento) throws Exception{
        ev = null;
        ev = eventoBBDD.consultar(evento);
        return ev;
    }
    
    public static Evento moverEvento(int nn){
        if(nn == 0){
            n = 0;
        }else if(nn == -10){
            n = listadoEvento.size()-1;
        }else{
            if((n + nn) < 0 || (n + nn) >= listadoEvento.size()){
                JOptionPane.showMessageDialog(null, "No existe más registros.");
            }
            else{
                n +=nn;
            }
        }
        
        return listadoEvento.get(n);
    }
    
    public static Evento recibirEvento() throws Exception{
        listadoEvento = eventoBBDD.listar();
        return listadoEvento.get(0);
    }
    
    public static void añadir(String nombre, String lugar, LocalTime hEntrada, LocalTime hSalida, Date fecha, int aforo) throws Exception{
        ev = new Evento(nombre, lugar, hEntrada, hSalida, fecha, aforo);
        eventoBBDD.añadir(ev);
    }
    
    public static void modificar(String nombre, String lugar, LocalTime hEntrada, LocalTime hSalida, Date fecha, int aforo) throws Exception{
        ev = new Evento(nombre, lugar, hEntrada, hSalida, fecha, aforo);
        eventoBBDD.modificar(ev);
    }
    
    public static void eliminar(String nombre) throws Exception{
        eventoBBDD.eliminar(nombre);
    }
    
    public static int consultarCodEvento(String nombreE) throws Exception{
        return eventoBBDD.consultarCodEvento(nombreE);
    }
    
    public static Empresa consultarEmpresa(String cif) throws Exception{
        em = null;
        em = empresaBBDD.consultar(cif);
        return em;
    }
    
    public static void añadirEmpresa(String cif, String nombre, String telefono, String direccion) throws Exception{
        em = new Empresa(cif, nombre, direccion, telefono);
        empresaBBDD.añadir(em);
    }
    
    public static boolean consultarPersona(String dni) throws Exception{
        return personaBBDD.consultar(dni);
    }
    
    public static void añadirPersona(String nombre, String apellidos, String dni, String direccion, String telefono, int edad, String cif) throws Exception{
        consultarEmpresa(cif);
        p = new Persona(nombre, apellidos, dni, direccion, telefono, edad, em);
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
