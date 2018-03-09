/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_2;

import javax.swing.*;
import java.text.SimpleDateFormat;
import ejercicio_2.Ejercicio_7;
import ejercicio_2.Ejercicio_8;


/**
 *
 * @author v6222
 */
public class Ejercicio_2 {

    /**
     * @param args the command line arguments
     */
 public static void main(String[] args) {
        // TODO code application logic here
        int ejercicio=0;
        String salida="";
        do{
        try{
        salida = JOptionPane.showInputDialog("Ejercicio:\nEjercicios 1-8\n9=7 y 10=8 Mejor estructurados.\nFIN para salir.");
        salida = salida.toUpperCase();
        ejercicio = Integer.parseInt(salida);
        }
        catch(Exception menu)
        {
            if(salida.equals("FIN"))
            {
                System.exit(0);
            }
            JOptionPane.showMessageDialog(null, "El ejercicio ha de ser numérico.\n" + menu.getMessage() +". " +  menu.getClass() +". "+ menu.getCause());
        }
        switch(ejercicio)
       {
           case 1:
                  ejercicio_1();
                  break;
            case 2:
                  ejercicio_2();
                  break;
            case 3:
                  ejercicio_3(1);
                  break;
            case 4:
                  ejercicio_4();
                  break;
            case 5:
                ejercicio_5();
                break;
            case 6:
                ejercicio_6();
                break;
            case 7:
                ejercicio_7();
                break;
            case 8:
                ejercicio_8();
                break;
            case 9:
                Ejercicio_7.Ejercicio7();
                break;
            case 10:
                Ejercicio_8.Ejercicio8();
                break;
       }}
        while(ejercicio > 11 || ejercicio < 1);
    }
    static public void ejercicio_1()
    {try{
        String  nombre, combinacion, estado="", estudios;
        int salario=10, horas=0, extras = 15, normal=40;
        nombre= JOptionPane.showInputDialog("Nombre del empleado");
        do{
        estado= JOptionPane.showInputDialog("Estado Civil del Empleado (S=Soltero, C=Casado, V=Viudo, D=Divorciado)");
        estado=estado.toUpperCase();
        } while(estado !="S" && estado !="C" && estado !="V" && estado !="D");
        
        do{
        estudios= JOptionPane.showInputDialog("Estudios del Empleado (P=Primario, M=Medio, S=Superior)");
            estudios=estudios.toUpperCase();    
        
        }while(estudios !="P" &&estudios !="M" &&estudios !="S");
        horas = Integer.parseInt(JOptionPane.showInputDialog("Horas trabajados"));
        if(horas>normal)
        {
        horas=horas-normal;
        salario = horas * extras + normal * salario;
        }
        else
        {
        salario = horas * salario;
        }
        combinacion = String.valueOf(estado + estudios);
        
        
        if(combinacion.equals("SP") || combinacion.equals("VS") || combinacion.equals("SM") || combinacion.equals("CS") || combinacion.equals("VP")
             || combinacion.equals("SS") || combinacion.equals("DS") )
        {
        salario = salario + 100;
        }
      JOptionPane.showMessageDialog(null, "El empleado " + nombre + ", tiene de salario " + salario);
    }
    catch(NumberFormatException e){
    JOptionPane.showMessageDialog(null, "El número introducido es incorrecto");
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e.getClass() + e.getMessage());
    }
    }
    static public void ejercicio_2()
    {
    int nota=0;
    String a="n", n="";
    n=JOptionPane.showInputDialog("Introduzca el nombre del Trabajador:");
    a=JOptionPane.showInputDialog("VisualBasic.NET, S=APTO, N=NO APTO");
    a=a.toUpperCase();
    if(a.equals("S"))
    {
        a="N";
        nota=nota+1;
    }
    a=JOptionPane.showInputDialog("Cobol, S=APTO, N=NO APTO");
    a=a.toUpperCase();
    if(a.equals("S"))
    {
        a="N";
        nota=nota+3;
    }
    a=JOptionPane.showInputDialog("Java, S=APTO, N=NO APTO");
    a=a.toUpperCase();
    if(a.equals("S"))
    {
        a="N";
        nota=nota+1;
    }
    a=JOptionPane.showInputDialog("SQL, S=APTO, N=NO APTO");
    a=a.toUpperCase();
    if(a.equals("S"))
    {
        a="N";
        nota=nota+5;
    }
    notas(nota);
    }
    public static void notas(int n)
    {
    switch(n)
    {
        case 1:
            JOptionPane.showMessageDialog(null, n + " = Insuficiente");
            break;
        case 2:
            JOptionPane.showMessageDialog(null, n + " = Insuficiente");
            break;
        case 3:
            JOptionPane.showMessageDialog(null, n + " = Insuficiente");
            break;
        case 4:
            JOptionPane.showMessageDialog(null, n + " = Suficiente");
            break;
        case 5:
            JOptionPane.showMessageDialog(null, n + " = Insuficiente");
            break;
        case 6:
            JOptionPane.showMessageDialog(null, n + " = Suficiente");
            break;
        case 7:
            JOptionPane.showMessageDialog(null, n + " = Insuficiente");
            break;
        case 8:
            JOptionPane.showMessageDialog(null, n + " = Bien");
            break;
        case 9:
            JOptionPane.showMessageDialog(null, n + " = Notable");
            break;
        case 10:
            JOptionPane.showMessageDialog(null, n + " = Sobresaliente");
            break;
        default:
            System.exit(0);
    }
    }
