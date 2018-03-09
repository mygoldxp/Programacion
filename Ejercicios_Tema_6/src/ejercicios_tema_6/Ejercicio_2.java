package ejercicios_tema_6;

import Excepciones.DatoMayor;
import Recursos.Alumno;
import java.lang.reflect.Array;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Ejercicio_2 {
    static int contador = 0, tam = 22;
    static Alumno lista [] = new Alumno [tam];
    static String listado = "";
    public static void Ejercicio2() throws Exception{
        boolean continuar = true;  
        listado="\nLos alumnos disponibles son:\n";
        do{
            try{
                int x = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción para los alumnos:\n1. Alta.\n2. Consulta.\n0. Salir."));
                switch(x){
                    case 1:
                        alta();
                        break;
                        
                    case 2:
                        consulta();
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
    
    public static void alta() throws Exception {
        int num = 0, telf = 0;
        String nom = "", dir = "";
        if(contador < tam){
            JOptionPane.showMessageDialog(null, "Ha registrado " + contador + " de los " + tam + " Alumnos de la clase.");
        try{
            String numero = JOptionPane.showInputDialog("Introduzca un Código para el Alumno:\nVacío para salir.");
            
            if(listado.contains(numero+",")){
                JOptionPane.showMessageDialog(null, "El alumno ya Existe.");
            }
            else if(numero.isEmpty()){
            
            }
            else{
            num = Integer.parseInt(numero);
            if(num<=0){
                throw new DatoMayor();
            }
            nom = JOptionPane.showInputDialog("Introduzca el nombre:").toUpperCase();
            dir = JOptionPane.showInputDialog("Introduzca la dirección:").toUpperCase();
            boolean continuar = true;
            do{
                try{
                    String comprobar = JOptionPane.showInputDialog("Introduzca el teléfono:");
                    telf = Integer.parseInt(comprobar);
                    if(comprobar.length()>= 9){
                        continuar = false;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "El teléfono ha de tener 9 carácteres.");
                    }
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "El valor ha de ser numérico e inferior a 11 dígitos.");
                }
            }
            while(continuar);
            
            Alumno altas = new Alumno(num, nom, dir, telf);
            listado += num + ", ";
            insertar(altas);
            }
        }
        catch(DatoMayor e){
            JOptionPane.showMessageDialog(null, "El valor ha de ser mayor que 0.");
        }
        }
        else{
            JOptionPane.showMessageDialog(null, "Ya ha ocupado todo el cupo de la clase, " + tam + " Alumnos.");
        }
    }
    
    public static void insertar(Alumno altas){
        
        lista[contador] = new Alumno(altas.getNum(), altas.getNom(), altas.getDir(), altas.getTelf());
        /*
        Opción 2
        lista[contador] = new Alumno();
        lista[contador].setNum(altas.getNum());
        lista[contador].setNom(altas.getNom());
        lista[contador].setDir(altas.getDir());
        lista[contador].setTelf(altas.getTelf());
        */
        
        contador++;
    }
    
    public static void consulta() throws Exception{
        int x=0;
        try{
            x = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el código del alumno:\n" + listado + "\n\n0 Para volver."));
            if(x>0){
                for(int y=0; y<tam; y++){
                    if(lista[y].getNum() == x ){
                        JOptionPane.showMessageDialog(null, "Los datos del alumno con el código " + x + " son lo siguiente:"+
                                "\nNombre: " + lista[y].getNom() + 
                                "\nDirección: " + lista[y].getDir() + 
                                "\nTeléfono: " + lista[y].getTelf());
                        y = tam;
                    }
                }
            }
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Alumno no encontrado.");
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "El valor ha de ser numérico.");
        }
    }
}
