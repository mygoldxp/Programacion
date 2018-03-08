
package jon_xu;
import javax.swing.*;
import Excepciones.IvaException;
public class Jon_Xu {

    static double acumuladorsr=0, acumuladorr=0, acumuladorn=0, sumatorio=0;
    static final int superreducido=4, reducido=10, normal=21;
    static String factura = "NOMBRE: ";

    public static void main(String[] args) {
        try{
            do{
                factura = factura + JOptionPane.showInputDialog("Introduzca el nombre del cliente");
            }
            while(factura.length()==8);
            empezar();
            factura = factura + "\nTOTAL SIN IVA " + sumatorio + "\n\n" + impuestos();
            JOptionPane.showMessageDialog(null, factura);
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Voy a cerrarme.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hay un error " + e.getMessage());
        }
    }
    
    private static void empezar(){
        factura = factura + "\n\nLINEAS DE DETALLE:\n\n";
            int x= 0;
            do{
                x=entrada();
            }
            while(x != 1);
    }
    private static int entrada(){
        int x=0;
        do{
            try{
                //añadido por el fallo de nullpointerexception
                String entrada = JOptionPane.showInputDialog("Introduzca la cantidad:\nTeclea / para finalizar.");
                if(entrada.equals("/") || entrada.equals("")){
                    x=1;
                }
                else{
                    int cantidad = Integer.parseInt(entrada);
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el precio:\nCancelar para finalizar."));
                    int iva = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el IVA (" + superreducido + ", " + reducido + " o " + normal +"):"));
                    if(iva==superreducido || iva==reducido ||iva==normal ){
                        acumular(cantidad, precio, iva);
                    
                    }else
                    {
                        throw new IvaException();
                    }
                }
            }
            catch (NullPointerException e){
                x=1;
            }
            catch(IvaException e){
                JOptionPane.showMessageDialog(null, "El IVA tiene que ser " + superreducido + ", " + reducido + " o " + normal +".");
                x=0;
            }
            
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El formato ha de ser numérico.");
                x=0;
            }
        }
        while(x!=1);
        return x;
    }
    
    private static void acumular(int Acantidad, double Aprecio, int Aiva){
        double suma = Acantidad * Aprecio;
        sumatorio = sumatorio + suma;
        factura = factura + "          " + Acantidad + " x " + Aprecio + " = " + suma + "\n";

        switch(Aiva){
            case superreducido:
                acumuladorsr = acumuladorsr + suma;
                break;
            case reducido:
                acumuladorr = acumuladorr + suma;
                break;
            case (int) normal:
                acumuladorn = acumuladorn + suma;
                break;
        }
    }
    
    private static String impuestos(){
        String totales="";
        if(acumuladorsr!=0){
            totales= totales + "          " + superreducido + "% de " + acumuladorsr + " = " + (acumuladorsr/100*superreducido) + "\n";
        }
        if(acumuladorr!=0){
            totales= totales + "          " + reducido + "% de " + acumuladorr + " = " + (acumuladorr/100*reducido) + "\n";
        }
        if(acumuladorn!=0){
            totales= totales + "          " + acumuladorn + "% de " + acumuladorn + " = " + (acumuladorn/100*acumuladorn) + "\n";
        }
        double suma = (acumuladorsr/100*superreducido) + (acumuladorr/100*reducido) + (acumuladorn/100*normal);
        totales = totales + "\nTOTAL IVA " + suma + "\n\nTOTAL CON IVA " + (sumatorio + suma);
        return totales;
        
    }
    
    
}
