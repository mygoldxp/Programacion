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
public class Viento {
    private String periodo, velocidad, direccion;

    public Viento() {
    }

    public Viento(String periodo, String velocidad, String direccion) {
        this.periodo = periodo;
        this.velocidad = velocidad;
        this.direccion = direccion;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
