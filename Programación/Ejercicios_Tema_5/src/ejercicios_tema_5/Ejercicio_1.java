
package ejercicios_tema_5;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Ejercicio_1 {
    
    static ArrayList <Float> lista ;
    
    public static void Ejercicio1(){
        lista = new ArrayList();
        boolean continuar = true;
        do{
            try{
                entrada();
                menu();
                continuar=false;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error en main: " + e.getCause());
            }
        }
        while(continuar);
    }
    
    public static void entrada() throws Exception{
        boolean continuar = true;
        do{
            try{
                float dato = Float.parseFloat(JOptionPane.showInputDialog("Introduzca un valor numérico:\nCancelar para finalizar introducción de datos."));
                lista.add(dato);
            }
            catch(NullPointerException e){
                continuar=false;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El formato ha de ser numérico.");
            }
        }
        while(continuar);
    }
    
    public static float entradanumero() throws Exception{
        boolean x= true;
        float y = 0;
        do{
            try{
                y = Float.parseFloat(JOptionPane.showInputDialog("Introduzca un número:"));
                x=false;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El valor ha de ser numérico.");
                x= true;
            }
            catch(NullPointerException e){
                JOptionPane.showMessageDialog(null, "El valor ha de ser numérico.");
                x= true;
            }
        }while(x);
        return y;
    }
    
    public static void menu() throws Exception{
        boolean continuar = true;
        do{
            try{
                int op = Integer.parseInt(JOptionPane.showInputDialog("Introduzca una opción:"
                        + "\n1.Visualizar el valor máximo y el mínimo."
                        + "\n2. Solicitar un número y buscarlo. Posteriormente muestra un mensaje indicando si lo has encontrado o no."
                        + "\n3. Solicitar un número y buscarlo. Si se encuentra borrarlo, sino mostrar un mensaje de error."
                        + "\n4. Convertir el arrayList en un array."
                        + "\n5. Si no esta vacío, mostrar el número de elementos que contiene."
                        + "\n6. Insertar un nuevo elemento por el final."
                        + "\n7. Insertar un nuevo elemento en la posición qte te indique el usuario."
                        + "\n8.Borrar un elemento de una posición concreta."
                        + "\n9. Calcular la suma y la media aritmética de los valores contenidos."
                        + "\n10. Finalizar."));
                switch(op){
                    case 1:
                        visualizar();
                        break;
                    case 2:
                        buscar();
                        break;
                    case 3:
                        buscarB();
                        break;
                    case 4:
                        convertir();
                        break;
                    case 5:
                        vacio();
                        break;
                    case 6:
                        insertar();
                        break;
                    case 7:
                        ivalor();
                        break;
                    case 8:
                        borrarc();
                        break;
                    case 9:
                        calcular();
                        break;
                    case 10:
                        continuar=false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "La opción elegida no existe. 1- 10.");
                        break;
                }
            }
            catch(NullPointerException e){
                continuar=false;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El valor ha de ser numérico.");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error en panel: " + e.getClass());
            }
        }
        while(continuar);
    }
    
    public static void visualizar(){
        JOptionPane.showMessageDialog(null, "El valor máximo es " + Collections.max(lista) + " y el valor mínimo es " + Collections.min(lista));
    }
    
    public static void buscar() throws Exception{

        if(lista.contains(entradanumero())){
            JOptionPane.showMessageDialog(null, "El valor SI existe.");
        }
        else{
            JOptionPane.showMessageDialog(null, "El valor NO existe.");
        }
    }
    
    public static void buscarB() throws Exception{
        float valor = entradanumero();
        if(lista.contains(valor)){
            lista.remove(valor);
            JOptionPane.showMessageDialog(null, "Se ha borrado el valor " + valor);
        }
        else{
            JOptionPane.showMessageDialog(null, "El valor NO existe, no se ha borrado.");
        }
    }
    
    public static void convertir() throws Exception{
        Object[] listaarray = lista.toArray();
        JOptionPane.showMessageDialog(null, "Operación realizada correctamente.");
        String vista = "A continuación se muestra los datos del Array:";
        for(int x=0; x<listaarray.length; x++){
            vista=vista + "\n" + listaarray[x];
        }
        JOptionPane.showMessageDialog(null, vista);
    }
    
    public static void vacio(){
        if(lista.isEmpty()){
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        }
        else{
            JOptionPane.showMessageDialog(null, "La lista tiene " + lista.size() + " valores.");
        }
    }
    
    public static void insertar() throws Exception{
        
        lista.add(entradanumero());
        
    }
    
    public static void ivalor() throws Exception{
        boolean continuar = true;
        do{
            try{
                int columna = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la columna:"));
                float dato = entradanumero();
                lista.add(columna, dato);
                continuar=false;
            }
            catch(NullPointerException e){
                continuar=false;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El formato ha de ser numérico.");
                continuar=true;
            }
        }
        while(continuar);
    }
    
    public static void borrarc() throws Exception{
        boolean continuar = true;
        do{
            try{
                int columna = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la columna a eliminar:"));
                lista.remove(columna);
                continuar=false;
            }
            catch(NullPointerException e){
                continuar=false;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El formato ha de ser numérico.");
                continuar=true;
            }
        }
        while(continuar);
    }
    
    public static void calcular() throws Exception{
        float suma=0;
        for(float extraido : lista){
            suma = suma + extraido;
        }
        JOptionPane.showMessageDialog(null, "La suma es " + suma + " y la media es " + (suma/lista.size()));
    }
}
