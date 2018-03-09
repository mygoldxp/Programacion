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
 */
package ejercicios_tema_5;

import javax.swing.JOptionPane;

public class P2Ejercicio_7 {

    public static void Ejercicio7(){
        try{
            char tabla1[] = entrada("1").toCharArray();
            char tabla2[] = entrada("2").toCharArray();
            mostrar(tabla1, tabla2);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getCause());
        }
    } 
    public static String entrada(String a) throws Exception{
        String valor="";
        boolean continuar=true;
        do{
            try{
                valor = JOptionPane.showInputDialog("Introduzca un conjunto de número:\nTabla " + a);
                if(valor.isEmpty()){
                    continuar=false;
                }
                else{
                    Integer.parseInt(valor);
                    continuar=false;
                }
            }
            catch(NullPointerException e){
                continuar=false;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El valor ha de ser numérico.");
                continuar=true;
            }
        }
        while(continuar);
        return valor;
    }
    
    public static void mostrar(char tabla1[], char tabla2[]) throws Exception{
        String a = String.valueOf(tabla1);
        String b = String.valueOf(tabla2);
        String mostrar="Los valores de la tabla 1 son:\n" + a + "\nLos valores de la tabla 2 son:\n" + b + "\nTotal de la suma: ";
        combinar(a,b,mostrar);
    }
    public static void combinar(String a, String b, String mostrar) throws Exception{
        String total = String.valueOf(Integer.parseInt(a) + Integer.parseInt(b));
        char tabla3[] = total.toCharArray();
        mostrar += String.valueOf(tabla3);  
        JOptionPane.showMessageDialog(null, mostrar);
    }   
}
