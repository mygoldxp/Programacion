/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t7e3;

import Modelo.Producto;
import Vista.VentanaPrincipal;
import Vista.vOperaciones;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class T7e3 {

    /**
     * @param args the command line arguments
     */
    
    static ArrayList <Producto> listaProducto;
    static Producto p;
    static String datos = "Los datos de la tabla son:";
    
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            listaProducto = new ArrayList();

            altaProducto();
            listarProducto();

            new VentanaPrincipal().setVisible(true);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getClass());
        }
    }
    
    public static void altaProducto(){
        listaProducto.add(new Producto("Lejía",1.35d,12d));
        listaProducto.add(new Producto("Pajitas",1.00d,24d));
        listaProducto.add(new Producto("Patatas",1.50d,12d));
        listaProducto.add(new Producto("Mesa",25.00d,6d));
        listaProducto.add(new Producto("Silla",10.00d,12d));
        listaProducto.add(new Producto("Ratón",35.00d,12d));
        listaProducto.add(new Producto("Lápiz",0.50d,36d));
        listaProducto.add(new Producto("Teclado",25.00d,12d));
        listaProducto.add(new Producto("Caja",6.00d,12d));
    }
    
    public static void listarProducto(){
        datos += "\n\nProductos sin modificar";
        listaProducto.forEach((e) -> {
            datos += "\n" + e.getNombre() + ", " + e.getUnidad() + ", " + e.getPrecio() + "€";
        });
    }
 
    public static Double consultarP( String nombre){
        Double valor = 0d;
        try{
            for(int x=0; x< listaProducto.size(); x++){
                p = listaProducto.get(x);
                if(p.getNombre().equals(nombre)){
                    x=listaProducto.size();
                    valor = p.getPrecio();
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getClass());
        }
        return valor;
    }
    
    public static void vender(double tfUnidad){
        p.vender(tfUnidad);
    }
    
    public static void comprar(double tfUnidad,double tfImporte){
        p.comprar(tfUnidad, tfImporte);
    }
    
    public static void mostrarCV( javax.swing.JFrame ventana, int x){
        ventana.dispose();
        vOperaciones vo = new vOperaciones(x);
        vo.setVisible(true);      
    }
    
    public static void mostrarP( javax.swing.JFrame ventana){
        ventana.dispose();
        new VentanaPrincipal().setVisible(true);
    }
    
    public static String mostrarLista(){
        datos += "\n\nProductos modificados";
        listaProducto.forEach((e) -> {
            datos += "\n" + e.getNombre() + ", " + e.getUnidad() + ", " + e.getPrecio() + "€";
        });
        return datos;
    }
    
    public static void salir(){
        System.out.print(mostrarLista() + "\n\n");
        System.exit(0);
    }
}
