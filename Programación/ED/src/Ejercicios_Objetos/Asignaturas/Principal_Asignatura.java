package Ejercicios_Objetos.Asignaturas;

import java.util.ArrayList;
import javax.swing.*;

public class Principal_Asignatura {
    
    public static ArrayList <Asignatura> asignas;
    
    public static void main (String arg []){
        asignas = new ArrayList();
        crearP();
        masjoven();
        horas();
        centro();
        horas1y2();
        media();
    }
    
    public static void crearP(){
        Profesor p1 = new Profesor("Asier", "Fraile Venegas",32 ,2);
        Profesor p2 = new Profesor("Facundo", "Ribaguda López",57 ,25);
        Profesor p3 = new Profesor("Inma", "García De la Fuente",45 ,10 );
        Profesor p4 = new Profesor("Iosu", "Blanco Aizkorbe",27 ,1);
        Profesor p5 = new Profesor("Irune", "Uriarte Agirre",35 ,4 );
        Profesor p6 = new Profesor("Unai", "Esnaola Alzola",30 ,1 );
        Profesor p7 = new Profesor("Eduardo", "Muñoz Apaolaza",40 ,3 );
        Profesor p8 = new Profesor("Asunción", "García Parral",52 ,27 );
        
        Asignatura a1 = new Asignatura("001","Matemáticas", p5, 140f,"ESO",2, 22);
        Asignatura a2 = new Asignatura("001","Lengua", p7, 130,"ESO",2,22 );
        Asignatura a3 = new Asignatura("001","Inglés", p6, 90,"ESO",2,22);
        Asignatura a4 = new Asignatura("001","Historia", p4, 100,"ESO",2,22);
        Asignatura a5 = new Asignatura("001","Geografía", p4, 30,"ESO",2,22);
        Asignatura a6 = new Asignatura("001","Ciencias Naturales", p3, 100,"ESO",2,22);
        Asignatura a7 = new Asignatura("001","Física", p5, 120,"ESO",2,22);
        Asignatura a8 = new Asignatura("001","Tecnología", p2, 80,"ESO",2,22);
        Asignatura a9 = new Asignatura("001","Informática", p2, 70,"ESO",2,22);
        Asignatura a10 = new Asignatura("001","Euskera", p1, 100,"ESO",2,22);
        Asignatura a11 = new Asignatura("001","Matemáticas", p5, 125,"ESO",1,22);
        Asignatura a12 = new Asignatura("001","Lengua", p7, 120,"ESO",1,22 );
        Asignatura a13 = new Asignatura("001","Inglés", p8, 90,"ESO",1,22);
        Asignatura a14 = new Asignatura("001","Historia", p4, 40,"ESO",1,22);
        Asignatura a15 = new Asignatura("001","Geografía", p8, 80,"ESO",1,22);
        Asignatura a16 = new Asignatura("001","Ciencias Naturales", p7, 100,"ESO",2,22);
        Asignatura a17 = new Asignatura("001","Física", p5, 50,"ESO",1,22);
        Asignatura a18 = new Asignatura("001","Tecnología", p1, 80,"ESO",1,22);
        Asignatura a19 = new Asignatura("001","Informática", p2, 40,"ESO",1,22);
        Asignatura a20 = new Asignatura("001","Euskera", p8, 120,"ESO",1,22);
        
        asignas.add(a1);
        asignas.add(a2);
        asignas.add(a3);
        asignas.add(a4);
        asignas.add(a5);
        asignas.add(a6);
        asignas.add(a7);
        asignas.add(a8);
        asignas.add(a9);
        asignas.add(a10);
        asignas.add(a11);
        asignas.add(a12);
        asignas.add(a13);
        asignas.add(a14);
        asignas.add(a15);
        asignas.add(a16);
        asignas.add(a17);
        asignas.add(a18);
        asignas.add(a19);
        asignas.add(a20);

    }
    
    public static void masjoven(){
        int x = 999;
        Profesor profe = new Profesor();
        for(int y=0; y<asignas.size(); y++)
        {
            if(asignas.get(y).getTutor().getEdad()<x){
                profe = asignas.get(y).getTutor();
                x = profe.getEdad();
            }
        }
        JOptionPane.showMessageDialog(null, "El profesor más jóven es " + profe.getNombre() + ", tiene " + profe.getEdad() + " años.");
    }
    public static void horas(){
        int t=0,p=0,i=0;
        for(int x=0; x<asignas.size(); x++){
            if(asignas.get(x).getTutor().Tipo_de_contrato().equals("Temporal")){
                t += asignas.get(x).getNum_Horas();
            }
            else if(asignas.get(x).getTutor().Tipo_de_contrato().equals("Indefinidos")){
                i += asignas.get(x).getNum_Horas();
            }
            else{
                p += asignas.get(x).getNum_Horas();
            }
        }
        
        JOptionPane.showMessageDialog(null, "Total de horas de profesores\nTemporales " + t +"\nIndefinidos " + i + "\nPrácticas " + p);
    }
    public static void centro(){
        
    }
    public static void horas1y2(){
        int pri=0, seg=0;
        for(int x=0; x<asignas.size(); x++){
            if(asignas.get(x).getCurso()==1){
                pri += asignas.get(x).getNum_Horas();
            }
            else{
                seg += asignas.get(x).getNum_Horas();
            }
        }
        
        JOptionPane.showMessageDialog(null, "Total de horas primer curso " + pri + " y segundo curso " + seg);
    }
    public static void media(){
        Asignatura notas = new Asignatura();
        
        notas.Calcular_Nota_Media();
    }
    
}
