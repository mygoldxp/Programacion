/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.sql.Date;
import java.sql.Time;


/**
 *
 * @author v6222
 */
public class Evento {
    String  nombre, lugar;
    Time hEntrada, hSalida;
    Date fecha;
    int     aforo;

    public Evento() {
    }

    public Evento(String nombre, String lugar, Time hEntrada, Time hSalida, Date fecha, int aforo) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.hEntrada = hEntrada;
        this.hSalida = hSalida;
        this.fecha = fecha;
        this.aforo = aforo;
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


    public Time gethEntrada() {
        return hEntrada;
    }

    public void sethEntrada(Time hEntrada) {
        this.hEntrada = hEntrada;
    }

    public Time gethSalida() {
        return hSalida;
    }

    public void sethSalida(Time hSalida) {
        this.hSalida = hSalida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
