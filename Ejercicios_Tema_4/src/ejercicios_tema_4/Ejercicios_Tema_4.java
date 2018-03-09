/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_tema_4;
import ejercicios_tema_4.*;
import javax.swing.JOptionPane;
/**
 *
 * @author v6222
 */
public class Ejercicios_Tema_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
        int ejercicio=0;
        String salida="";
        do{
        try{
        salida = JOptionPane.showInputDialog("Ejercicio:\nEjercicios 1-9\nFIN para salir.");
        salida = salida.toUpperCase();
        ejercicio = Integer.parseInt(salida);
        }
        catch(Exception menu)
        {
            if(salida.equals("FIN"))
            {
                System.exit(0);
            }
            JOptionPane.showMessageDialog(null, "El ejercicio ha de ser numérico.\n" + menu.getMessage() +". " +  menu.getClass() +". "+ menu.getCause());
        }
        switch(ejercicio)
       {
           case 1:
                Ejercicio_1.Ejercicio1();
                break;
            case 2:
                Ejercicio_2.Ejercicio2();
                break;
            case 3:
                Ejercicio_3.Ejercicio3();
                break;
            case 4:
                Ejercicio_4.Ejercicio4();
                break;
            case 5:
                Ejercicio_5.Ejercicio5();
                break;
            case 6:
                Ejercicio_6.Ejercicio6();
                break;
            case 7:
                Ejercicio_7.Ejercicio7();
                break;
            case 8:
                Ejercicio_8.Ejercicio8();
                break;
            case 9:
                Ejercicio_9.Ejercicio9();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Adiós");
                break;
       }}
        while(ejercicio > 11 || ejercicio < 1);
    }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "El valor ha de ser numérico y dentro del rango (1-9).");
        }
        catch(Exception e){
                JOptionPane.showMessageDialog(null, "Hay error: "+ e.getMessage());
            }}
    
}
