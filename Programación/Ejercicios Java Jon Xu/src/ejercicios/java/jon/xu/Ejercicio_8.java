/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.java.jon.xu;

import Excepciones.*;
import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class Ejercicio_8 {
    
    static int ad1=0, ad2=0, ad3=0;
    static int r1=0, r2=0, r3=0;
    static String generado="", extraer="";
    
    public static void main (String[] arg){
        char error = ' ';
        generar();
        do{
            try{
                String entrada = JOptionPane.showInputDialog("Jugamos a Muertos y Heridos:\nIntroduce un número de 3 digitos XXX.\nSi introduce menos dígitos, será rellenados los dígitos faltantes por el lado izquierdo.\nFIN para salir del juego.");
                entrada = entrada.toUpperCase();
                if(entrada.equals("FIN")){
                    System.exit(0);
                }
                int numero = Integer.parseInt(entrada);
                if(numero<0 || numero > 999){
                    JOptionPane.showMessageDialog(null, "El valor han de estar comprendidos entre el 0 y el 999.");
                    error = '1';
                }
                else{
                    numero = numero + 1000;
                    extraer = String.valueOf(numero);
                    asignar();
                    error = comparar();
                }
            }
            
            catch(NullPointerException | StringIndexOutOfBoundsException | NumberFormatException e){
                JOptionPane.showMessageDialog(null,"El dato es obligatorio y ha de ser numérico.");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getCause() + e.getMessage());
            }
        }
        while(error != '0');
    }
    
    public static void generar(){
        int aad1=0, aad2=0, aad3=0;
        do{
        aad1 = (int) (Math.random()*9);
        aad2 = (int) (Math.random()*9);
        aad3 = (int) (Math.random()*9);
        }
        while(aad1==aad2 || aad1==aad3 || aad2==aad3 );
        generado = aad1 +""+ aad2+"" + aad3;
        //Número generado
        //JOptionPane.showMessageDialog(null, generado);
    }
    
    public static void asignar()
    {
        ad1 = generado.charAt(0);
        ad2 = generado.charAt(1);
        ad3 = generado.charAt(2);
        r1 = extraer.charAt(1);
        r2 = extraer.charAt(2);
        r3 = extraer.charAt(3);
    }
    
    public static char comparar(){
        
        int m=0, h=0;
        if(ad1==r1){
            ad1=0;
            m++;
        }
        if(ad2==r2){
            ad2=0;
            m++;
        }
        if(ad3==r3){
            ad3=0;
            m++;
        }
        if(ad1==r2 || ad1==r3){
            ad1=0;
            h++;
        }
        if(ad2==r1 || ad2==r3){
            ad2=0;
            h++;
        }
        if(ad3==r2 || ad3==r1){
            ad3=0;
            h++;
        }
        if(m==3){
            JOptionPane.showMessageDialog(null, "Enhorabuena, Has Acertado.\nFin del Juego");
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Vaya, " + m + " muertos y " + h + " heridos. Inténtalo de nuevo.");
        return('1');
    }
    
}
