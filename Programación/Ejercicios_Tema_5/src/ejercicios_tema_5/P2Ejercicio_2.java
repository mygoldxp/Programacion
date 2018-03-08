/*
Dado un array de n´umeros enteros, localiza series de n´umeros consecutivos
en las que cada n´umero es igual o mayor que el anterior.
Devuelve otro array con las posiciones donde empiezan esas series.
Ejemplo:
A = 0, 4, 7, 3, 5, -1, 10, 10, 20
Hay tres series ascendentes
0 4 7
3 5
-1 10 10 20
de forma que devuelve el array de inicios
0, 3, 5

Usando ArrayList
 */
package ejercicios_tema_5;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class P2Ejercicio_2 {
    
    static String resultado="";
    public static void Ejercicio2(){
        try{
            resultado="Los datos del array son:\n";
            ArrayList <Integer> lista = entrada();
            ArrayList <Integer> inicios = localizar(lista);
            mostrar(resultado, inicios);
            //localizar(lista, inicios);
        }
        catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Error: " + e.getClass());
        }

    }
    
    public static ArrayList entrada(){
        ArrayList <Integer> lista = new ArrayList();
        do{
            try{
                String dato = JOptionPane.showInputDialog("Introduzca un número:\n");
                resultado +=  dato + ", ";
                lista.add(Integer.parseInt(dato));
                
            }
            catch( NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El valor ha de ser numérico.");
            }
        }
        while(JOptionPane.showConfirmDialog(null, "¿Desea continuar?")==0);
        resultado = resultado.substring(0, (resultado.length()-2)) + ".";
        return lista;
    }
        
    public static ArrayList localizar(ArrayList <Integer> lista){
        ArrayList <Integer> inicios = new ArrayList();
        int y= lista.get(0);
        inicios.add(0);
        resultado +="\nLas series quedan de la siguiente manera:\n" + y;
        for(int x=1; x<lista.size(); x++){
            if(y <= lista.get(x)){
                y = lista.get(x);
                resultado += ", " + lista.get(x);
            }
            else{
                y = lista.get(x);
                inicios.add(x);
                resultado += "\n" + lista.get(x);
            }
        }
        return inicios;
    }
    
    public static void mostrar(String resultados, ArrayList <Integer> inicios){
        resultados += "\nLas posiciones son:\n";
        for(int extraido : inicios){
            resultados += extraido + ", ";
        }
        resultados = resultados.substring(0, (resultados.length()-2)) + ".";
        JOptionPane.showMessageDialog(null, resultados);
    }
}
