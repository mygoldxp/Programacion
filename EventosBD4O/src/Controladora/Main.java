/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import GUI.*;
import UML.*;
import com.db4o.*;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.Configuration;
import com.db4o.query.Query;
import java.util.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author v6222
 */
public class Main {

    
    private static Evento ev;
    private static Empresa em;
    private static Persona p;
    private static ArrayList <Evento> listadoEvento;
    private static int n = 0;
    private static ObjectContainer db;
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args){
        // TODO code application logic here
        //datos del servidor
        
        Configuration configuracion = Db4o.newConfiguration();
        configuracion.objectClass(Evento.class).updateDepth(100);
        //configuracion.objectClass(Persona.class).updateDepth(20);
        //configuracion.objectClass(Empresa.class).updateDepth(20);
        db = Db4o.openFile(configuracion , "Eventos");

        new vMenu();
    }

    // CONSULTAS SQL
    
    public static Evento consultar(String evento) throws Exception{
        ev = null;
        Query q = db.query();
        q.constrain(Evento.class);
        q.descend("nombre").constrain(evento);
        ObjectSet result = q.execute();
        if(!result.isEmpty()){
            ev = (Evento) result.next();
        }
        return ev;
    }
    
    public static Evento recibirEvento() throws Exception{
        listadoEvento = new ArrayList();
        Query query = db.query();
        query.constrain(Evento.class);
        ObjectSet result = query.execute();
        while(result.hasNext()){
            listadoEvento.add((Evento) result.next());
        }
        return listadoEvento.get(0);
    }
    
    public static void añadir(String nombre, String lugar, LocalTime hEntrada, LocalTime hSalida, Date fecha, int aforo) throws Exception{
        ev = new Evento(nombre, lugar, hEntrada, hSalida, fecha, aforo);
        db.store(ev);
    }
    
    public static void modificar(String nombre, String lugar, LocalTime hEntrada, LocalTime hSalida, Date fecha, int aforo) throws Exception{
        ObjectSet result = db.queryByExample(new Evento(nombre, null, null, null, null, 0));
        Evento found = (Evento) result.next();
        found.setLugar(lugar);
        found.sethEntrada(hEntrada);
        found.sethSalida(hSalida);
        found.setFecha(fecha);
        found.setAforo(aforo);
        db.store(found);
    }
    
    public static void eliminar(String nombre) throws Exception{
        ObjectSet result = db.queryByExample(new Evento(nombre, null, null, null, null, 0));
        Evento found = (Evento) result.next();
        db.delete(found);
    }
    
    public static Empresa consultarEmpresa(String cif) throws Exception{
        em = null;
        Query q = db.query();
        q.constrain(Empresa.class);
        q.descend("cif").constrain(cif);
        ObjectSet result = q.execute();
        if(!result.isEmpty()){
            em = (Empresa) result.next();
        }
        return em;
    }
    
    public static void añadirEmpresa(String cif, String nombre, String telefono, String direccion) throws Exception{
        em = new Empresa(cif, nombre, direccion, telefono);
        db.store(em);
    }
    
    public static boolean consultarPersona(String dni) throws Exception{
        p = null;
        boolean existe = false;
        Query q = db.query();
        q.constrain(Persona.class);
        q.descend("dni").constrain(dni);
        ObjectSet result = q.execute();
        if(result.isEmpty()){
            existe = false;
        }
        else{
            p = (Persona) result.next();
            existe = true;
        }
        
        return existe;
    }
    
    public static void añadirPersona(String nombre, String apellidos, String dni, String direccion, String telefono, int edad, String cif) throws Exception{
        p = new Persona(nombre, apellidos, dni, direccion, telefono, edad, consultarEmpresa(cif));
        db.store(p);
    }
    
    public static String asistir(String evento) throws Exception{
        ev = null;
        String dato = "";
        if(consultar(evento).getListadoPersonas().contains(p)){
            dato = "La persona ya está apuntado en el evento.";
        }
        else{
            ObjectSet result = db.queryByExample(new Evento(ev.getNombre(), null, null, null, null, 0));
            Evento found = (Evento) result.next();
            found.setListadoPersonas(p);
            db.store(found);
            
            int libres = ev.getAforo() - consultar(evento).getListadoPersonas().size();
            dato = String.valueOf(libres);
        }
        
        return dato;
    }
    
    public static void vMostrar() throws Exception{
        String dato = "Los datos de los eventos y sus asistentes son:\n";
        recibirEvento();
        for(Evento eve : listadoEvento){
            dato += "\n" + eve.getNombre() + ":\n";
            if(eve.getListadoPersonas().isEmpty()){
                dato += "--> NO TIENE PERSONAS APUNTADAS.\n";
            }
            else{
                for(Persona per : eve.getListadoPersonas()){
                dato += "-->" + per.getNombre() + ", " + per.getDni() + "\n";
                }
            }
            
        }
       
        new vMostrar(dato);
    }

    // FUNCIONES DE VENTANAS
    
    public static void vEventos(int n){
        new vEvento(n);
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
    
    public static void reabrir(JDialog v, int dato){
        v.dispose();
        new vEvento(dato);
    }
    
    public static void cerrar(JDialog v){
        v.dispose();
    }
    
    public static void salir(JFrame v){
        v.dispose();
        db.close();
        System.exit(0);
    }

    // SETTERS Y GETTERS

    public static Evento getEv() {
        return ev;
    }

    public static void setEv(Evento ev) {
        Main.ev = ev;
    }

    public static Empresa getEm() {
        return em;
    }

    public static void setEm(Empresa em) {
        Main.em = em;
    }

    public static Persona getP() {
        return p;
    }

    public static void setP(Persona p) {
        Main.p = p;
    }

    public static ArrayList<Evento> getListadoEvento() {
        return listadoEvento;
    }

    public static void setListadoEvento(ArrayList<Evento> listadoEvento) {
        Main.listadoEvento = listadoEvento;
    }

    public static int getN() {
        return n;
    }

    public static void setN(int n) {
        Main.n = n;
    }
    
}
