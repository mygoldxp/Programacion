/*
Tenemos una matriz bidimensional de boolean donde cada posici´on
indica si el punto (x, y) es blanco (true) o negro(false).
Ejemplo:
0000000000
0011111100
0001111100
0000111100
0000011100
0000000000
Escribem´etodos para localizar los bordes superior, inferior, izquierdo
y derecho.
El borde superior es el valor m´aximo de y donde alg ´un punto es
TRUE.
El borde inferior es el valorm´ınimo de y donde alg ´un punto es TRUE.
El borde izquierdo es el valor m´ınimo de x donde alg ´un punto es
TRUE.
El borde derecho es el valorm´aximo de x donde alg ´un punto es TRUE.
 */
package ejercicios_tema_5;

import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class P2Ejercicio_3 {
    static int matriz[][]={{0,0,0,0,0,0,0,0,0,0},{0,0,1,1,1,1,1,1,0,0},{0,0,0,1,1,1,1,1,0,0},{0,0,0,0,1,1,1,1,0,0},{0,0,0,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0}};
    public static void Ejercicio3(){
        try{
            mostrar();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hay un error: " + e.getCause());
        }
    }
    public static void mostrar() throws Exception{
        String tabla="Los datos de la tabla son:\n";
            for(int x=0; x<6; x++){
                for(int y=0; y<10; y++){
                    tabla += matriz[x][y];
                }
                tabla += "\n";
            }
            JOptionPane.showMessageDialog(null, tabla);
            arriba();
    }
    public static void arriba() throws Exception{
        String resultado="Las coordenadas son:\n";
        int c=1;
        for(int x=0; x<6; x++){
            for(int y=0; y<10; y++){
                if(matriz[x][y]==c){
                    if(c==0){
                        resultado += "\nArriba Derecha (" + x + "," + (y-1) + ").";
                        y=10;
                        x=6;
                    } 
                    else{
                        resultado += "Arriba Izquierda (" + x + "," + y + ").";
                    }
                    c=0;
                }
            }
        }
        abajo(resultado);
    }
    
    public static void abajo(String resultado){
        int c=1;
        for(int x=5; x>=0 && x<=6; x--){
            for(int y=0; y<10; y++){
                if(matriz[x][y]==c){
                    if(c==0){
                        resultado += "\nAbajo Derecha (" + x + "," + (y-1) + ").";
                        y=10;
                        x=-1;
                    } 
                    else{
                        resultado += "\nAbajo Izquierda (" + x + "," + y + ").";
                    }
                    c=0;
                }
            }
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
}
