/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author v6222
 */
public class Producto {
    String nombre;
    double precio;
    double unidad;

    public Producto() {
    }

    public Producto(String nombre, double precio, double unidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidad = unidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getUnidad() {
        return unidad;
    }

    public void setUnidad(double unidad) {
        this.unidad = unidad;
    }
    
    public void comprar(double unidad, double precio){
        this.unidad = this.unidad + unidad;
        this.precio = precio;
    }
    
    public void vender(double unidad){
        this.unidad = this.unidad - unidad;
        
    }
}
