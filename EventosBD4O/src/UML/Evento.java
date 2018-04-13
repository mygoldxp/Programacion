/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.util.Date;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author v6222
 */
public class Evento {
    private String  nombre, lugar;
    private LocalTime hEntrada, hSalida;
    private Date fecha;
    private int     aforo;
    private ArrayList <Persona> listadoPersonas;

    public Evento() {
    }

    public Evento(String nombre, String lugar, LocalTime hEntrada, LocalTime hSalida, Date fecha, int aforo) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.hEntrada = hEntrada;
        this.hSalida = hSalida;
        this.fecha = fecha;
        this.aforo = aforo;
        listadoPersonas = new ArrayList();
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

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }


    public LocalTime gethEntrada() {
        return hEntrada;
    }

    public void sethEntrada(LocalTime hEntrada) {
        this.hEntrada = hEntrada;
    }

    public LocalTime gethSalida() {
        return hSalida;
    }

    public void sethSalida(LocalTime hSalida) {
        this.hSalida = hSalida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Persona> getListadoPersonas() {
        return listadoPersonas;
    }

    public void setListadoPersonas(Persona persona) {
        listadoPersonas.add(persona);
    }

    public void setListadoPersonasCompleta(ArrayList<Persona> listadoCompleto){
        this.listadoPersonas = listadoCompleto;
    }
}
