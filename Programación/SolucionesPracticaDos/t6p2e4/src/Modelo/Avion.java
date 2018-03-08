
package Modelo;

import java.util.ArrayList;

public class Avion {
    
    private String aerolinea;
    private String codigoDeAvion;
    private int numeroDeAsientos;
    private String compartimentos;
    
    private ArrayList<Vuelo> listaVuelos;
    
    public void asigarAVuelo(){}
    
    public Avion obtener(){
        return null;
    }
    
    public void cancelarVuelo(){}

    public Avion() {
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getCodigoDeAvion() {
        return codigoDeAvion;
    }

    public void setCodigoDeAvion(String codigoDeAvion) {
        this.codigoDeAvion = codigoDeAvion;
    }

    public int getNumeroDeAsientos() {
        return numeroDeAsientos;
    }

    public void setNumeroDeAsientos(int numeroDeAsientos) {
        this.numeroDeAsientos = numeroDeAsientos;
    }

    public String getCompartimentos() {
        return compartimentos;
    }

    public void setCompartimentos(String compartimentos) {
        this.compartimentos = compartimentos;
    }

    public ArrayList<Vuelo> getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(ArrayList<Vuelo> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }
    
    
    
}
