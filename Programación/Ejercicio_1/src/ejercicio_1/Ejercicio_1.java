/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_1;

import java.io.IOException;
import javax.swing.*;
import java.util.Scanner;
import java.io.InputStreamReader;

/**
 *
 * @author v6222
 */
public class Ejercicio_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        //BufferedReader br = new BufferedReader (new InputStreamReader.(System.in));
        // TODO code application logic here
        /*
        int n1, n2 = 7;
        float n3=5.6f;
        long n4;
        char caracter;
        caracter = 's';
        String mensaje = "Hola";
        boolean seguir = true;
        System.out.println("Dime si o no");
        char respuesta = (char)System.in.read();
        int resultado = respuesta + 3;
        System.out.println(resultado);
        System.out.println("Me has dicho " + respuesta);
        */
        
        /*
        JOptionPane.showMessageDialog(null, "Hola Jon");
        String edad = JOptionPane.showInputDialog("Dime tu edad");
        int edadnumero = Integer.parseInt(edad);
        edadnumero = edadnumero + 1;
        JOptionPane.showMessageDialog(null, "Mañana cumples " + edadnumero + " años.");
        */
        /*
        Scanner TECLADO = new Scanner(System.in);
        String PALABRA; 
        System.out.print("INGRESE UNA PALABRA : ");
        PALABRA = TECLADO.nextLine();
        JOptionPane.showMessageDialog(null, "Hola Jon, has tecleado " + PALABRA);
        */
    byte e = Byte.parseByte(JOptionPane.showInputDialog("Introduzca el número de ejercicio (1-22; 92 y 102 para ejercicios opción 2 de las mismas.)"));
    switch (e)
    {
        case 1:
        Ejercicio_1();
        break;
        case 2:
        Ejercicio_2();
        break;
        case 3:
        Ejercicio_3();
        break;
        case 4:
        Ejercicio_4();
        break;
        case 5:
        Ejercicio_5();
        break;
        case 6:
        Ejercicio_6();
        break;
        case 7:
        Ejercicio_7();
        break;
        case 8:
        Ejercicio_8();
        break;
        case 9:
        Ejercicio_9();
        break;
        case 9_2:
        Ejercicio_9_2();
        break;
        case 10:
        Ejercicio_10();
        break;
        case 10_2:
        Ejercicio_10_2();
        break;
        case 11:
        Ejercicio_11();
        break;
        case 12:
        Ejercicio_12();
        break;
        case 13:
        Ejercicio_13();
        break;
        case 14:
        Ejercicio_14();
        break;
        case 15:
        Ejercicio_15();
        break;
        case 16:
        Ejercicio_16();  
        break;
        case 17:
        Ejercicio_17();
        break;
        case 18:
        Ejercicio_18();
        break;
        case 19:
        Ejercicio_19();
        break;
        case 20:
        Ejercicio_20();
        break;
        case 21:
        Ejercicio_21();
        break;
        case 22:
        Ejercicio_22();     
        break;
        default:
            System.exit(0);
    }
    }
        
        static public void Ejercicio_1(){
        String mensaje = JOptionPane.showInputDialog("Introduzca un texto");
        JOptionPane.showMessageDialog(null, "Has introducido " + mensaje);
        }
        
        public static void Ejercicio_2(){
        
        JOptionPane.showMessageDialog(null, "Vamos a multiplicar 2 números");
        String n1 = JOptionPane.showInputDialog("Introduzca número 1:");
        String n2 = JOptionPane.showInputDialog("Introduzca número 2:");
        int  rr = Integer.parseInt(n1) * Integer.parseInt(n2) ;
        JOptionPane.showMessageDialog(null, n1 + " X " + n2 + " = " + rr);
        }
        
        public static void Ejercicio_3(){
        
        JOptionPane.showMessageDialog(null, "Vamos a calcular el perímetro de un rectángulo");
        String n1 = JOptionPane.showInputDialog("Introduzca altura:");
        String n2 = JOptionPane.showInputDialog("Introduzca base:");
        int  r = (Integer.parseInt(n1) * 2) + (Integer.parseInt(n2) * 2);
        JOptionPane.showMessageDialog(null, "El perímetro es " + r);
        }
        
        public static void Ejercicio_4()
        {
        JOptionPane.showMessageDialog(null, "Vamos a calcular el área de un rombo");
        String n1 = JOptionPane.showInputDialog("Introduzca diagonal 1:");
        String n2 = JOptionPane.showInputDialog("Introduzca diagonal 2:");
        int  r = Integer.parseInt(n1) * Integer.parseInt(n2) / 2;
        JOptionPane.showMessageDialog(null, "El área es " + r);
        }
        public static void Ejercicio_5()
        {
        JOptionPane.showMessageDialog(null, "Introduce los ºC y te lo mostraré en ºF");
        String n1 = JOptionPane.showInputDialog("Introduzca los grados a calcular:");
        double r = 1.8 * Integer.parseInt(n1) + 32;
        JOptionPane.showMessageDialog(null, "El resultado es " + r + " ºF");
        }
        public static void Ejercicio_6()
        {
        JOptionPane.showMessageDialog(null, "Vamos a calcular el área de una circunferencia");
        double n1 = Double.parseDouble(JOptionPane.showInputDialog("Introduzca su radio:"));
        double  r = Math.PI * Math.pow(n1, 2);
        JOptionPane.showMessageDialog(null, "El área es " + r);
        }
        public static void Ejercicio_7()
        {
        JOptionPane.showMessageDialog(null, "Vamos a calcular la hipotenusa de un triángulo rectángulo");
        String n1 = JOptionPane.showInputDialog("Introduzca cateto 1:");
        String n2 = JOptionPane.showInputDialog("Introduzca cateto 2:");
        double r = Math.sqrt((Integer.parseInt(n1)* Integer.parseInt(n1)) + (Integer.parseInt(n2) * Integer.parseInt(n2)));
        JOptionPane.showMessageDialog(null, "El área es " + r);
        }
        public static void Ejercicio_8()
        {
        JOptionPane.showMessageDialog(null, "Le indicaré si has Aprobado o has Suspendido");
        String n1 = JOptionPane.showInputDialog("Introduzca su nota:");
        int r = Integer.parseInt(n1);
        if (r >= 5)
        {
        JOptionPane.showMessageDialog(null, "Has aprobado con un " + r);
        }
        else
        {
        JOptionPane.showMessageDialog(null, "Has suspendido con un " + r);
        }
        }
        public static void Ejercicio_9()
        {
        JOptionPane.showMessageDialog(null, "Le indicaré su calificación");
        String n1 = JOptionPane.showInputDialog("Introduzca su nota:");
        int r = Integer.parseInt(n1);
        if (r < 1)
        {
        JOptionPane.showMessageDialog(null, "muy deficiente");
        }
        else if (r < 5)
        {
        JOptionPane.showMessageDialog(null, "insuficiente");
        }
        else if (r == 5)
        {
        JOptionPane.showMessageDialog(null, "suficiente");
        }
        else if (r < 7)
        {
        JOptionPane.showMessageDialog(null, "bien");
        }
        else if (r < 8)
        {
        JOptionPane.showMessageDialog(null, "notable");
        }
        else if (r > 8)
        {
        JOptionPane.showMessageDialog(null, "sobresaliente");
        }   
        }
        public static void Ejercicio_9_2()
        {
        JOptionPane.showMessageDialog(null, "Le indicaré su calificación");
        String n1 = JOptionPane.showInputDialog("Introduzca su nota:");
        int r = Integer.parseInt(n1);
        switch(r)
        {
            case 1: case 2:
                JOptionPane.showMessageDialog(null, "muy deficiente");
                break;
            case 3: case 4:
                JOptionPane.showMessageDialog(null, "deficiente");
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "suficiente");
                break;                
            case 6: case 7:
                JOptionPane.showMessageDialog(null, "bien");
                break;                
            case 8: case 9:
                JOptionPane.showMessageDialog(null, "notable");
                break;
            case 10:
                JOptionPane.showMessageDialog(null, "sobresaliente");
                break;
            default:
                break;
        }
        }
        public static void Ejercicio_10()
        {
        JOptionPane.showMessageDialog(null, "Intro del 1 al 7 y te diré el nombre del día de la semana");
        String n1 = JOptionPane.showInputDialog("Día de la semana:");
        int r = Integer.parseInt(n1);
        if (r == 1)
        {
        JOptionPane.showMessageDialog(null, "Lunes");
        }
        else if (r == 2)
        {
        JOptionPane.showMessageDialog(null, "Martes");
        }
        else if (r == 3)
        {
        JOptionPane.showMessageDialog(null, "Miércoles");
        }
        else if (r == 4)
        {
        JOptionPane.showMessageDialog(null, "Jueves");
        }
        else if (r == 5)
        {
        JOptionPane.showMessageDialog(null, "Viernes");
        }
        else if (r == 6)
        {
        JOptionPane.showMessageDialog(null, "Sábado");
        }
        else if (r == 7)
        {
        JOptionPane.showMessageDialog(null, "Domingo");
        }
        }
        public static void Ejercicio_10_2()
        {
        byte n1 = Byte.parseByte(JOptionPane.showInputDialog("Indica número de la semana:"));
        switch(n1)
        {
            case 1:
                JOptionPane.showMessageDialog(null, "Lunes");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Martes");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Miércoles");
                break;                
            case 4:
                JOptionPane.showMessageDialog(null, "Jueves");
                break;                
            case 5:
                JOptionPane.showMessageDialog(null, "Viernes");
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Sábado");
                break;
            case 7:
                JOptionPane.showMessageDialog(null, "Domingo");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error en el número introducido (1 al 7)");
                break;
        }}
        public static void Ejercicio_11()
        {
        JOptionPane.showMessageDialog(null, "Intro 3 números y te diré cúal es el mayor y el menor");
        String n1 = JOptionPane.showInputDialog("Introduzca número 1:");
        String n2 = JOptionPane.showInputDialog("Introduzca número 2:");
        String n3 = JOptionPane.showInputDialog("Introduzca número 3:");
        int m = Integer.parseInt(n1);
        int n = Integer.parseInt(n2);
        int nm = Integer.parseInt(n3);
        if (m>n)
        {
            if (m>nm)
            {
                if(nm<n)
                {
                JOptionPane.showMessageDialog(null, "el mayor es " + m + " y el menor es " + nm);
                }
                else
                {
                JOptionPane.showMessageDialog(null, "el mayor es " + m + " y el menor es " + n);
                }
            }
            else
            {
                if(m<n)
                {
                JOptionPane.showMessageDialog(null, "el mayor es " + nm + " y el menor es " + m);
                }
                else
                {
                JOptionPane.showMessageDialog(null, "el mayor es " + nm + " y el menor es " + n);
                }
            }
        }
        else
        {
            if(n>nm)
            {
                if (nm<m)
                {
                JOptionPane.showMessageDialog(null, "el mayor es " + n + " y el menor es " + m);
                }
                else
                {
                JOptionPane.showMessageDialog(null, "el mayor es " + n + " y el menor es " + nm);
                }
            }
            else
            {
                if(n<m)
                {
                JOptionPane.showMessageDialog(null, "el mayor es " + nm + " y el menor es " + n);
                }
                else
                {
                JOptionPane.showMessageDialog(null, "el mayor es " + nm + " y el menor es " + m);
                }
            }
        }
        }
        public static void Ejercicio_12()
        {
        double t=0, m=0;
        m = Double.parseDouble(JOptionPane.showInputDialog("Introduzca los minutos consumidos:"));
        final int tramouno=300;
        final int tramodos=500;
        final int tramotres=800;
        final double tarifauno=0.04;
        final double tarifados=0.03;
        final double tarifatres=0.02;
        final double descuento=1.25;
        
        if (m <= tramouno)
        {
            t = m * tarifauno;
        }
        else
        {
            if (m <= tramodos)
            {
            t = m * tarifados;
            }
            else
            {  
            t = tramouno * tarifados;
            m = m - tramouno;
            t = t + (m * tarifatres);
            m = m + tramouno;
            
            if (m >= tramotres)
            {
            t = t - (t/100*descuento);
            }
            }
        }
        JOptionPane.showMessageDialog(null, "Total a Pagar " + t);
        }
    public static void  Ejercicio_13()
    {
    int c = 0, h = 0, m = 0, v = 0;
    double peso = 0, edad = 0, estatura = 0;
    String nombre, sexo;
    v = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de niños"));
    while (c!=v)
    {
    nombre = JOptionPane.showInputDialog("Introduzca Nombre");
    sexo = JOptionPane.showInputDialog("Introduzca Sexo (H = hombre ; M = Mujer)");
    edad = Double.parseDouble(JOptionPane.showInputDialog("Introduzca Edad"));
    peso = Double.parseDouble(JOptionPane.showInputDialog("Introduzca Peso"));
    estatura = Double.parseDouble(JOptionPane.showInputDialog("Introduzca Estatura"));
    if (sexo.equals("H") & peso > 70 & estatura > 1.7)
    {
    h++;
    }
    else if (sexo.equals("M") & peso > 60 & estatura > 1.6)
    {
    m++;
    }
    c++;
    }
    JOptionPane.showMessageDialog(null, "Hay " + h + " niños aprobados y " + m + " niñas aprobadas.");
    }
    public static void Ejercicio_14()
    {
    int n=0;
    double s=0;
    while (n!=10)
    {
        n++;
        s = s + Double.parseDouble(JOptionPane.showInputDialog("Introduzca número a sumar"));
         }
    JOptionPane.showMessageDialog(null, "La suma total es " + s);
    }
    
    public static void Ejercicio_15()
    {
    suma();
    }
    static int r=0;
    public static void suma ()
    {
    double n=0;
    n = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduzca la nota del alumno"));
    if (n >= 6) r = r + 1; 
    pregunta();
    }
    public static void pregunta()
    {
    int resp = JOptionPane.showConfirmDialog(null,"¿Desea continuar?", "Notas",JOptionPane.YES_NO_OPTION,1);
    if (resp == JOptionPane.YES_OPTION) 
    {
    suma();
    }
    else
    {
    JOptionPane.showMessageDialog(null, "Han Aprobado " + r + " Alumno/s.");
    }
    }
    
    public static void Ejercicio_16()
    {
    sumas();
    }
    static double  e=0, p=0;
    static int rs=0;
    public static void sumas()
    {
    e = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca la edad"));
    rs++;
    p = p + e;
    preguntar();
    }
    public static void preguntar()
    {
    int resp = JOptionPane.showConfirmDialog(null,"¿Desea continuar?", "Notas",JOptionPane.YES_NO_OPTION,1);
    if (resp == JOptionPane.YES_OPTION) 
    {
    sumas();
    }
    else
    {
    p = p/rs;
    JOptionPane.showMessageDialog(null, "El promedio de " + rs + " alumnos es " + p + ".");
    }
    }
    public static void Ejercicio_17()
    {
    String mayor = "", menor = "", n = "";
    int c=0;
    Double nmayor= 0d, nmenor = 100d, nota;
    c = Integer.parseInt(JOptionPane.showInputDialog("Nº de alumnos a calcular:"));
    for(int cc=0; cc<c; cc++)
    {
    n = JOptionPane.showInputDialog("Introduzca el nombre del alumno:");
    nota = Double.parseDouble(JOptionPane.showInputDialog("Introduzca la nota del alumno:"));
    if (nota > nmayor)
    {
        nmayor = nota;
        mayor = n;
    }
        if (nota < nmenor)
    {
        nmenor = nota;
        menor = n;
    }
    }
    JOptionPane.showMessageDialog(null, "El alumno con mayor nota es " + mayor + " con " + nmayor + " y el menor es " + menor + " con " + nmenor);
    }
    public static void Ejercicio_18()
    {
    String t = "1";
    int c=0, n1=1, n2=0, n3=0;
    c = Integer.parseInt(JOptionPane.showInputDialog("Introduzca las veces de repeticiones para la serie Fibonacci:"));
    c=c-1;
    for(int c1 = 0; c1<c; c1++)
    {
    n3=n1+n2;
    n2=n1;
    n1=n3;
    t=t + "," + n3;
    }
    JOptionPane.showMessageDialog(null, "Los números son: " + t);
    }
    public static void Ejercicio_19()
    {
    int n1=0, n2=0, n3=0;
    n1 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número para calcular su cuadrado:"));
    n2=n1;
    while(n1!=0)
    {
    n3=n3+n2;
    n1=n1-1;
    }
    JOptionPane.showMessageDialog(null, "El cuadrado del número tecleado es " + n3);
    }
    public static void Ejercicio_20()
    {
    inicio();
    }
    static String n = "";
    static int ra=0;
    public static void inicio()
    {
    ra = (int) (Math.random()*100+1);
    adivinar();
    }
    public static void adivinar()
    {
    n = JOptionPane.showInputDialog("Adivina el número aleatorio:");
    if(n.equals("FIN"))
    {
        JOptionPane.showMessageDialog(null, "Has acertado!!!");
        System.exit(0);
    }
    else
    {
    acertado();
    }
    }
    
    public static void acertado()
    {
    if(Integer.parseInt(n) == ra)
    {
    n = "FIN";
    }
    else
    {
            if(Integer.parseInt(n) < ra)
            {
            JOptionPane.showMessageDialog(null, "Mete un número más grande.");
            }
            else
            {
            JOptionPane.showMessageDialog(null, "Mete un número más pequeño.");
            }
    adivinar();
    }
    }
    public static void Ejercicio_21() 
    {
    int n=0, n1=0, r=0;
    String f="";
    n = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número mayor que 2 y le diré SI es Primo o No es Primo:"));
    n1=n - 1;
    while(n1!=1)
    {
    r=n%n1;
    n1=n1-1;
    if(r==0)
    {
    f="NO";
    n1=1;
    }
    else
    {
    f="SI";
    }
    }    
    if(f.equals("SI"))
    {
    JOptionPane.showMessageDialog(null, "El número introducido SI es primo");
    }
    else
    {
    JOptionPane.showMessageDialog(null, "El número introducido NO es primo");
    }
    }
    
    public static void Ejercicio_22()
    {
    int n=0, n1=0, r=0,c=2;
    
    n = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número mayor que 2 y le mostraré todos los números Primo anteriores a él:"));
String f="", t="Los números Primos anteriores al "+n+" son: ";
    while(n!=2)
    {
    n=n-1;
    n1=n - 1;
    while(n1!=1)
    {
    r=n%n1;
    n1=n1-1;
    if(r==0)
    {
    f="NO";
    n1=1;
    }
    else
    {
    f="SI";
    }
    }    
    if(f.equals("SI"))
    {
    t = t + n + ", ";
    }
    }
    JOptionPane.showMessageDialog(null, t + ".");
    }}