static int ganancia=0;
    public static void ejercicio_3(int n)
    {
        int unidad=0, precio=0, total=0,  porcentaje=10;
        switch(n)
    {
        case 1:
            unidad = Integer.parseInt(JOptionPane.showInputDialog("Introduzca unidad"));
            precio = Integer.parseInt(JOptionPane.showInputDialog("Introduzca precio"));
            total = unidad * precio;
            JOptionPane.showMessageDialog(null, "Total a pagar " + total + "€");
            ganancia=ganancia + total;
            int resp = JOptionPane.showConfirmDialog(null,"¿Desea continuar?", "Ventas",JOptionPane.YES_NO_OPTION,1);
            if (resp == JOptionPane.YES_OPTION) 
            {
            ejercicio_3(1);
            }
            else
            {
            ejercicio_3(2);
            }
            break;
        case 2:
            
            ganancia=(ganancia/100)*porcentaje;
            JOptionPane.showMessageDialog(null, "El total de ganancia del dia son " + ganancia + "€");
            break;
    }
    }
    public static void ejercicio_4()
    {
        float metro=0, balcon=0, ventana=0, anos=0, total=0;
        float pmetro=1, pbalcon=0.5f, pventana=0.25f, dto10=10, dto20=20;

            metro=Integer.parseInt(JOptionPane.showInputDialog("Introduzca los metros cuadrados"));
            balcon=Integer.parseInt(JOptionPane.showInputDialog("Introduzca los nº de balcones"));
            ventana=Integer.parseInt(JOptionPane.showInputDialog("Introduzca los nº de ventanas"));
            anos=Integer.parseInt(JOptionPane.showInputDialog("Introduzca los años de antiguedad"));
            total=(metro*pmetro) + (balcon*pbalcon) + (ventana*pventana);
            if(anos>20)
            {
            total=total - ((total/100)*dto20);
            }
            else if(anos>10)
            {
            total=total - ((total/100)*dto10);
            }
            int resp = JOptionPane.showConfirmDialog(null, "El impuesto total de la vivienda son " + total + "€.\n¿Desea continuar?" );

            if (resp == JOptionPane.YES_OPTION) 
            {
            ejercicio_4();
            }
            else
            {
            System.exit(0);
            }
    }
    public static void ejercicio_5()
    {
        try{
        int o=0;
     float n1=0, n2=0, total=0;
        o = Integer.parseInt(JOptionPane.showInputDialog("Introduzca una opción:\n1.-Sumar dos números\n2.-Restar dos números\n3.-Visualizar la tabla de multiplicar de un número"
                + "\n4.-Visualizar el cociente y el resto  de una división\n5.-Salir del programa"));
        switch(o)
        {
            case 1:
                n1= Float.parseFloat(JOptionPane.showInputDialog("Primer número"));
                n2= Float.parseFloat(JOptionPane.showInputDialog("segundo número"));
                JOptionPane.showMessageDialog(null, "El resultado de la suma es " + total);
                ejercicio_5();
                break;
            case 2:
                n1= Float.parseFloat(JOptionPane.showInputDialog("Primer número"));
                n2= Float.parseFloat(JOptionPane.showInputDialog("segundo número"));
                JOptionPane.showMessageDialog(null, "El resultado de la resta es " + total);
                ejercicio_5();
                break;
            case 3:
                n1= Integer.parseInt(JOptionPane.showInputDialog("Introduzca número para ver su tabla hasta x10"));
                JOptionPane.showMessageDialog(null, "La tabla hasta x10 del número introducido son: \n" + 
                "x1= "+ (int)(n1*1) + "\n" +
                "x2= "+ (int)(n1*2) + "\n" +
                "x3= "+ (int)(n1*3) + "\n" +
                "x4= "+ (int)(n1*4) + "\n" +
                "x5= "+ (int)(n1*5) + "\n" +
                "x6= "+ (int)(n1*6) + "\n" +
                "x7= "+ (int)(n1*7) + "\n" +
                "x8= "+ (int)(n1*8) + "\n" +
                "x9= "+ (int)(n1*9) + "\n" +
                "x10= "+ (int)(n1*10) + "\n" + "FIN"
                );
                ejercicio_5();
                break;
            case 4:
                n1= Float.parseFloat(JOptionPane.showInputDialog("Introduzca número:"));
                n2= Float.parseFloat(JOptionPane.showInputDialog("número anterior dividido entre:"));
                int c = (int)n1 / (int)n2;
                float r = n1%n2;
                JOptionPane.showMessageDialog(null, "El cociente es " + c + " y  el resto es " + r);
                ejercicio_5();
                break;
            case 5:
                System.exit(0);
            default:
                JOptionPane.showMessageDialog(null, "El número introducido no es válido, voy a cerrarme");
                System.exit(0);
                                   
        }
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null,"El valos introducido no es válido, voy a cerrarme!!!");
    }}
    
    static String d="";
    static boolean result=false;
    static public void ejercicio_6(){
    try{
    d = JOptionPane.showInputDialog("Introduzca la fecha (XX/XX/XXXX)");
    ComprobarFecha();
    if (ComprobarFecha()==true){
    JOptionPane.showMessageDialog(null, "La fecha introducida es correcta");
    System.exit(0);
    }
    else
    {
    JOptionPane.showMessageDialog(null, "La fecha introducida es incorrecta");
    System.exit(0);
    }
    }

    catch(Exception e){
    JOptionPane.showMessageDialog(null, e.getClass() + e.getMessage());
    }
    }
    
    
    static public boolean ComprobarFecha(){
        try {
            SimpleDateFormat CFecha = new SimpleDateFormat("dd/MM/yyyy");
            CFecha.setLenient(false);
            CFecha.parse(d);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    
public static String notas="Las notas son lo siguiente:\n";
public static float media=0;
public static int contador=0;
    public static void ejercicio_7(){
    
    String nombre = JOptionPane.showInputDialog("Nombre del alumno:");
    if(nombre.equals("FIN") || nombre.equals("fin"))
        {
            NotaFinal();
        }
        else
        {
            notas = notas + nombre + "\t";
            contador++;
            RecibeDatos();
        }
    }
    public static void RecibeDatos() {
         
        float asignatura = 0f, asignaturas=0f;
        for(int c = 1; c<7; c++)
        {
        boolean pasar = true;
      
        do{
              try{
            asignatura = 0;
            pasar = true;
            asignatura = Float.parseFloat(JOptionPane.showInputDialog("Introduzca nota asignatura " + c + ":"));
        if(asignatura < 0 || asignatura > 10)
        {
            JOptionPane.showMessageDialog(null, "La nota ha de estar comprendido entre el 0 y el 10. Por defecto es 0.");
            pasar = false;
        }

        }
        catch(NumberFormatException e){
           JOptionPane.showMessageDialog(null, e.getClass() + e.getMessage());
           pasar = false;
        }
                }
        while(!pasar);
        notas = notas + " + " + asignatura;
        asignaturas= asignaturas + asignatura;
        }
       
        asignaturas= asignaturas/6;
        media=media + asignaturas;
        notas=notas + " = " + asignaturas + "\n";
        ejercicio_7();
        
    }
    
    
    public static void NotaFinal(){
    media = media/contador;
    notas=notas + "Total nota media final de " + contador + " alumnos es: " + media;
    JOptionPane.showMessageDialog(null, notas);
    System.exit(0);
    }
    
    static int ad1=0, ad2=0, ad3=0;
    static int r1=0, r2=0, r3=0;
    static String generado="", extraer="";
    public static void ejercicio_8()
    {
        int aad1=0, aad2=0, aad3=0;
        do
        {
        aad1 = (int) (Math.random()*8)+1;
        aad2 = (int) (Math.random()*8)+1;
        aad3 = (int) (Math.random()*8)+1;
        }
        while(aad1==aad2 || aad1==aad3 || aad2==aad3 );
        generado = aad1 +""+ aad2+"" + aad3;
        JOptionPane.showMessageDialog(null, generado);
        jugar();
    }
    public static void asignar()
    {
        ad1 = generado.charAt(0);
        ad2 = generado.charAt(1);
        ad3 = generado.charAt(2);
        r1 = extraer.charAt(1);
        r2 = extraer.charAt(2);
        r3 = extraer.charAt(3);
    }
public static void jugar()
{
    try{
        String entrada = JOptionPane.showInputDialog("Jugamos a Muertos y Heridos, introduce un número de 3 digitos XXX, FIN para salir del juego:");
        if(entrada.equals("FIN") || entrada.equals("fin"))
        {
        System.exit(0);
        }
        int numero = Integer.parseInt(entrada);
        if(numero<0 || numero > 999)
        {
        JOptionPane.showMessageDialog(null, "Los datos ha de estar comprendidos entre el 0 y el 999.");
        //jugar();
//        throw new DatosIncorrectos();
        }
        else
        {
        numero = numero + 1000;
        extraer = String.valueOf(numero);
        asignar();
        comparar();
        }
    }
    catch(NumberFormatException e)
    {
    JOptionPane.showMessageDialog(null, "Los datos han de ser numéricos o FIN para salir del juego.");
    jugar();
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e.getClass() + e.getMessage());
    }
}
public static void comparar(){
    int m=0, h=0;
    if(ad1==r1)
    {
        ad1=0;
        m++;
    }
    if(ad2==r2)
    {
        ad2=0;
        m++;
    }
    if(ad3==r3)
    {
        ad3=0;
        m++;
    }
    if(ad1==r2 || ad1==r3)
    {
        ad1=0;
        h++;
    }
    if(ad2==r1 || ad2==r3)
    {
        ad2=0;
        h++;
    }
    if(ad3==r2 || ad3==r1)
    {
        ad3=0;
        h++;
    }
    if(m==3)
    {
        JOptionPane.showMessageDialog(null, "Enhorabuena, Has Acertado. Fin del Juego");
        System.exit(0);
    }
    else
    {
        JOptionPane.showMessageDialog(null, "Vaya, " + m + " muertos y " + h + " heridos. Inténtalo de nuevo.");
        jugar();
    }
    }
}
