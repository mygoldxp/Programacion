package Modelo;

import java.util.ArrayList;

public class Pasajero {
    
    private String cedula;
    private String nombre;
    private String apellido;
    private String sexo;
    private int edad;
    
    private Asiento asiento;
    
    // Creo que es al reves
    // private Vuelo vuelo;
    private ArrayList<Vuelo> listaVuelos;
    
    public void agregar_nuevo(){}
    
    public void modificar(){}
    
    public void asignarVuelo(){}
    
    public Pasajero buscar(){
        return null;
    }

    public Pasajero() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public ArrayList<Vuelo> getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(ArrayList<Vuelo> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }
    
    
    
    
    
    
}
