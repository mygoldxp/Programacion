/*
Dada una lista de caracteres, transformala en un array cuadrado (igual
n´umero de filas que de columnas) usando los caracteres de la lista y
rellenando con espacios en blanco los datos necesarios para completar
el array. El lado del array ser´a el primer n´umero cuyo cuadrado
permita abarcar todos los datos de entrada.
Ejemplo:
A = ’1’, ’2’, ’3’
Son 3 caracteres, luego generaremos un array de 2x2 (2x2 = 4 mayor
que 3)
[[ ’1’, ’2’]
[’3’, ’ ’]]
 */
package ejercicios_tema_5;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class P2Ejercicio_5 {

    static ArrayList <Character> lista ;
    public static void Ejercicio5(){
        try{
            String palabra = JOptionPane.showInputDialog("Introduzca una palabra:");
            lista = new ArrayList();
            for(int x=0; x<palabra.length();x++){
                lista.add(palabra.charAt(x));
            }
            crear(palabra);
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getClass());
        }
    }
    
    public static void crear (String palabra) throws Exception{
        int x;
        for(x=2; Math.pow(x, 2)<=lista.size(); x++);
            
        char tabla[][] = new char [x][x];
        rellenar(palabra, x, tabla);
    }
    
    public static void rellenar (String palabra, int tamanno, char tabla[][]) throws Exception{
        int contador= 0;
        for(int x=0; x<tamanno; x++){
            for(int y=0; y<tamanno; y++){
                if(contador<lista.size()){
                    tabla[x][y]= lista.get(contador);
                }else{
                    tabla[x][y]='N';
                }
                contador++;
            }
        }
         mostrar(tamanno, tabla);
    }
    
    public static void mostrar(int tamanno, char tabla[][]) throws Exception{
        String resultado="Los datos quedan de la siguiente manera:\n";
        for(int x=0; x<tamanno; x++){
            for(int y=0; y<tamanno; y++){
                resultado += "'" + tabla[x][y] + "' , ";
            }
            resultado = resultado.substring(0, resultado.length()-2);
            resultado +="\n";
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
}
