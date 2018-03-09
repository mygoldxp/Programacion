package ejercicios_tema_4;

import javax.swing.JOptionPane;

public class Ejercicio_9 {
    static int f=10, c=10;
    static int datos[][] = new int [f][c];
    public static void Ejercicio9(){
        int x=0;
        do{
            try{
                double fila = Double.parseDouble(JOptionPane.showInputDialog("Introduzca la fila:\nCancelar para ver el resultado"))-1;
                double columna = Double.parseDouble(JOptionPane.showInputDialog("Introduzca la columna:\nCancelar para ver el resultado"))-1;
                double valor = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el valor:\nCancelar para ver el resultado"));
                int v = comprobar((int)fila, (int)columna);
                if(v==0){
                    incluir((int)fila, (int)columna, (int)valor);
                }
                else{
                    JOptionPane.showMessageDialog(null, "En la fila " + (fila+1) + " y columna " + (columna+1) + " Ya tiene guardado el valor " + v);
                }
            }
            catch(NullPointerException e){
                x=1;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El valor ha de ser numérico.");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }while(x!=1);
        mostrar();
    }
    
    private static int comprobar (int Cfila, int Ccolumna){
        int x=0;
        if(datos[Cfila][Ccolumna]==0){
            x=0;
        }
        else{
            x = datos[Cfila][Ccolumna];
        }
        return x;
    }
    
    private static void incluir(int Ifila, int Icolumna, int Ivalor){
        datos[Ifila][Icolumna]=Ivalor;
    }
    
    private static void mostrar(){
        String resultado = "Los datos son:";
        int v=0;
        for(int x=0; x<f; x++){
            for(int y=0; y<c; y++){
                v=v + datos[x][y];
            }
            resultado = resultado + "\nFila " + (x+1) + " suma un total de " + v;
            v=0;
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
}
