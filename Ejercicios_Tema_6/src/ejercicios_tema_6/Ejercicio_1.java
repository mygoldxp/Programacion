package ejercicios_tema_6;

import Recursos.Circunferencia;
import Excepciones.DatoMayor;
import java.text.DecimalFormat;
import javax.swing.*;
public class Ejercicio_1 {
    
    public static void Ejercicio1() throws Exception{
        boolean continuar = true;
        do{
            try{
                double x = Double.parseDouble(JOptionPane.showInputDialog("Introduzca la radio de la circunferencia:"));
                Circunferencia calc = new Circunferencia(x);
                if(x<=0){
                    throw new DatoMayor();
                }
                DecimalFormat df = new DecimalFormat("#.00");
                
                JOptionPane.showMessageDialog(null, "Los datos para de la radio " + x + " son lo siguiente:\n"
                + "Longitud: " + df.format(calc.getLongitud())
                + "\nÁrea: " + df.format(calc.getArea())
                + "\nVolumen: " + df.format(calc.getVolumen()));
                continuar = false;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El formato ha de ser numérico.");
            }
            catch(DatoMayor e){
                JOptionPane.showMessageDialog(null, "El valor ha de ser mayor que 0.");
            }
        }
        while(continuar);
    }   
}
