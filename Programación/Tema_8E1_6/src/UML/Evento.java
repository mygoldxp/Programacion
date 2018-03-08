/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;


/**
 *
 * @author v6222
 */
public class Evento {
    String  nombre, lugar, hEntrada, hSalida, fecha;
    int     nPersonas, codEvento;

    public Evento() {
    }

    public Evento(String nombre, String lugar, String fecha, String hEntrada, String hSalida, int nPersonas) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.hEntrada = hEntrada;
        this.hSalida = hSalida;
        this.nPersonas = nPersonas;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getnPersonas() {
        return nPersonas;
    }

    public void setnPersonas(int nPersonas) {
        this.nPersonas = nPersonas;
    }

    public String gethEntrada() {
        return hEntrada;
    }

    public void sethEntrada(String hEntrada) {
        this.hEntrada = hEntrada;
    }

    public String gethSalida() {
        return hSalida;
    }

    public void sethSalida(String hSalida) {
        this.hSalida = hSalida;
    }

    public int getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(int codEvento) {
        this.codEvento = codEvento;
    }
    
    
}
