package Modelo;

import java.util.ArrayList;
import java.util.Date;

public class Vuelo {
    
    private int numeroDeVuelo;
    private String horaDeSalida;
    private String horaDeLlegada;
    
    // Clase ciudad???
    private String lugarDeOrigen;
    private String lugarDeDestino;
    private Date fechaDeSalida;
    private Date fechaDeRegreso;
    
    // Herencia ?? 
    private String tipoDeVuelo;
    
    private Avion avion;
    private Piloto piloto;
    private ArrayList<Asiento> listaAsientos;
    private Pasajero pasajero;
    // private ArraList<Pasajero> listaPasajeros;
    private Ciudad ciudad;
    
    public void reservar(){}
    
    public void modificar(){}
    
    public void eliminar(){}
    
    public Vuelo buscar(){
        return null;
    }

    public Vuelo() {
    }

    public int getNumeroDeVuelo() {
        return numeroDeVuelo;
    }

    public void setNumeroDeVuelo(int numeroDeVuelo) {
        this.numeroDeVuelo = numeroDeVuelo;
    }

    public String getHoraDeSalida() {
        return horaDeSalida;
    }

    public void setHoraDeSalida(String horaDeSalida) {
        this.horaDeSalida = horaDeSalida;
    }

    public String getHoraDeLlegada() {
        return horaDeLlegada;
    }

    public void setHoraDeLlegada(String horaDeLlegada) {
        this.horaDeLlegada = horaDeLlegada;
    }

    public String getLugarDeOrigen() {
        return lugarDeOrigen;
    }

    public void setLugarDeOrigen(String lugarDeOrigen) {
        this.lugarDeOrigen = lugarDeOrigen;
    }

    public String getLugarDeDestino() {
        return lugarDeDestino;
    }

    public void setLugarDeDestino(String lugarDeDestino) {
        this.lugarDeDestino = lugarDeDestino;
    }

    public Date getFechaDeSalida() {
        return fechaDeSalida;
    }

    public void setFechaDeSalida(Date fechaDeSalida) {
        this.fechaDeSalida = fechaDeSalida;
    }

    public Date getFechaDeRegreso() {
        return fechaDeRegreso;
    }

    public void setFechaDeRegreso(Date fechaDeRegreso) {
        this.fechaDeRegreso = fechaDeRegreso;
    }

    public String getTipoDeVuelo() {
        return tipoDeVuelo;
    }

    public void setTipoDeVuelo(String tipoDeVuelo) {
        this.tipoDeVuelo = tipoDeVuelo;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public ArrayList<Asiento> getListaAsientos() {
        return listaAsientos;
    }

    public void setListaAsientos(ArrayList<Asiento> listaAsientos) {
        this.listaAsientos = listaAsientos;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    
    
}
