/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lenguajesejercicio2;

/**
 *
 * @author v6222
 */
public class Probabilidad {
    
    String periodo, descripcion, probabilidad;

    public Probabilidad() {
    }

    public Probabilidad(String periodo, String descripcion, String probabilidad) {
        this.periodo = periodo;
        this.descripcion = descripcion;
        this.probabilidad = probabilidad;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(String probabilidad) {
        this.probabilidad = probabilidad;
    }
    
    
}
