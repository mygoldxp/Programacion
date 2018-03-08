/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jonxujin;

import GUI.Alta;
import UML.Pelicula;
import UML.Persona;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author 1gprogexa15
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static ArrayList <Pelicula> listaPelicula;
    static ArrayList <Persona> listaPersona;
    static ArrayList <Persona> listaPersonajes;
    static Persona guinista, director;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        listaPelicula = new ArrayList();
        listaPersona = new ArrayList();
        listaPersonajes = new ArrayList();
        Alta ventana = new Alta();
        ventana.setVisible(true);
        
        
    }
    
    public static void datos(JComboBox genero){

        genero.addItem("Drama");
        genero.addItem("Comedia");
        genero.addItem("Acción");
        genero.addItem("Terror");
        genero.addItem("Romance");
        genero.addItem("Aventura");
        
    }
    
    public static void agregarPersona(int cod, String nombre, String fecha) throws ParseException{
        SimpleDateFormat forma = new SimpleDateFormat("dd-MM-yyyy");        
        
        Persona p = new Persona(nombre, forma.parse(fecha));
        listaPersona.add(p);
        switch(cod){
            case 1:
                listaPersonajes.add(p);
                break;
            
            case 2:
                director = p;
                break;
                
            case 3:
                guinista = p;
                break;
        }
 
    }
    
    public static boolean agregarTitulo(String titulo, String genero){
        boolean estado = false;

        if(director.equals(null) || guinista.equals(null) || listaPersonajes.isEmpty()){
            
                estado = false;
            }
        else{
            
            Pelicula peli = new Pelicula(titulo, genero);
            peli.setDirectorDirigido(director);
            peli.setGuinistaEscrito(guinista);
            peli.setListaActores(listaPersonajes);
            listaPelicula.add(peli);

            guinista.setGuinistaEscribe(peli);
            listaPersona.add(guinista);
            director.setDirectorDirige(peli);
            listaPersona.add(director);

            listaPersonajes = new ArrayList();
            estado = true;
        }
        
        return estado;
        }
    
    public static String mostrar(){
        int numero = 3;
        String dato = "Las películas con más de 3 actores son:\n";
        dato = listaPelicula.stream().filter((peli) -> (peli.getListaActores().size() >= numero)).map((peli) -> peli.getTitulo()).reduce(dato, String::concat);
        return dato;
    }
    
    public static void cerrar(JFrame ventana){
        ventana.dispose();
        System.exit(0);
    }
}
    