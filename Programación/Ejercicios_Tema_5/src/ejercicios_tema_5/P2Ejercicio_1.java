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
*/
package ejercicios_tema_5;

import javax.swing.JOptionPane;

public class P2Ejercicio_1 {
    static String resultado="";
    public static void Ejercicio1(){
        try{
            resultado="Los datos del array son:\n";
            int lista[] = entrada();
            localizar(lista);
        }
        catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Error: " + e.getClass());
        }
    }
    public static int[] entrada(){
        int lista [] = new int[ 10];
        for(int x=0; x<lista.length;x++){
            try{
                lista[x] = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número:\n(" + x + "/10)"));
                resultado += lista[x] + ", ";
            }
            catch( NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El valor ha de ser numérico.");
                x--;
            }
        }
        resultado = resultado.substring(0, (resultado.length()-2)) + ".";
        return lista;
    }
    public static void localizar(int lista[]){
        int y= lista[0];
        resultado += "\nLas series quedan de la siguiente manera:\n" + y;
        String resulta="0";
        for(int x=1; x<lista.length; x++){
            if(y <= lista[x]){
                y = lista[x];
                resultado += ", " + lista[x];
            }
            else{
                y = lista[x];
                resulta += x;
                resultado += "\n" + lista[x];
            }
        }
        resultado += "\n";
        int resultados [] = new int [resulta.length()];
        for(int x=0; x<resulta.length(); x++){
            resultados[x]=resulta.charAt(x);
            if(x==resulta.length()-1){
                resultado += resulta.charAt(x);
            }
            else{
                resultado += resulta.charAt(x) + ", ";
            }
            
        }
        mostrar(resultado);
    }
    
    public static void mostrar(String resultados){
        resultados +=".";
        JOptionPane.showMessageDialog(null, resultados);
    }
}
