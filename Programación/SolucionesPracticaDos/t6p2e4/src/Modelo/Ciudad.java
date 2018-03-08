
package Modelo;

import java.util.ArrayList;

public class Ciudad {
    private String codigoCiudad;
    private String nombre;
    
    // Lista de vuelos que llegan a la ciudad
    private ArrayList<Vuelo> listaVuelos;

    public Ciudad() {
    }

    public String getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Vuelo> getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(ArrayList<Vuelo> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }
    
    public void agregarNuevo(){
        
    }
    
    public Ciudad obtener(){
        return this;
    }
    
    
    
}
