/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import UML.Persona;
import Vista.*;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import Errores.Error;

/**
 *
 * @author v6222
 */
import Vista.AltaPersona;
import com.db4o.query.Query;
import java.util.ArrayList;
import javax.swing.JFrame;
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static Persona p;
    private static ObjectContainer db;
    
    public static void main(String[] args) {
        // TODO code application logic here
        db = Db4o.openFile("Persona");
        p = new Persona();
        new Principal();
        
        /*
        Persona p = new Persona("Jon", 5);
        db.store(p);
        ObjectSet result = db.queryByExample(Persona.class);
        while(result.hasNext()){
            Persona pe = (Persona)result.next();
            System.out.println(pe.getNombre());
        }
        db.close();*/
    }
    
    public static void cambiarVentana(String n, JFrame v) throws Exception{
        switch(n){
            
            case "":
                break;
                
            case"1":
                v.dispose();
                new AltaPersona();
                break;
                
            case "2":
                v.dispose();
                new ConsultaPersona();
                break;
                
            case "3":
                v.dispose();
                new ListadoPersona(listaPersona());
                break;
                
            case "4":
                cerrar(v);
                break;
                
            default:
                throw new Error(1);
        }
    }
    
    public static void cerrar(JFrame v){
        if(v.getTitle().equals("Principal")){
            v.dispose();
            db.close();
        }
        else{
            v.dispose();
            new Principal();
        }
    }
    
    
    public static boolean consultarPersona(String nombre){
        boolean existe = false;
        Query q = db.query();
        q.constrain(Persona.class);
        q.descend("nombre").constrain(nombre);
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
    
    public static void crearPersona(String nombre, int edad, String profesion, String telefono){
        Persona p = new Persona(nombre, edad, profesion, telefono);
        db.store(p);
    }

    public static ArrayList<Persona> listaPersona(){
        Query query = db.query();
        query.constrain(Persona.class);
        ObjectSet result = query.execute();
        ArrayList <Persona> listado = new ArrayList();
        while(result.hasNext()){
            listado.add((Persona) result.next());
            
        }
        return listado;
    }
    
    public static Persona getP() {
        return p;
    }

    public static void setP(Persona p) {
        Main.p = p;
    }
    
    
}
