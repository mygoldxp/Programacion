package ejercicios_tema_4;

import javax.swing.JOptionPane;

public class Ejercicio_5 {
    public static void Ejercicio5(){
        try{
            String palabra = JOptionPane.showInputDialog("Introduzca una palabra:"
                    + "\nFin para salir.").toLowerCase();
            if(palabra.equals("fin")){
                System.exit(0);
            }else{
                extraer(palabra);
            }
        }
        catch(NullPointerException e){
            System.exit(0);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void extraer(String palabra){
        String resultado="Las repeticiones de la palabra o frase ''" + palabra.toUpperCase() + "'' son lo siguiente:";
        int sumatorio=1;
        for(int x=0; x<palabra.length(); x++){
            
            for(int y=x+1; y<palabra.length(); y++){
                if(palabra.charAt(x)==palabra.charAt(y)){
                    sumatorio++;
                }
            }
            if(palabra.charAt(x) != ' '){
                resultado=resultado + "\n" + palabra.charAt(x) + " = " + sumatorio;
            }
            palabra = palabra.replace(palabra.charAt(x), ' ');
            sumatorio=1;
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
}
