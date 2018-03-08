
package t5p2e3;

import Modelo.*;
import java.util.ArrayList;

public class T5p2e3 {

    public static void main(String[] args) {
        // Creo dos empresas
        Empresa [] listaEmpresas = new Empresa[2];
        // La primera sólo con el nombre
        listaEmpresas[0] = new Empresa("Michelin");
        listaEmpresas[0].setListaClientes(getListaClientes0());
        listaEmpresas[0].setListaEmpleados(getListaEmpleados0());
        // La segunda con nombre y clientes
        listaEmpresas[1] = new Empresa("Mercedes",getListaClientes1());
        listaEmpresas[1].setListaEmpleados(getListaEmpleados1());
        
        buscarDirectivoConMasSubordinados(listaEmpresas);
    }
    
    public static ArrayList<Cliente> getListaClientes0(){
        ArrayList<Cliente> lista = new ArrayList();
        lista.add(new Cliente("c1",21,"111"));
        lista.add(new Cliente("c2",31,"411"));
        lista.add(new Cliente("c3",41,"611"));
        return lista;
    }
    
    public static ArrayList<Empleado> getListaEmpleados0(){
        ArrayList<Empleado> lista = new ArrayList();
        lista.add(new Empleado("e1",21,10000));
        lista.add(new Empleado("e2",31,20000));
        lista.add(new Empleado("e3",41,30000));
        
        Directivo objD = new Directivo("Jefe1",45,50000,"Categoria uno");
        
        // Un directivo también es un empleado
        lista.add(objD);
        
        // El directivo todavía no está completo
        ArrayList<Empleado> listaSubordinados = new ArrayList();
        listaSubordinados.add(lista.get(0));
        objD.setSubordinados(listaSubordinados);
    
        
        objD = new Directivo("Jefe2",45,50100,"Categoria uno");
        listaSubordinados = new ArrayList();
        listaSubordinados.add(lista.get(1));
        listaSubordinados.add(lista.get(2));
        objD.setSubordinados(listaSubordinados);
        lista.add(objD);
        
        return lista;
    }
    
    public static ArrayList<Cliente> getListaClientes1(){
        ArrayList<Cliente> lista = new ArrayList();
        lista.add(new Cliente("Pepe",27,"118"));
        lista.add(new Cliente("Juan",37,"418"));
        lista.add(new Cliente("Imanol",47,"618"));
        lista.add(new Cliente("Maria",61,"111"));
        lista.add(new Cliente("Teresa",39,"411"));
        return lista;
    }
    
    public static ArrayList<Empleado> getListaEmpleados1(){
        ArrayList<Empleado> lista = new ArrayList();
        lista.add(new Empleado("e11",21,10500));
        lista.add(new Empleado("e21",31,20500));
        lista.add(new Empleado("e31",41,30500));
        lista.add(new Empleado("e51",21,100500));
        lista.add(new Empleado("e61",36,40000));
        
        Directivo objD = new Directivo("Jefe 56",45,50000,"Categoria uno");
        ArrayList<Empleado> listaSubordinados = new ArrayList();
        listaSubordinados.add(lista.get(0));
        listaSubordinados.add(lista.get(1));
        listaSubordinados.add(lista.get(2));
        listaSubordinados.add(lista.get(3));
        objD.setSubordinados(listaSubordinados);
        lista.add(objD);
        
        objD = new Directivo("Jefe 67",45,50100,"Categoria uno");
        listaSubordinados = new ArrayList();
        listaSubordinados.add(lista.get(2));
        listaSubordinados.add(lista.get(3));
        listaSubordinados.add(lista.get(4));
        objD.setSubordinados(listaSubordinados);
        lista.add(objD);
        
        return lista;
    }
    public static void buscarDirectivoConMasSubordinados(Empresa [] lista){
        int max = 0;
        Directivo objetoMaximo = null;
        
        for(int x = 0; x < lista.length; x++)
        {
            // empleados de una empresa
            for (int y = 0; y < lista[x].getListaEmpleados().size();y++)
            {
                // Es o no es un directivo
               if ( lista[x].getListaEmpleados().get(y) instanceof Directivo)
               {
                   Directivo objeto = (Directivo) lista[x].getListaEmpleados().get(y);
                   if (objeto.getSubordinados().size() > max)
                   {
                       objetoMaximo = objeto;
                       max = objeto.getSubordinados().size();
                   }
               }
                
            }
        }
        javax.swing.JOptionPane.showMessageDialog(null, " El directivo que más subordinados tiene es " + objetoMaximo.getNombre() + " y tiene " + max + " empleados a su cargo");
    }
}
