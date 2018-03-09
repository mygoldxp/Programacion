/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_tema_4;

import Excepciones.*;
import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class Ejercicio_7 {
    
    static int datos[][] = new int[5][2];
    static int vector =0;
    public static void Ejercicio7(){
        int x=1;
        do{
            try{
                double alumnos = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el Código del Alumno:\nCancelar para finalizar."));
                int alumno = (int) alumnos;
                vector=0;
                if(alumno > 0){
                    if(comprobar(alumno) == 0){
                        crear(alumno);
                    }
                    int faltas = Integer.parseInt(JOptionPane.showInputDialog("Introduzca las horas de faltas del alumno:"));
                    insertar(faltas);
                    String continuar = JOptionPane.showInputDialog("¿Desea continuar?\nIntroduzca SI, NO o Pulse Cancelar").toUpperCase();
                    if(continuar.equals("NO")){
                        x=0;
                    }else if(continuar.equals("SI")){
                        x=1;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "El valor introducido no es válido.");
                    }
                }else{
                    throw new ValorMayor0Exception();
                }  
            }
            catch(NullPointerException e){
                x=0;
            }
            catch (ValorMayor0Exception e){
                JOptionPane.showMessageDialog(null, "El valor ha de ser superior a 0.");
            }
            catch (ValorExcedidoException e){
                JOptionPane.showMessageDialog(null, "Ha excedido el número de alumnos permitidos(Max. 5).");
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El formato ha de ser numérico.");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"error: " + e.getMessage());
            }
        }
        while(x!=0);
        mostrar();
    }
    
    private static int comprobar(int Calumno) throws Exception{
        int y= 0;
        for(int x=0; x<(datos.length+1);x++){
            if(x==datos.length){
                throw new ValorExcedidoException();
            }
            if(datos[x][0]==Calumno){
                vector=x;
                x=datos.length+1;
                y=1;
            }else{
                if(datos[x][0] == 0){
                    y=0;
                    vector=x;
                    x=datos.length+1;
                }
            }
        }
        return y;
    }
    
    private static void crear(int Calumno){
        datos[vector][0]=Calumno;
    }
    
    private static void insertar(int Ifaltas){
        datos[vector][1]=datos[vector][1] + Ifaltas;
    }
    
    private static void mostrar(){
        String resultado="Las faltas del mes son:";
        for(int x=0; x<datos.length;x++){
            if(datos[x][0]!=0){
                resultado = resultado + "\nAlumno: " +datos[x][0] + " ha faltado " + datos[x][1] + " horas.";
            }
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
}
