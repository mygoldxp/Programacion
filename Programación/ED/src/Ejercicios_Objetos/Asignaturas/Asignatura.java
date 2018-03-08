package Ejercicios_Objetos.Asignaturas;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Asignatura {
    
    public String Cod_Asignatura, Nombre_Asignatura, Grado;
    public float Num_Horas;
    public int Num_Alumnos, Curso;
    public Profesor tutor;
    
    public Asignatura(){
    }
    
    public Asignatura(String Cod_Asignatura, String Nombre_Asignatura,Profesor tutor, float Num_Horas,String Grado,  int Curso, int Num_Alumnos ){
        this.Cod_Asignatura = Cod_Asignatura;
        this.Nombre_Asignatura = Nombre_Asignatura; 
        this.Grado = Grado;
        this.Num_Horas = Num_Horas;
        this.Num_Alumnos = Num_Alumnos;
        this.Curso = Curso;
        this.tutor = tutor;
    }
    
    public void Calcular_Nota_Media(){
        ArrayList <Double> notas = new ArrayList();
        boolean cont = true;
        do{
            try{
                String x = JOptionPane.showInputDialog("Introduzca la nota:\nVacío para salir");
                if(x.equals("") || x.isEmpty()){
                    cont = false;
                }
                else{
                    notas.add(Double.parseDouble(x));
                }
            }
            catch(NullPointerException e){
                cont = false;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El formato ha de ser numérico.");
            }
        }
        while(cont);
        int x=0;
        Double y=0d;
        for(Double valor:notas){
            x++;
            y += valor;
        }
        JOptionPane.showMessageDialog(null, "La nota media es " + (y/x));
    }

    @Override
    public String toString() {
        return "La asignatura " + Nombre_Asignatura +" pertenece al curso curso del " + Grado + " grado, consta de " + Num_Horas + " horas y su tutor es " + tutor.getNombre();
    }

    public String getCod_Asignatura() {
        return Cod_Asignatura;
    }

    public void setCod_Asignatura(String Cod_Asignatura) {
        this.Cod_Asignatura = Cod_Asignatura;
    }

    public String getNombre_Asignatura() {
        return Nombre_Asignatura;
    }

    public void setNombre_Asignatura(String Nombre_Asignatura) {
        this.Nombre_Asignatura = Nombre_Asignatura;
    }

    public String getGrado() {
        return Grado;
    }

    public void setGrado(String Grado) {
        this.Grado = Grado;
    }

    public float getNum_Horas() {
        return Num_Horas;
    }

    public void setNum_Horas(float Num_Horas) {
        this.Num_Horas = Num_Horas;
    }

    public int getNum_Alumnos() {
        return Num_Alumnos;
    }

    public void setNum_Alumnos(int Num_Alumnos) {
        this.Num_Alumnos = Num_Alumnos;
    }

    public int getCurso() {
        return Curso;
    }

    public void setCurso(int Curso) {
        this.Curso = Curso;
    }

    public Profesor getTutor() {
        return tutor;
    }

    public void setTutor(Profesor tutor) {
        this.tutor = tutor;
    }
    
    
}
