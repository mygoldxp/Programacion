
package ejercicios_tema_5;

import javax.swing.JOptionPane;

public class Ejercicios_Tema_5 {

    public static void main(String[] args) {
        boolean continuar=true;
        do{
            try{
                String entrada = JOptionPane.showInputDialog("Introduzca el grupo de ejercicios:\n1-2");
                if(entrada.equals("")){
                    continuar=false;
                }else{
                    switch(Integer.parseInt(entrada))
                    {
                        case 1:
                            Ejercicio_1.Ejercicio1();
                            break;
                        case 2:
                            parte2();
                            break;
                        default:
                            break;
                    }
                }
            }
            catch(NullPointerException e){
                continuar=false;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El valor ha de ser numérico.");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "error: " + e.getClass());
            }
        }
        while(continuar);
    }
    
    public static void parte2() {
        boolean continuar=true;
        do{
            try{
                String entrada = JOptionPane.showInputDialog("Introduzca el ejercicio:\n1-9");
                if(entrada.equals("")){
                    continuar=false;
                }else{
                    switch(Integer.parseInt(entrada))
                    {
                        case 1:
                            P2Ejercicio_1.Ejercicio1();
                            break;
                        case 2:
                            P2Ejercicio_2.Ejercicio2();
                            break;
                        case 3:
                            P2Ejercicio_3.Ejercicio3();
                            break;
                        case 4: 
                            P2Ejercicio_4.Ejercicio4();
                            break;
                        case 5:
                            P2Ejercicio_5.Ejercicio5();
                            break;
                        case 6:
                            P2Ejercicio_6.Ejercicio6();
                            break;
                        case 7:
                            P2Ejercicio_7.Ejercicio7();
                            break;
                        case 8:
                            P2Ejercicio_8.Ejercicio8();
                            break;
                        case 9:
                            P2Ejercicio_9.Ejercicio9();
                            break;
                        default:
                            break;
                    }
                }
            }
            catch(NullPointerException e){
                continuar=false;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El valor ha de ser numérico.");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "error: " + e.getClass());
            }
        }
        while(continuar);
    }
}
