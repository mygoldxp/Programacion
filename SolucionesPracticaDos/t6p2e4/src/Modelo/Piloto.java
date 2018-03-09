package Modelo;

import java.util.ArrayList;

public class Piloto {
    
    private String codigoPiloto;
    private String nombre;
    private String apellido;
    private Integer numeroDeLicencia;
    
    private ArrayList<Vuelo> listaVuelos;
    
    public void agregar_nuevo(){}
    
    public void asignarAVuelo(){}
    
    public void cancelarAVuelo(){}
    
    public void modificar(){}
    
    public Piloto buscar(){
        return null;
    }

    public Piloto() {
    }

    public String getCodigoPiloto() {
        return codigoPiloto;
    }

    public void setCodigoPiloto(String codigoPiloto) {
        this.codigoPiloto = codigoPiloto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getNumeroDeLicencia() {
        return numeroDeLicencia;
    }

    public void setNumeroDeLicencia(Integer numeroDeLicencia) {
        this.numeroDeLicencia = numeroDeLicencia;
    }

    public ArrayList<Vuelo> getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(ArrayList<Vuelo> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }
    
    
    
}
