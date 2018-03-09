package ejercicios_tema_4;

import javax.swing.JOptionPane;

public class Ejercicio_8 {
    static final int p= 10;
    static int datos[][] = new int [p][2];
    static int ordenado[][]= new int [p][2];
    
    private static void altaproductos(){
        datos[0][0] = 10;
        datos[1][0] = 23;
        datos[2][0] = 30;
        datos[3][0] = 47;
        datos[4][0] = 55;
        datos[5][0] = 65;
        datos[6][0] = 135;
        datos[7][0] = 256;
        datos[8][0] = 526;
        datos[9][0] = 663;
    }
    
    public static void Ejercicio8(){
        altaproductos();
        int x=0;
        do{
            try{
                double codigos = Double.parseDouble(JOptionPane.showInputDialog("Introduzca la Referencia del producto:\nCancelar para obtener el resultado del dia."));
                int codigo = (int)codigos;
                codigo = comprobar(codigo);
                if(codigo!=99999){
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la Cantidad del producto:"));
                    insertar(codigo,cantidad);
                }
                else{
                    JOptionPane.showMessageDialog(null, "El código introducido no existe.");
                }
            }
            catch(NullPointerException e){
                mostrar();
                ordenar();
                mostrar2();
                x=1;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El valor ha de ser numérico.");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Existe un error: " + e.getMessage());
            }
        }
        while(x!=1);
    }
    
    private static int comprobar(int Ccodigo){
        int y=99999;
        for(int x=0; x< p; x++){
            if(datos[x][0] == Ccodigo){
                y=x;
                x=p;
            }
            else{
                y=99999;
            }
        }
        return y;
    }
    
    private static void insertar(int Icodigo, int Icantidad){
        datos[Icodigo][1] = datos[Icodigo][1] + Icantidad;
    }
    
    private static void ordenar(){
        int codigo, cantidad=0, fila=0;
        for(int x=0;x <p; x++){
            for(int y=0;y <p; y++){
                if(cantidad<datos[y][1]){
                cantidad=datos[y][1];
                fila=y;
                }
            }
            codigo=datos[fila][0];
            datos[fila][1]=0;
            tabla(x, codigo, cantidad);
            cantidad=0;
        }
    }
    
    private static void tabla(int Tfila, int Tcodigo, int Tcantidad){
        ordenado[Tfila][0]=Tcodigo;
        ordenado[Tfila][1]=Tcantidad;
        
    }
    
    private static void mostrar(){
        String mensaje="Los datos son:";
        for(int x=0; x<p; x++){
            mensaje= mensaje + "\n" + datos[x][0] + " X " + datos[x][1];
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    private static void mostrar2(){
        String mensaje="Los datos ordenados son:";
        for(int x=0; x<p; x++){
            if(ordenado[x][1]!=0){
                mensaje= mensaje + "\n" + ordenado[x][0] + " X " + ordenado[x][1];
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

}
