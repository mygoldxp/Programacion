package Ejercicios_Objetos.Asignaturas;

public class Profesor {
    
    public String nombre, apellidos;
    public int edad, annos_centro;
    public Asignatura asignatura;
    
    public Profesor(){
        
    }
    
    public Profesor( String nombre, String apellidos, int edad, int annos_centro){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.annos_centro = annos_centro;
    }
    
    public String Tipo_de_contrato(){
        if(annos_centro <= 2){
            return "Prácticas";
        }
        else if(annos_centro > 5){
            return "Indefinidos";
        }
        else{
            return "Temporal";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAnnos_centro() {
        return annos_centro;
    }

    public void setAnnos_centro(int annos_centro) {
        this.annos_centro = annos_centro;
    }
    
    
}
