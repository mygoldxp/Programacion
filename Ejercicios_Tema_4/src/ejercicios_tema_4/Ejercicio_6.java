
package ejercicios_tema_4;

import javax.swing.JOptionPane;

public class Ejercicio_6 {
    
    static double monedas [] = {200, 100, 50, 20, 10, 5, 2, 1,0.50, 0.20, 0.10, 0.05, 0.02, 0.01};
    
    public static void Ejercicio6(){
        double x = 0;
        do{
            try{
                double cobrar = Double.parseDouble(JOptionPane.showInputDialog("Valor a cobrar:").replace(",", "."));
                double pagado = Double.parseDouble(JOptionPane.showInputDialog("Entregado por el cliente:").replace(",", "."));
                if(cobrar<pagado){
                    calcular(pagado,cobrar);
                }
                else if(cobrar==pagado){
                    JOptionPane.showMessageDialog(null, "No hay nada que devolver (0.00€)");
                }
                else{
                    JOptionPane.showMessageDialog(null, "El valor etregado por el cliente es inferior a cobrar.");
                }
            }
            catch(NullPointerException e){
                System.exit(0);
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El valor ha de ser numérico.");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        while(x!=1);
    }
    
    public static void calcular(double Cpagado, double Ccobrado){
        double devolver = Cpagado-Ccobrado;
        devolver = Double.parseDouble(String.format("%.2f",devolver).replace(",", "."));
        String resultado="Operación " + Ccobrado + " - " + Cpagado + " = a devolver al cliente " + devolver + "€";
        int contador=0;
        for(int x=0; x< monedas.length; x++){
            for(int y=1; monedas[x]<=devolver; y++){
                contador=y;
                devolver = devolver - monedas[x];
                devolver = Double.parseDouble(String.format("%.2f",devolver).replace(",", "."));
            }
            if(contador!=0){
                resultado= resultado + "\n" + String.format("%.2f", monedas[x]) + " X " + contador + ".";
            }
            contador=0;
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
}

