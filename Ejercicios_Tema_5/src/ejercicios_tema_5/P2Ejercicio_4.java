/*
Dados 2 arrays de caracteres, escribe una funci´on que investigue si
comparten una serie de caracteres. Si los comparten, devuelva el ´ındice
de la posici´on en el primer array a partir de la cual coinciden los
caracteres. Si no, lanza una excepci´on.
Ejemplo:
A = ’2’, ’0’, ’1’, ’2’
Busca ’0’, ’1’ ; // Encuentra en la posici´on uno
Busca ’3’, ’1’ ; // Lanza excepci´on.
 */
package ejercicios_tema_5;

import javax.swing.JOptionPane;
import Excepciones.*;
/**
 *
 * @author v6222
 */
public class P2Ejercicio_4 {
    
    static char tabla1 [];
    static char tabla2 [];
    static String posicion="";
    
    public static void Ejercicio4(){
        try{
            posicion="";
            String entrada = JOptionPane.showInputDialog("Escriba una palabra para que el otro adivine parte de la cadena:");
            tabla1 = entrada.toCharArray();
            entrada = JOptionPane.showInputDialog("Escriba una palabra para que el otro adivine parte de la cadena:");
            tabla2 = entrada.toCharArray();
            //insertar(crear1(), tabla1);
            //insertar(crear2(), tabla2);
            buscar();
        }
        catch(ExcepcionEjercicio4 e){
            JOptionPane.showMessageDialog(null, "Valores no encontrados.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hay un error: " + e.getCause());
        }
    }
/*    
    public static String crear1() throws Exception{
        String entrada = JOptionPane.showInputDialog("Escriba una palabra para que el otro adivine parte de la cadena:");
        tabla1 = new char[entrada.length()];
        return entrada;
    }
    public static String crear2() throws Exception{
        String entrada = JOptionPane.showInputDialog("Adivina parte de la cadena:");
        tabla2 = new char[entrada.length()];
        return entrada;
    }
    
    public static String insertar(String entrada, char tabla[]) throws Exception{
        for(int x=0; x<entrada.length(); x++){
            tabla[x] = entrada.charAt(x);
        }
        return entrada;
    }
*/    
    public static void buscar() throws Exception{
        for(int x=0; x<tabla2.length; x++){
            for(int y=0; y<tabla1.length; y++){
                if(tabla2[x]==tabla1[y]){
                    if(x==0){
                        comparar(y);
                        x=tabla2.length;
                        y=tabla1.length;
                    }
                    else{
                        throw new ExcepcionEjercicio4();
                    }
                }
            }
        }
        if(posicion.equals("")){
            throw new ExcepcionEjercicio4();
        }
        
        JOptionPane.showMessageDialog(null, posicion);
    }
    
    public static void comparar(int x) throws Exception {      
        for(int z=0; z<tabla2.length; z++){
            if(tabla2[z]==tabla1[x]){
                if(posicion.equals("")){
                    posicion = "Encontrado en la posición " + x + "\n";
                }
                posicion = posicion + " " + tabla1[x] + " ";
                x++;
            }
            else{
                throw new ExcepcionEjercicio4();
            }
        }
    }
}
