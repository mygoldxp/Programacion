package ejercicios_tema_6;

import Excepciones.Errores;
import Recursos.Persona;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Ejercicio_4 {
    
    public static void Ejercicio4() throws Exception{
        ArrayList <Persona> lista = new ArrayList();
        boolean continuar = true;  
        do{
            try{
                int x = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción para los empleados:\n1. Alta.\n2. El Mayor.\n3. Los mayores de edad\n4. Viven en...\n0. Salir."));
                switch(x){
                    case 1:
                        alta(lista);
                        break;
                        
                    case 2:
                        mayor(lista);
                        break;
                    
                    case 3:
                        mayores(lista);
                        break;
                        
                    case 4:
                        vivir(lista, JOptionPane.showInputDialog("Buscar por ciudad:").toUpperCase());
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
    
    public static void alta(ArrayList <Persona> lista) throws Exception {
        
        try{
            String nom = JOptionPane.showInputDialog("Introduzca el nombre:\nVacío para salir.");
            validar(1 ,nom ,"^[A-Z][a-z]{2,}([ ][A-Z][a-z]{1,})*$");
            String fecha="", direccion="", cp="", ciudad="";
            if(!nom.isEmpty()){
            boolean continuar = true;
            do{
                try{
                    fecha = JOptionPane.showInputDialog("Introduzca el AÑO de nacimiento:\nXXXX") + "-" +
                            String.valueOf(Integer.parseInt(JOptionPane.showInputDialog("Introduzca el MES de alta:\nXX")) + 100).substring(1) + "-" +
                            String.valueOf(Integer.parseInt(JOptionPane.showInputDialog("Introduzca el DÍA de alta:\nXX")) + 100).substring(1);
                    SimpleDateFormat fechas = new SimpleDateFormat("yyyy-MM-dd");
                    fechas.setLenient(false);
                    fechas.parse(fecha);
                    continuar = false;
                    vfecha(fecha);
                    direccion = JOptionPane.showInputDialog("Introduzca la dirección:");
                    validar(3, direccion, "^[A-Z][a-z ]{3,}([ ][A-Z][a-z]{2,})*[0-9]{1,}[ ][0-9][a-z]$");
                    cp = JOptionPane.showInputDialog("Introduzca el código postal:\nXXXXX (Valores numéricos)");
                    validar(4, cp, "^[0-9]{5}$");
                    ciudad = JOptionPane.showInputDialog("Introduzca la ciudad:");
                    validar(5, ciudad, "^[A-Z][a-z ]+$");
                }

                catch(ParseException e){
                    JOptionPane.showMessageDialog(null, "La fecha introducida es incorrecta.");
                }
            }
            while(continuar);

            Persona altas = new Persona(nom, fecha, direccion, cp, ciudad);
            insertar(lista, altas);
            }    
        }
        catch(Errores e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static void vfecha(String dato){
        int x = 0, y;
        Date hoy = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
        y = Integer.parseInt(dato.replace("-", ""));
        int edad = Integer.parseInt(formateador.format(hoy))-y;
            if(edad < x ){
                String dia = String.valueOf(edad).replace("-", "");
                if(dia.equals("1")){
                    dia += " día.";
                }
                else{
                    dia += " días.";
                }
                JOptionPane.showMessageDialog(null, "La persona aún no ha nacido.\nLe falta " + dia);
            }
            else if(edad == x){
                JOptionPane.showMessageDialog(null, "Atención:\nLa persona ha nacido hoy.");
            }
    }
    public static void insertar(ArrayList <Persona> lista, Persona altas){       
        lista.add(altas);
    }
    
    public static void mayor(ArrayList <Persona> lista) throws Exception{
        int x, y, n=0;
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
    
    public static void mayores(ArrayList <Persona> lista) throws Exception{
        int x = 180000, y;
        String mayor="Las personas mayores de edad son:\n";
        Date hoy = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
        for(int z=0; z<lista.size(); z++){
            y = Integer.parseInt(lista.get(z).getFecha().replace("-", ""));
            int edad = Integer.parseInt(formateador.format(hoy))-y;
            if(edad >=x ){
                mayor += "\n" + lista.get(z).getNombre();
            }
        }
        JOptionPane.showMessageDialog(null, mayor);
    }
    
    public static void vivir(ArrayList <Persona> lista, String vive) throws Exception{
        String personas="Las personas que viven en " + vive + ", son:\n";
        for(int z=0; z<lista.size(); z++){
            if(vive.equals(lista.get(z).getCiudad())){
                personas += "\n" + lista.get(z).getNombre();
            }
        }
    JOptionPane.showMessageDialog(null, personas);
    }
    
    public static void validar(int error, String valor, String condicion) throws Exception{
        Pattern patron = Pattern.compile(condicion);
        Matcher mat = patron.matcher(valor);
        if(!mat.matches()){
            throw new Errores(error);
        }
    }
}
