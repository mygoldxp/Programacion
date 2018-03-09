/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.util.ArrayList;

/**
 *
 * @author v6222
 */
public class Producto {
    public String nombre;
    public int unidad;
    public double precio;
    public ArrayList <Proveedor> proveedor;

    public Producto() {
    }

    public Producto(String nombre, int unidad, double precio) {
        this.nombre = nombre;
        this.unidad = unidad;
        this.precio = precio;
        proveedor = new ArrayList();
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<Proveedor> getProveedor() {
        return proveedor;
    }

    public void setProveedor(ArrayList<Proveedor> proveedor) {
        this.proveedor = proveedor;
    }
    public void  añadirProveedor(Proveedor p){
        this.proveedor.add(p);
    }
    
    public void sumar(int unidad, double precio, Proveedor proveedor){
        this.unidad = this.unidad + unidad;
        this.precio = precio;
        
        boolean encontrado = false;
        for(int x = 0; x<this.proveedor.size();x++){
            if(this.proveedor.get(x).nombre.equals(proveedor.nombre)){
                x = this.proveedor.size();
                encontrado = true;
            }
        }
        
        if(!encontrado){
            this.proveedor.add(proveedor);
        }
    }
    
    public void restar(int unidad){
        this.unidad = this.unidad - unidad;
        
    }
}
