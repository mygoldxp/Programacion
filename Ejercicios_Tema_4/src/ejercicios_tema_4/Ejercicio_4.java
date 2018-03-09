
package ejercicios_tema_4;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Ejercicio_4 {
    
static int v=0;
static int datos[][] = new int [12][31];
static int fdatos[] = new int [12];
    public static void Ejercicio4(){
        do{
            try{
                String dia = JOptionPane.showInputDialog("Introduzca el día:\nEscriba FIN para finalizar.").toUpperCase();
                if(dia.equals("FIN")){
                    mostrar();
                    System.exit(0);
                }
                else{
                    String mes = JOptionPane.showInputDialog("Introduzca el mes:").toUpperCase();
                    String litros = JOptionPane.showInputDialog("Introduzca los litros de agua:").toUpperCase();
                    int idia = Integer.parseInt(dia)-1;
                    int imes = Integer.parseInt(mes)-1;
                    int ilitros = Integer.parseInt(litros);
                    guardar(idia,imes,ilitros);
                }
            }
            catch(NullPointerException | StringIndexOutOfBoundsException | NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El formato no es válido, si desea salir, escriba fin.");
                v=0;
            }
            catch( Exception e){
                JOptionPane.showMessageDialog(null, "Hay un error en los datos introducidos. Vuelva a introducir los datos.\nSi desea salir, escriba fin." + e.getMessage());
                v=0;
            }
        }
        while(v !=1);
    }

    public static void guardar(int Sdia, int Smes, int Slitros){
        datos[Smes][Sdia] = Slitros;
        v=0;
    }

    public static void mostrar(){
        String acumulados ="";
        
        int acumulador =0, m=0, n=0;
        for(int c=0; c<12; c++){
            acumulador=0;
            for(int cc=0; cc<31; cc++){
                acumulador = acumulador + datos[c][cc];
            }
            fdatos[c] = acumulador;
        }
           
        String nolluvia="";
        for(int y=0; y<fdatos.length; y++){
            if(fdatos[y] <= 0){
                nolluvia = nolluvia + ", " + (y+1);
                
            }else{
                if(fdatos[m]<fdatos[y])
                    m=y;
                else if(fdatos[m]>fdatos[y]){
                    n=y;
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, "El mes que más a llovido es " + (m+1) + ", el mes que menos a llovido es " + (n+1) + " y el/los no llovidos son: " + nolluvia + ".");
    }
}
