
package ejercicios_tema_4;

import javax.swing.JOptionPane;

public class Ejercicio_2 {
    public static void Ejercicio2(){
        int v=0;
        do{
        try{
            v=0;
            String valor = JOptionPane.showInputDialog("Introduzca un mes:\nFin para cerrar.").toUpperCase();
            if(valor.equals("FIN")){
                JOptionPane.showMessageDialog(null, "OK, Voy a cerrarme.");
                System.exit(0);
            }
            else{
                consultar(valor);
            }
        }
        catch(NullPointerException | StringIndexOutOfBoundsException e){
            v=1;
            JOptionPane.showMessageDialog(null, "Para salir, escriba FIN.");
        }
        catch(Exception e){
            v=1;
            JOptionPane.showMessageDialog(null, e.getCause() + e.getMessage());
        }
        }
        while(v!=0);
    }
    
    public static void consultar( String valor){
        String meses[] = 
        {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
        int v=0, c=0;
        do{
            if(meses[c].equals(valor)){
                v=1;
                c=meses.length;
            }
            else{
                v=0;
            }
            c++;
        }
        while(c<meses.length);
        String resultado="";
        if(v==0){
            resultado = "No existe.";
        }
        else{
            resultado = "Si existe.";
        }
        JOptionPane.showMessageDialog(null, "El mes introducido ( "+ valor + " ) " + resultado);
    }
}
