/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import UML.Producto;
import UML.Proveedor;
import Vista.Principal;
import java.util.ArrayList;

/**
 *
 * @author v6222
 */

public class Almacen {
    
    static ArrayList <Proveedor> listaProveedor;
    static ArrayList <Producto> listaProducto;
    
    static Producto producto;
    
    public static String dato = "Los datos de las tablas son:\n";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        crearListas();
        llenarDatos();
        listarProducto();
        Principal prin = new Principal();
        prin.setVisible(true);
        añadircb(prin);
    }
    
    public static void crearListas(){
        
        listaProducto = new ArrayList();
        listaProveedor = new ArrayList();
    }
    
    public static void llenarDatos(){
        Proveedor p1 = new Proveedor("Eroski","999999999");
        Proveedor p2 = new Proveedor("Ikea","888888888");
        Proveedor p3 = new Proveedor("Leroy Merlin","777777777");
        
        listaProveedor.add(p1);
        listaProveedor.add(p2);
        listaProveedor.add(p3);
        
        
        listaProducto.add(new Producto("caja",12,15.00));
        listaProducto.add(new Producto("Mesa",12,150.50));
        listaProducto.add(new Producto("Silla",12,55.55));
        listaProducto.add(new Producto("Cartón",12,1.35));
        listaProducto.add(new Producto("Sofá",12,500.99));
        
        listaProducto.get(0).añadirProveedor(p1);
        listaProducto.get(1).añadirProveedor(p2);
        listaProducto.get(2).añadirProveedor(p1);
        listaProducto.get(3).añadirProveedor(p3);
        listaProducto.get(4).añadirProveedor(p3);
    }
    public static void añadircb(Principal prin){
        for (Proveedor e : listaProveedor) {
            prin.añadir(e.getNombre());
        }
    }
    public static boolean buscarP(String nombre){
        producto = null;
        for(int x =0; x<listaProducto.size(); x++){
            if(listaProducto.get(x).getNombre().equals(nombre)){
                producto = listaProducto.get(x);
                x = listaProducto.size();
            }
        }
        if(producto == null){
            return false;
        }
        else
        {
            return true;
        }
        
    }
    
    public static double buscarPre(){
        return producto.getPrecio();
    }
    public static int buscarUni(){
        return producto.getUnidad();
    }

    public static String precioVenta(String precio){
        double precioVenta = Double.parseDouble(precio);
        return String.valueOf(precioVenta*2);
    }
    
    public static String importe(String cantidad, String precio, int dto){
        if(dto == 0){
            return String.valueOf(Double.parseDouble(cantidad) * Double.parseDouble(precio));
        }
        else{
            double importe = Double.parseDouble(cantidad) * Double.parseDouble(precio);
            importe = importe - ((importe/100)*dto);
            return String.valueOf(importe);
        }   
    }
    
    public static void comprar(String unidad, String precio, String nombre){
        Proveedor proveedor = new Proveedor();
        for(int x = 0; x<listaProveedor.size(); x++){
            if(listaProveedor.get(x).getNombre().equals(nombre)){
                proveedor = listaProveedor.get(x);
                x=listaProveedor.size();
            }
        }
        producto.sumar(Integer.parseInt(unidad), Double.parseDouble(precio), proveedor);
    }
    
    public static void vender(String unidad){
        producto.restar(Integer.parseInt(unidad));
    }
    
    public static String proveedor(){
        return producto.getProveedor().get(0).getNombre();
    }
    
    public static void aceptado(Principal ventana){
        ventana.dispose();
        ventana = new Principal();
        ventana.setVisible(true);
        añadircb(ventana);
    }
    
    public static void listarProducto(){
        dato += "\n\nProductos sin modificar";
        listaProducto.forEach((e) -> {
            dato += "\n" + e.getNombre() + ", " + e.getUnidad() + ", " + e.getPrecio() + "€";
        });
    }
    
    public static String mostrarLista(){
        dato += "\n\nProductos modificados";
        listaProducto.forEach((e) -> {
            dato += "\n" + e.getNombre() + ", " + e.getUnidad() + ", " + e.getPrecio() + "€";
        });
        return dato;
    }
        
    public static void cerrar(){
        System.out.print(mostrarLista() + "\n\n");
        System.exit(0);
    }
}
