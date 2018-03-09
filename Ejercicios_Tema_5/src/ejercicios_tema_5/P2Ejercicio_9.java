/*
Dado un String, escribe un m´etodo que devuelva una lista de String
con todas las permutaciones de los caracteres.
Ejemplo:
”pbc”
”pbc”, ”pcb”, ”bpc”, ”bcp”,cpb”,cbp”
 */
package ejercicios_tema_5;

import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class P2Ejercicio_9 {
    static String mostrar;
    static int x, y;
    public static void Ejercicio9(){
        try{
            mostrar="";
            y=0;
            x=0;
            String valor = JOptionPane.showInputDialog("Escriba algo para combinar:");
            dividir(valor);
            mostrar = mostrar.substring(0, (mostrar.length()-2) )+".";   
            mostrar="Hay " + y +" combinaciones de la palabra " + valor + " y son:\n" + mostrar;
            JOptionPane.showMessageDialog(null, mostrar);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getCause());
        }
    }
    
    public static void dividir(String valor) throws Exception{
        String combinacion="";
        for(int x=0; x<valor.length();x++){
            combinacion += valor.charAt(x) + ",";
        }
        String[] letras = combinacion.split(",");
        int v = valor.length();
        int combi = letras.length;
        permutar(letras, v, combi, "");
    }
    
    public static void permutar(String[] letras, int n, int combi, String resultado) throws Exception {
        if (n == 0) {
            y++;
            if(x<40){
                mostrar=mostrar + resultado + ", ";
                x++;
            }
            else{
                mostrar=mostrar + resultado + "\n";
                x=0;
            }
        }
        else {
            for (int i = 0; i < combi; i++) {
                if (!resultado.contains(letras[i])) {
                    permutar(letras, n - 1, combi, resultado + letras[i]);
                }
            }
        }
    }
}
