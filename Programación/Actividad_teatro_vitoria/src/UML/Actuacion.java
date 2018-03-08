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
public class Actuacion {
    
    int idActuacion;
    String horario;
    boolean estado;

    public Actuacion() {
    }

    public Actuacion(int idActuacion, String horario, boolean estado) {
        this.idActuacion = idActuacion;
        this.horario = horario;
        this.estado = estado;
    }

    public int getIdActuacion() {
        return idActuacion;
    }

    public void setIdActuacion(int idActuacion) {
        this.idActuacion = idActuacion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
}
