/*
Crea un programa que guarde informaci ´on sobre los trabajadores de
una empresa. De cada uno de ellos se quiere guardar el nombre, el
n´umero de la seguridad social y el tiempo que lleva en la empresa.
Cuando tengamos ya los datos de todos los empleados mostraremos
en pantalla el nombre del que m´as tiempo lleva.
 */
package ejercicios_tema_6;

import Excepciones.Errores;
import Recursos.Empleado;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class Ejercicio_3 {

    public static void Ejercicio3() throws Exception{
        ArrayList <Empleado> lista = new ArrayList();
        boolean continuar = true;  
        do{
            try{
                int x = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción para los empleados:\n1. Alta.\n2. Consulta.\n0. Salir."));
                switch(x){
                    case 1:
                        alta(lista);
                        break;
                        
                    case 2:
                        consulta(lista);
                        break;
                        
                    case 0:
                        continuar = false;
                        break;
                        
                    default:
                        JOptionPane.showMessageDialog(null, "El valor introducido no es válido.\nOpciones disponibles: 1, 2 y 0.");
                        break;
                }
            }
            catch(NullPointerException e){
                continuar = false;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El valor ha de ser numérico.");
                continuar = true;
            }
        }while(continuar);
    }
    
    public static void alta(ArrayList <Empleado> lista) throws Exception {
        String fecha="";
        try{
            String nom = JOptionPane.showInputDialog("Introduzca el nombre del empleado:\nVacío para salir.");
            validar(1 ,nom ,"^[A-Z][a-z]{2,}([ ][A-Z][a-z]{2,})*$");
            if(!nom.isEmpty()){
                String num = JOptionPane.showInputDialog("Introduzca el número de la seguridad social:");
                validar(2 ,num ,"^[0-9]{2}-[0-9]{8}-[0-9]{2}$");

            boolean continuar = true;
            do{
                try{
                    fecha = JOptionPane.showInputDialog("Introduzca el AÑO de alta:\nXXXX") + "-" +
                            String.valueOf(Integer.parseInt(JOptionPane.showInputDialog("Introduzca el MES de alta:\nXX")) + 100).substring(1) + "-" +
                            String.valueOf(Integer.parseInt(JOptionPane.showInputDialog("Introduzca el DÍA de alta:\nXX")) + 100).substring(1);
                    SimpleDateFormat fechas = new SimpleDateFormat("yyyy-MM-dd");
                    fechas.setLenient(false);
                    fechas.parse(fecha);
                    continuar = false;
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "La fecha introducida es incorrecta.");
                }
            }
            while(continuar);
            Empleado altas = new Empleado(nom, num, fecha);
            insertar(lista, altas);
            }
        }
        catch (Errores e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static void validar(int error, String valor, String condicion) throws Exception{
        Pattern patron = Pattern.compile(condicion);
        Matcher mat = patron.matcher(valor);
        if(!mat.matches()){
            throw new Errores(error);
        }
        
    }
    public static void insertar(ArrayList <Empleado> lista, Empleado altas) throws Exception{       
        lista.add(new Empleado(altas.getNombre(), altas.getSs(), altas.getFecha()));
    }
    
    public static void consulta(ArrayList <Empleado> lista) throws Exception{
        int x, y, n=0;
        try{
            x = Integer.parseInt(lista.get(n).getFecha().replaceAll("-", ""));
            for(int z=1; z<lista.size(); z++){
                y = Integer.parseInt(lista.get(z).getFecha().replaceAll("-", ""));
                if(y<x){
                    x = y;
                    n = z;
                }
            }
            JOptionPane.showMessageDialog(null, lista.get(n).toString());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "error " + e.getCause());
        }
    }
}
