/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.java.jon.xu;

import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */

public class Ejercicio_7 {
    
    public static String notas="Las notas son lo siguiente:\n";
    public static float media=0;
    public static int contador=0;
    
    public static void main(String[] args)
    {
        String nombre = "";
        char errores=' ';
        do
        {
            try
            {
                nombre = JOptionPane.showInputDialog("Nombre del alumno:\nFIN para finalizar.");
                nombre = nombre.toUpperCase();
                if(nombre.equals("FIN")){
                    NotaFinal();
                }
                else{
                    notas = notas + nombre + ": ";
                    contador++;
                    RecibirDatos(); 
                }                               
            }
            catch(NullPointerException | StringIndexOutOfBoundsException e){
                JOptionPane.showMessageDialog(null,"Es obligatorio proporcionar el dato de entrada");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getCause() + e.getMessage());
            }
        }
        while(errores != '0');
        
    }
    
    public static void RecibirDatos(){
        float asig=0f, nasigs=0f;
        for(int c=1; c<7; c++){
            boolean pasar = true;
            do{
                try{
                    asig = 0;
                    pasar = true;
                    asig = Float.parseFloat(JOptionPane.showInputDialog("Introduzca nota asignatura " + c + ":"));
                    if(asig < 0 || asig > 10){
                        JOptionPane.showMessageDialog(null, "La nota ha de estar comprendido entre el 0 y el 10.");
                        pasar = false;
                }
                }
                catch(NullPointerException | StringIndexOutOfBoundsException | NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "El valor de la nota ha de ser numérico.");
                    pasar = false;
                }                
            }
            while(!pasar);
            notas = notas + " + " + asig;
            nasigs= nasigs + asig;
        }
        nasigs= nasigs/6;
        media=media + nasigs;
        notas=notas + " = " + asig + "\n";
    }
    
    public static void NotaFinal(){
        media = media/contador;
        notas=notas + "Total nota media final de " + contador + " alumnos es: " + media;
        JOptionPane.showMessageDialog(null, notas);
        System.exit(0);
    }
}
