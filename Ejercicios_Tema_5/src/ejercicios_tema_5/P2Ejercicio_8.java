/*
Dados 2 n´umeros en forma de array de caracteres, necesitamos un
m´etodo que genere el array suma.
Ejemplo:
A = ’2’, ’0’, ’1’, ’2’ // 2 0 1 2
B = ’1’, ’9’ // 1 9
suma(A, B) = ’2’, ’0’, ’3’, ’1’ // 2 0 3 1
Elm´etodo que se pide recibe como argumentos 2 arrays de caracteres,
y devuelve como resultado un array de caracteres. El array resultado
tendr´a el m´ınimo tama˜no necesario para contener el n´umero; o sea,
sin ceros a la izquierda.
Todo con ArrayList
 */
package ejercicios_tema_5;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class P2Ejercicio_8 {

    public static void Ejercicio8(){
        ArrayList <Character> tabla1 = new ArrayList();
        ArrayList <Character> tabla2 = new ArrayList();
        try{
            insertar(tabla1, entrada());
            insertar(tabla2, entrada());
            mostrar(tabla1,tabla2);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getCause());
        }
    }
    
    public static String entrada() throws Exception{
        String valor="";
        boolean continuar=true;
        do{
            try{
                valor = JOptionPane.showInputDialog("Introduzca un conjunto de número:");
                Integer.parseInt(valor);
                continuar=false;
            }
            catch(NullPointerException e){
                continuar=true;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El valor ha de ser numérico.");
                continuar=true;
            }
        }
        while(continuar);
        return valor;
    }
    
    public static void insertar(ArrayList <Character> tabla, String valor) throws Exception{
        for(int y=0; y<valor.length();y++){
            tabla.add(valor.charAt(y));
        }
    }    
    public static void mostrar(ArrayList <Character> tabla1, ArrayList <Character> tabla2) throws Exception{
        String a="", b="";
        String mostrar="Los valores de la tabla 1 son:\n";
        for(char x :tabla1){
            mostrar += x + ", ";
            a += x;
        }
        mostrar = mostrar.substring(0, (mostrar.length()-2));
        
        mostrar+="\nLos valores de la tabla 2 son:\n";
        for(char x:tabla2){
            mostrar += x + ", ";
            b += x;
        }
        mostrar = mostrar.substring(0, (mostrar.length()-2));    
        combinar(a,b,mostrar);
    }
    
    public static void combinar(String a, String b, String mostrar) throws Exception{
        String total = String.valueOf(Integer.parseInt(a) + Integer.parseInt(b));
        ArrayList <Character> tabla3 = new ArrayList();
        for(int y=0; y<total.length();y++){
            tabla3.add(total.charAt(y));
        }
        mostrar += "\n\nTotal de la suma: ";
        for(char x:tabla3){
            mostrar += x;
        }
        JOptionPane.showMessageDialog(null, mostrar);
    }
    
}
