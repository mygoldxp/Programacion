/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.util.Date;

/**
 *
 * @author 1gprogexa15
 */
public class Persona {
    
    String nombre;
    Date fechaNacimiento;
    Pelicula actorActua;
    Pelicula guinistaEscribe;
    Pelicula directorDirige;
    

    public Persona() {
    }

    public Persona(String nombre, Date fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Pelicula getActorActua() {
        return actorActua;
    }

    public void setActorActua(Pelicula actorActua) {
        this.actorActua = actorActua;
    }

    public Pelicula getGuinistaEscribe() {
        return guinistaEscribe;
    }

    public void setGuinistaEscribe(Pelicula guinistaEscribe) {
        this.guinistaEscribe = guinistaEscribe;
    }

    public Pelicula getDirectorDirige() {
        return directorDirige;
    }

    public void setDirectorDirige(Pelicula directorDirige) {
        this.directorDirige = directorDirige;
    }

    
}
