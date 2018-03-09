/*
Dadas 2 listas de String, que tienen los valores internos ordenados
escribe un m´etodo que genere la lista que combina ambas, tambi´en
ordenada.
Ejemplo:
alfa, beta, zeta
manuel, pedro
alfa, beta, manuel, pedro, zeta
 */
package ejercicios_tema_5;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class P2Ejercicio_6 {
    
       
    public static void Ejercicio6(){
        ArrayList <String> lista1 = new ArrayList();
        ArrayList <String> lista2 = new ArrayList();
        try{
            int x=1;
            insertar(lista1,x);
            x++;
            insertar(lista2, x);
            mostrar(lista1, lista2);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getCause());
        }
    }
    
    public static String entrada(int y) throws Exception{
        String x="";
            try{
                x = JOptionPane.showInputDialog("Introduzca una palabra para la tabla " + y + ":\nEscriba / para finalizar.");
                if(x.equals("/") || x.isEmpty()){
                    x="false";
                }
            }
            catch(NullPointerException e){
                x="false";
            }
        return x;
    }
    public static void insertar(ArrayList <String> lista, int x) throws Exception{
        String valor="";
        do{
            valor = entrada(x);
            if(!valor.equals("false")){
                
                lista.add(valor);
            }
        }
        while(!valor.equals("false")); 
    }
    
    public static void mostrar(ArrayList <String> lista1, ArrayList<String> lista2){
        String mostrar="Los valores de la lista 1 son:\n";
        for(String listas1:lista1){
            mostrar += listas1 + ", ";
        }
        mostrar = mostrar.substring(0, (mostrar.length()-2));
        
        mostrar+="\nLos valores de la lista 2 son:\n";
        for(String listas2:lista2){
            mostrar += listas2 + ", ";
        }
        mostrar = mostrar.substring(0, (mostrar.length()-2));    
        JOptionPane.showMessageDialog(null, mostrar);
        combinar(lista1, lista2, mostrar);
    }
    
    public static void combinar(ArrayList<String> lista1, ArrayList<String> lista2, String resultado){
        resultado +="\n\nLos datos ordenados son:";
        ArrayList <String> lista3 = new ArrayList();
        for(String valor:lista1){
            lista3.add(valor);
        }
        for(String valor:lista2){
            lista3.add(valor);
        }
        Collections.sort(lista3);
        for(String valor:lista3){
            resultado += "\n" + valor;
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
}
